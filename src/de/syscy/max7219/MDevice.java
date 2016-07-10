package de.syscy.max7219;

import java.io.IOException;

import com.pi4j.io.spi.SpiChannel;
import com.pi4j.io.spi.SpiDevice;
import com.pi4j.io.spi.SpiFactory;
import com.pi4j.io.spi.SpiMode;

import de.syscy.max7219.util.Constants;
import de.syscy.max7219.util.Util;
import lombok.Getter;

public class MDevice {
	protected static final int NUM_DIGITS = 8;

	protected @Getter int cascadedDevices;
	protected @Getter boolean vertical;

	protected short[] buffer;

	protected SpiDevice spi;

	public MDevice() {
		this(1, SpiChannel.CS0, SpiDevice.DEFAULT_SPI_SPEED, SpiDevice.DEFAULT_SPI_MODE, false);
	}

	/**
	 * @param cascadedDevices The number of cascaded devices connected
	 */
	public MDevice(int cascadedDevices) {
		this(cascadedDevices, SpiChannel.CS0, SpiDevice.DEFAULT_SPI_SPEED, SpiDevice.DEFAULT_SPI_MODE, false);
	}

	/**
	 * @param vertical Set to true if the text should start from the header instead perpendicularly
	 */
	public MDevice(boolean vertical) {
		this(1, SpiChannel.CS0, SpiDevice.DEFAULT_SPI_SPEED, SpiDevice.DEFAULT_SPI_MODE, vertical);
	}

	/**
	 * @param cascadedDevices The number of cascaded devices connected
	 * @param vertical Set to true if the text should start from the header instead perpendicularly
	 */
	public MDevice(int cascadedDevices, boolean vertical) {
		this(cascadedDevices, SpiChannel.CS0, SpiDevice.DEFAULT_SPI_SPEED, SpiDevice.DEFAULT_SPI_MODE, vertical);
	}

	/**
	 * @param cascadedDevices The number of cascaded devices connected
	 * @param spiChannel
	 * @param spiDevice
	 * @param vertical Set to true if the text should start from the header instead perpendicularly
	 */
	public MDevice(int cascadedDevices, SpiChannel spiChannel, int spiDevice, SpiMode spiMode, boolean vertical) {
		this.cascadedDevices = cascadedDevices;
		this.vertical = vertical;

		if(this.cascadedDevices < 1) {
			throw new IllegalArgumentException("You need to have at least one device!");
		}

		try {
			spi = SpiFactory.getInstance(spiChannel, spiDevice, spiMode);
		} catch(IOException ex) {
			ex.printStackTrace();
		}

		this.buffer = new short[NUM_DIGITS * this.cascadedDevices];
	}

	/**
	 * Sends data to a specific register
	 * @param register The register
	 * @param data The data to send
	 */
	public void sendCommand(byte register, byte data) {
		if(register < Constants.MAX7219_REG_DECODEMODE || register > Constants.MAX7219_REG_DISPLAYTEST) {
			throw new IllegalArgumentException("Invalid register!");
		}

		for(int i = 0; i < cascadedDevices; i++) {
			write(register, data);
		}
	}

	protected void write(short... data) {
		try {
			this.spi.write(data);
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}

	protected short[] getValues(byte position, short[] buffer) {
		short[] result = new short[this.cascadedDevices * 2];

		for(int deviceID = 0, j = 0; deviceID < this.cascadedDevices; deviceID++) {
			result[j++] = (short) (Constants.MAX7219_REG_DIGIT0 + position);
			result[j++] = buffer[(deviceID * NUM_DIGITS) + position];
		}

		return result;
	}

	/**
	 * Clears all cascaded devices.
	 */
	public void clear() {
		this.clear(0);
	}

	/**
	 * Clears the buffer of specified device/all and then flushes
	 * @param deviceID The ID of the device to clear. Starts from 1, set to 0 to clear all cascaded devices (Exactly the same as clear()).
	 */
	public void clear(int deviceID) {
		if(deviceID < 0 || deviceID > this.cascadedDevices) {
			throw new IllegalArgumentException("Invalid device ID: " + deviceID);
		}

		int start, end;

		if(deviceID == 0) {
			start = 0;
			end = this.cascadedDevices;
		} else {
			start = deviceID;
			end = deviceID + 1;
		}

		for(int id = start; id < end; id++) {
			for(byte position = 0; position < NUM_DIGITS; position++) {
				setByte(id, (byte) (position + Constants.MAX7219_REG_DIGIT0), (short) 0, false);
			}
		}

		flush();
	}

	protected short[] preprocessBuffer(short[] buffer) {
		return buffer;
	}

	public void flush() {
		short[] buffer = preprocessBuffer(this.buffer.clone());

		if(buffer.length != this.buffer.length) {
			throw new IllegalStateException("Preprocessed buffer is wrong size");
		}

		if(this.vertical) {
			short[] tempBuffer = new short[buffer.length];

			for(int i = 0; i < this.cascadedDevices; i++) {
				short[] tempBuffer2 = new short[NUM_DIGITS];
				System.arraycopy(buffer, i * NUM_DIGITS, tempBuffer2, 0, NUM_DIGITS);
				tempBuffer2 = Util.rotate8x8(tempBuffer2);
				System.arraycopy(tempBuffer2, 0, tempBuffer, i * NUM_DIGITS, NUM_DIGITS);
			}

			buffer = tempBuffer;
		}

		for(byte position = 0; position < NUM_DIGITS; position++) {
			write(getValues(position, buffer));
		}
	}

	public void setBrightness(byte brightness) {
		if(brightness < 0 || brightness > 15) {
			throw new IllegalArgumentException("Invalid brightness: " + brightness);
		}

		sendCommand(Constants.MAX7219_REG_INTENSITY, brightness);
	}

	public void setByte(int deviceID, byte position, short value) {
		this.setByte(deviceID, position, value, true);
	}

	public void setByte(int deviceID, byte position, short value, boolean redraw) {
		if(deviceID < 0 || deviceID > this.cascadedDevices) {
			throw new IllegalArgumentException("Invalid device ID: " + deviceID);
		}

		if(position < Constants.MAX7219_REG_DIGIT0 || position > Constants.MAX7219_REG_DIGIT7) {
			throw new IllegalArgumentException("Invalid position: " + position);
		}

		if(value < 0 || value > 255) {
			throw new IllegalArgumentException("Invalid value: " + value);
		}

		int offset = (deviceID * NUM_DIGITS) + position - Constants.MAX7219_REG_DIGIT0;
		this.buffer[offset] = value;

		if(redraw) {
			flush();
		}
	}

	public void scrollLeft() {
		scrollLeft(false, true);
	}
	
	public void scrollLeft(boolean rotate) {
		scrollLeft(rotate, true);
	}

	public void scrollLeft(boolean rotate, boolean redraw) {
		short temp = this.buffer[this.buffer.length - 1];
		
		short[] tempArray = this.buffer.clone();
		
		System.arraycopy(tempArray, 1, this.buffer, 0, this.buffer.length - 1);
		
		if(rotate) this.buffer[this.buffer.length - 1] = temp;

		if(redraw) {
			flush();
		}
	}

	public void scrollRight() {
		scrollRight(true, true);
	}
	
	public void scrollRight(boolean rotate) {
		scrollRight(rotate, true);
	}

	public void scrollRight(boolean rotate, boolean redraw) {
		short temp = this.buffer[0];
		
		short[] tempArray = this.buffer.clone();
		
		System.arraycopy(tempArray, 0, this.buffer, 1, this.buffer.length - 1);

		if(rotate) this.buffer[0] = temp;

		if(redraw) {
			flush();
		}
	}
}
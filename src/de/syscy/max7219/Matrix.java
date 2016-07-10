package de.syscy.max7219;

import java.util.ArrayList;
import java.util.List;

import de.syscy.max7219.util.Constants;
import de.syscy.max7219.util.Font;
import de.syscy.max7219.util.Util;
import lombok.Getter;

public class Matrix extends MDevice {
	private @Getter boolean inverted = false;
	private @Getter int orientation = 0;

	public void drawLetter(int deviceID, short asciiCode) {
		this.drawLetter(deviceID, asciiCode, null, true);
	}

	public void drawLetter(int deviceID, short asciiCode, Font font) {
		this.drawLetter(deviceID, asciiCode, font, true);
	}

	public void drawLetter(int deviceID, short asciiCode, Font font, boolean redraw) {
		if(asciiCode < 0 || asciiCode > 255) {
			throw new IllegalArgumentException("Invalid ascii code: " + asciiCode);
		}

		if(font == null) {
			font = Font.DEFAULT;
		}

		int column = Constants.MAX7219_REG_DIGIT0;

		for(int value = 0; value < font.getLetter(asciiCode).length; value++) {
			if(column > Constants.MAX7219_REG_DIGIT7) {
				this.clear();

				throw new RuntimeException("Character " + asciiCode + " is too large!");
			}

			this.setByte(deviceID, (byte) column, font.getLetter(asciiCode)[value], redraw);
			column++;
		}

		if(redraw) {
			flush();
		}
	}

	public void scrollUp() {
		this.scrollUp(true);
	}

	public void scrollUp(boolean redraw) {
		for(int i = 0; i < buffer.length; i++) {
			buffer[i] = (short) (buffer[i] >> 1);
		}

		if(redraw) {
			flush();
		}
	}

	public void scrollDown() {
		this.scrollDown(true);
	}

	public void scrollDown(boolean redraw) {
		for(int i = 0; i < buffer.length; i++) {
			buffer[i] = (short) ((buffer[i] << 1) & 0xFF);
		}

		if(redraw) {
			flush();
		}
	}

	public void showMessage(String text) {
		this.showMessage(text, null);
	}

	public void showMessage(String text, Font font) {
		this.showMessage(text, font, true);
	}

	public void showMessage(String text, Font font, boolean proportional) {
		this.showMessage(text, font, proportional, 100);
	}

	public void showMessage(String text, Font font, boolean proportional, long delay) {
		if(font == null) {
			font = Font.DEFAULT;
		}

		StringBuffer textBuffer = new StringBuffer(text);

		for(int i = 0; i < cascadedDevices; i++) {
			textBuffer.append(' ');
		}

		List<Short> letterList = new ArrayList<>();

		for(char c : textBuffer.toString().toCharArray()) {
			for(short s : (proportional ? font.getProportionalLetter(c) : font.getLetter(c))) {
				letterList.add(s);
			}
		}

		for(short s : letterList) {
			try {
				Thread.sleep(delay);
			} catch(InterruptedException ex) {
			}

			this.scrollLeft(false, false);
			this.buffer[buffer.length - 1] = s;
			this.flush();
		}
	}

	public void setPixel(int x, int y, boolean value) {
		this.setPixel(x, y, value, true);
	}

	public void setPixel(int x, int y, boolean value, boolean redraw) {
		if(x < 0 || x >= buffer.length) {
			throw new IllegalArgumentException("Invalid x: " + x);
		}

		if(y < 0 || y >= NUM_DIGITS) {
			throw new IllegalArgumentException("Invalid y: " + y);
		}

		if(value) {
			this.buffer[x] |= (1 << y);
		} else {
			this.buffer[x] &= ~(1 << y);
		}

		if(redraw) {
			this.flush();
		}
	}

	private short[] rotate(short[] buffer) {
		short[] result = new short[buffer.length];

		for(int i = 0; i < this.cascadedDevices; i++) {
			short[] tile = new short[NUM_DIGITS];
			System.arraycopy(buffer, i * NUM_DIGITS, tile, 0, NUM_DIGITS);
			
			for(int j = 0; j < orientation; j += 90) {
				tile = Util.rotate8x8(tile);
			}
			
			System.arraycopy(tile, 0, result, i * NUM_DIGITS, NUM_DIGITS);
		}
		
		return result;
	}
	
	@Override
	protected short[] preprocessBuffer(short[] buffer) {
		if(this.inverted) {
			for(int x = 0; x < buffer.length; x++) {
				buffer[x] = (short) (~buffer[x] & 0xFF);
			}
		}
		
		if(this.orientation != 0) {
			buffer = rotate(buffer);
		}
		
		return super.preprocessBuffer(buffer);
	}
	

	public void invert(boolean inverted) {
		this.invert(inverted, true);
	}
	
	public void invert(boolean inverted, boolean redraw) {
		this.inverted = inverted;
		
		if(redraw) {
			flush();
		}
	}
	
	public void orientation(int angle) {
		this.orientation(angle, true);
	}
	
	public void orientation(int angle, boolean redraw) {
		if(angle < 0 || angle % 90 != 0) {
			throw new IllegalArgumentException("Invalid angle: " + angle);
		}
		
		this.orientation = angle;
		
		if(redraw) {
			flush();
		}
	}
}
package de.syscy.max7219;

import java.util.HashMap;
import java.util.Map;

public class SevenSegment extends MDevice {
	private static final Map<Integer, Character> radix = new HashMap<Integer, Character>();
	private static final Map<Character, Short> digits = new HashMap<Character, Short>();

	static {
		radix.put(8, 'o');
		radix.put(10, 'f');
		radix.put(16, 'x');

		digits.put(' ', (short) 0x00);
		digits.put('-', (short) 0x01);
		digits.put('0', (short) 0x7e);
		digits.put('1', (short) 0x30);
		digits.put('2', (short) 0x6d);
		digits.put('3', (short) 0x79);
		digits.put('4', (short) 0x33);
		digits.put('5', (short) 0x5b);
		digits.put('6', (short) 0x5f);
		digits.put('7', (short) 0x70);
		digits.put('8', (short) 0x7f);
		digits.put('9', (short) 0x7b);
		digits.put('a', (short) 0x77);
		digits.put('b', (short) 0x1f);
		digits.put('c', (short) 0x4e);
		digits.put('d', (short) 0x3d);
		digits.put('e', (short) 0x4f);
		digits.put('f', (short) 0x47);
	}
	
	//TODO
}
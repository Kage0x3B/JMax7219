package de.syscy.max7219.util;

public class Util {
	private static long[][] ltable = new long[][] { generateSubTable(7), generateSubTable(6), generateSubTable(5), generateSubTable(4), generateSubTable(3), generateSubTable(2), generateSubTable(1), generateSubTable(0) };

	private static long[] generateSubTable(int n) {
		//@formatter:off
		return new long[] { 0x00000000 << n, 0x00000001 << n, 0x00000100 << n, 0x00000101 << n,
						   0x00010000 << n, 0x00010001 << n, 0x00010100 << n, 0x00010101 << n,
						   0x01000000 << n, 0x01000001 << n, 0x01000100 << n, 0x01000101 << n,
						   0x01010000 << n, 0x01010001 << n, 0x01010100 << n, 0x01010101 << n };
		//@formatter:on
	}

	public static short[] rotate8x8(short[] src) {
		if(src.length != 8) {
			throw new IllegalStateException("Invalid array size: " + src.length);
		}

		long low = 0;
		long high = 0;

		for(int i = 0; i < 8; i++) {
			short value = src[i];

			if(value < 0 || value > 255) {
				throw new IllegalArgumentException("Invalid value: " + value);
			}

			low |= ltable[i][value & 0x0F];
			high |= ltable[i][value >> 4];
		}
		
		short[] result = new short[8];
		
		int j = 0;

		for(int i = 0; i <= 24; i += 8) {
			result[j++] = (short) (low >> i & 0xFF);
		}
		
		for(int i = 0; i <= 24; i += 8) {
			result[j++] = (short) (high >> i & 0xFF);
		}

		return result;
	}
}
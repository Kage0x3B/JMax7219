package de.syscy.max7219.util;

import de.syscy.max7219.util.fonts.CP437Font;
import de.syscy.max7219.util.fonts.LCDFont;
import de.syscy.max7219.util.fonts.SinclairFont;
import de.syscy.max7219.util.fonts.TinyFont;
import de.syscy.max7219.util.fonts.UKRFont;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Font {
	public static final Font CP437 = new CP437Font();
	public static final Font SINCLAIR = new SinclairFont();
	public static final Font LCD = new LCDFont();
	public static final Font UKR = new UKRFont(); //Cyrillic Ukrainian font
	public static final Font TINY = new TinyFont();

	public static final Font DEFAULT = CP437;
	
	private final short[][] letters;
	
	public short[] getLetter(short asciiCode) {
		return getLetter((char) asciiCode);
	}
	
	public short[] getLetter(char c) {
		return letters[c].clone();
	}
	
	public short[] getProportionalLetter(short asciiCode) {
		return getProportionalLetter((char) asciiCode);
	}
	
	public short[] getProportionalLetter(char c) {
		short[] letterArray = getLetter(c);
		
		if(c == ' ') {
			return letterArray;
		} else {
			return trim(letterArray);
		}
	}
	
	private short[] trim(short[] letterArray) {
		int first = 0;
		boolean firstSet = false;
		int last = letterArray.length;
		
		for(int i = 0; i < letterArray.length; i++) {
			if(letterArray[i] != 0 && !firstSet) {
				first = i;
				firstSet = true;
			}
			
			if(letterArray[i] != 0 && last < i) {
				last = letterArray.length;
			}
			
			if(letterArray[i] == 0 && firstSet && last > i) {
				last = i;
			}
		}
		
		short[] result = new short[last - first + (last < letterArray.length ? 1 : 0)];
			
		System.arraycopy(letterArray, first, result, 0, last - first + (last < letterArray.length ? 1 : 0));
		
		return result;
	}
}
package de.syscy.max7219.util.fonts;

import de.syscy.max7219.util.Font;

public class TinyFont extends Font {
	//@formatter:off
	private static short[][] letters = {{0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x2E, 0x00, 0x00},
									    {0x06, 0x00, 0x06, 0x00},
									    {0x3E, 0x14, 0x3E, 0x00},
									    {0x14, 0x3E, 0x14, 0x00},
									    {0x34, 0x08, 0x16, 0x00},
									    {0x34, 0x2A, 0x3A, 0x00},
									    {0x00, 0x06, 0x00, 0x00},
									    {0x1C, 0x22, 0x00, 0x00},
									    {0x00, 0x22, 0x1C, 0x00},
									    {0x14, 0x08, 0x14, 0x00},
									    {0x08, 0x1C, 0x08, 0x00},
									    {0x00, 0x30, 0x00, 0x00},
									    {0x08, 0x08, 0x08, 0x00},
									    {0x00, 0x20, 0x00, 0x00},
									    {0x30, 0x08, 0x06, 0x00},
									    {0x1C, 0x22, 0x1C, 0x00},
									    {0x24, 0x3E, 0x20, 0x00},
									    {0x32, 0x2A, 0x24, 0x00},
									    {0x22, 0x2A, 0x14, 0x00},
									    {0x0E, 0x08, 0x3E, 0x00},
									    {0x2E, 0x2A, 0x12, 0x00},
									    {0x3E, 0x2A, 0x3A, 0x00},
									    {0x02, 0x3A, 0x06, 0x00},
									    {0x3E, 0x2A, 0x3E, 0x00},
									    {0x2E, 0x2A, 0x3E, 0x00},
									    {0x00, 0x14, 0x00, 0x00},
									    {0x00, 0x34, 0x00, 0x00},
									    {0x08, 0x14, 0x22, 0x00},
									    {0x14, 0x14, 0x14, 0x00},
									    {0x22, 0x14, 0x08, 0x00},
									    {0x02, 0x2A, 0x06, 0x00},
									    {0x1C, 0x2A, 0x1C, 0x00},
									    {0x3C, 0x0A, 0x3C, 0x00},
									    {0x3E, 0x2A, 0x14, 0x00},
									    {0x1C, 0x22, 0x22, 0x00},
									    {0x3E, 0x22, 0x1C, 0x00},
									    {0x3E, 0x2A, 0x22, 0x00},
									    {0x3E, 0x0A, 0x02, 0x00},
									    {0x1C, 0x22, 0x3A, 0x00},
									    {0x3E, 0x08, 0x3E, 0x00},
									    {0x22, 0x3E, 0x22, 0x00},
									    {0x32, 0x22, 0x3E, 0x00},
									    {0x3E, 0x08, 0x36, 0x00},
									    {0x3E, 0x20, 0x20, 0x00},
									    {0x3E, 0x0C, 0x3E, 0x00},
									    {0x3C, 0x02, 0x3E, 0x00},
									    {0x3E, 0x22, 0x3E, 0x00},
									    {0x3E, 0x0A, 0x0E, 0x00},
									    {0x1E, 0x12, 0x3E, 0x00},
									    {0x3E, 0x0A, 0x36, 0x00},
									    {0x2E, 0x2A, 0x3A, 0x00},
									    {0x02, 0x3E, 0x02, 0x00},
									    {0x3E, 0x20, 0x3E, 0x00},
									    {0x1E, 0x20, 0x1E, 0x00},
									    {0x3E, 0x18, 0x3E, 0x00},
									    {0x36, 0x08, 0x36, 0x00},
									    {0x0E, 0x38, 0x0E, 0x00},
									    {0x32, 0x2A, 0x26, 0x00},
									    {0x3E, 0x22, 0x00, 0x00},
									    {0x06, 0x08, 0x30, 0x00},
									    {0x00, 0x22, 0x3E, 0x00},
									    {0x04, 0x02, 0x04, 0x00},
									    {0x20, 0x20, 0x20, 0x00},
									    {0x00, 0x02, 0x04, 0x00},
									    {0x10, 0x2A, 0x3C, 0x00},
									    {0x3E, 0x28, 0x10, 0x00},
									    {0x18, 0x24, 0x24, 0x00},
									    {0x10, 0x28, 0x3E, 0x00},
									    {0x1C, 0x2A, 0x2C, 0x00},
									    {0x00, 0x3C, 0x0A, 0x00},
									    {0x04, 0x2A, 0x3E, 0x00},
									    {0x3E, 0x08, 0x38, 0x00},
									    {0x00, 0x3A, 0x00, 0x00},
									    {0x20, 0x3A, 0x00, 0x00},
									    {0x3C, 0x10, 0x28, 0x00},
									    {0x00, 0x3C, 0x00, 0x00},
									    {0x3C, 0x08, 0x3C, 0x00},
									    {0x38, 0x04, 0x38, 0x00},
									    {0x18, 0x24, 0x18, 0x00},
									    {0x3C, 0x14, 0x08, 0x00},
									    {0x08, 0x14, 0x3C, 0x00},
									    {0x3C, 0x08, 0x04, 0x00},
									    {0x28, 0x3C, 0x14, 0x00},
									    {0x08, 0x3C, 0x28, 0x00},
									    {0x3C, 0x20, 0x3C, 0x00},
									    {0x1C, 0x20, 0x1C, 0x00},
									    {0x3C, 0x10, 0x3C, 0x00},
									    {0x24, 0x18, 0x24, 0x00},
									    {0x0C, 0x28, 0x3C, 0x00},
									    {0x24, 0x34, 0x2C, 0x00},
									    {0x14, 0x2A, 0x00, 0x00},
									    {0x00, 0x3E, 0x00, 0x00},
									    {0x00, 0x2A, 0x14, 0x00},
									    {0x04, 0x04, 0x0C, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00},
									    {0x00, 0x00, 0x00, 0x00}};
	//@formatter:on
	public TinyFont() {
		super(letters);
	}
}
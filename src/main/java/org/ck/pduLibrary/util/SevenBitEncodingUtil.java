package org.ck.pduLibrary.util;

import java.util.ArrayList;
import java.util.List;

public class SevenBitEncodingUtil
{

	protected static final char[] stdAlphabet = {
			'@', // COMMERCIAL AT
			'£', // POUND SIGN
			'$', // DOLLAR SIGN
			'¥', // YEN SIGN
			'è', // LATIN SMALL LETTER E WITH GRAVE
			'é', // LATIN SMALL LETTER E WITH ACUTE
			'ù', // LATIN SMALL LETTER U WITH GRAVE
			'ì', // LATIN SMALL LETTER I WITH GRAVE
			'ò', // LATIN SMALL LETTER O WITH GRAVE
			'ç', // LATIN SMALL LETTER C WITH CEDILLA
			'\n', // LINE FEED
			'Ø', // LATIN CAPITAL LETTER O WITH STROKE
			'ø', // LATIN SMALL LETTER O WITH STROKE
			'\r', // CARRIAGE RETURN
			'Å', // LATIN CAPITAL LETTER A WITH RING ABOVE
			'å', // LATIN SMALL LETTER A WITH RING ABOVE
			'\u0394', // GREEK CAPITAL LETTER DELTA
			'_', // LOW LINE
			'\u03A6', // GREEK CAPITAL LETTER PHI
			'\u0393', // GREEK CAPITAL LETTER GAMMA
			'\u039B', // GREEK CAPITAL LETTER LAMDA
			'\u03A9', // GREEK CAPITAL LETTER OMEGA
			'\u03A0', // GREEK CAPITAL LETTER PI
			'\u03A8', // GREEK CAPITAL LETTER PSI
			'\u03A3', // GREEK CAPITAL LETTER SIGMA
			'\u0398', // GREEK CAPITAL LETTER THETA
			'\u039E', // GREEK CAPITAL LETTER XI
			'\u00A0', // ESCAPE TO EXTENSION TABLE (or displayed as NBSP, see
			// note
			// above)
			'Æ', // LATIN CAPITAL LETTER AE
			'æ', // LATIN SMALL LETTER AE
			'ß', // LATIN SMALL LETTER SHARP S (German)
			'É', // LATIN CAPITAL LETTER E WITH ACUTE
			' ', // SPACE
			'!', // EXCLAMATION MARK
			'"', // QUOTATION MARK
			'#', // NUMBER SIGN
			'¤', // CURRENCY SIGN
			'%', // PERCENT SIGN
			'&', // AMPERSAND
			'\'', // APOSTROPHE
			'(', // LEFT PARENTHESIS
			')', // RIGHT PARENTHESIS
			'*', // ASTERISK
			'+', // PLUS SIGN
			',', // COMMA
			'-', // HYPHEN-MINUS
			'.', // FULL STOP
			'/', // SOLIDUS
			'0', // DIGIT ZERO
			'1', // DIGIT ONE
			'2', // DIGIT TWO
			'3', // DIGIT THREE
			'4', // DIGIT FOUR
			'5', // DIGIT FIVE
			'6', // DIGIT SIX
			'7', // DIGIT SEVEN
			'8', // DIGIT EIGHT
			'9', // DIGIT NINE
			':', // COLON
			';', // SEMICOLON
			'<', // LESS-THAN SIGN
			'=', // EQUALS SIGN
			'>', // GREATER-THAN SIGN
			'?', // QUESTION MARK
			'¡', // INVERTED EXCLAMATION MARK
			'A', // LATIN CAPITAL LETTER A
			'B', // LATIN CAPITAL LETTER B
			'C', // LATIN CAPITAL LETTER C
			'D', // LATIN CAPITAL LETTER D
			'E', // LATIN CAPITAL LETTER E
			'F', // LATIN CAPITAL LETTER F
			'G', // LATIN CAPITAL LETTER G
			'H', // LATIN CAPITAL LETTER H
			'I', // LATIN CAPITAL LETTER I
			'J', // LATIN CAPITAL LETTER J
			'K', // LATIN CAPITAL LETTER K
			'L', // LATIN CAPITAL LETTER L
			'M', // LATIN CAPITAL LETTER M
			'N', // LATIN CAPITAL LETTER N
			'O', // LATIN CAPITAL LETTER O
			'P', // LATIN CAPITAL LETTER P
			'Q', // LATIN CAPITAL LETTER Q
			'R', // LATIN CAPITAL LETTER R
			'S', // LATIN CAPITAL LETTER S
			'T', // LATIN CAPITAL LETTER T
			'U', // LATIN CAPITAL LETTER U
			'V', // LATIN CAPITAL LETTER V
			'W', // LATIN CAPITAL LETTER W
			'X', // LATIN CAPITAL LETTER X
			'Y', // LATIN CAPITAL LETTER Y
			'Z', // LATIN CAPITAL LETTER Z
			'Ä', // LATIN CAPITAL LETTER A WITH DIAERESIS
			'Ö', // LATIN CAPITAL LETTER O WITH DIAERESIS
			'Ñ', // LATIN CAPITAL LETTER N WITH TILDE
			'Ü', // LATIN CAPITAL LETTER U WITH DIAERESIS
			'§', // SECTION SIGN
			'¿', // INVERTED QUESTION MARK
			'a', // LATIN SMALL LETTER A
			'b', // LATIN SMALL LETTER B
			'c', // LATIN SMALL LETTER C
			'd', // LATIN SMALL LETTER D
			'e', // LATIN SMALL LETTER E
			'f', // LATIN SMALL LETTER F
			'g', // LATIN SMALL LETTER G
			'h', // LATIN SMALL LETTER H
			'i', // LATIN SMALL LETTER I
			'j', // LATIN SMALL LETTER J
			'k', // LATIN SMALL LETTER K
			'l', // LATIN SMALL LETTER L
			'm', // LATIN SMALL LETTER M
			'n', // LATIN SMALL LETTER N
			'o', // LATIN SMALL LETTER O
			'p', // LATIN SMALL LETTER P
			'q', // LATIN SMALL LETTER Q
			'r', // LATIN SMALL LETTER R
			's', // LATIN SMALL LETTER S
			't', // LATIN SMALL LETTER T
			'u', // LATIN SMALL LETTER U
			'v', // LATIN SMALL LETTER V
			'w', // LATIN SMALL LETTER W
			'x', // LATIN SMALL LETTER X
			'y', // LATIN SMALL LETTER Y
			'z', // LATIN SMALL LETTER Z
			'ä', // LATIN SMALL LETTER A WITH DIAERESIS
			'ö', // LATIN SMALL LETTER O WITH DIAERESIS
			'ñ', // LATIN SMALL LETTER N WITH TILDE
			'ü', // LATIN SMALL LETTER U WITH DIAERESIS
			'à', // LATIN SMALL LETTER A WITH GRAVE
	};

	public static String valueOf(Integer nibblesUsed, byte[] bytes)
	{
		StringBuilder stringBuilder = new StringBuilder();

		Integer remainderBits = 0;
		Integer currentByte = 0;

		for (Integer i = 0; i < (int) Math.floor(nibblesUsed * 4 / 7); ++i)
		{
			byte bitMaskHelper = (byte) (Math.pow(2.0, 7.0 - remainderBits) - 1);

			byte currentChar;
			if (currentByte < bytes.length)
			{
				currentChar = (byte) (bytes[currentByte] & bitMaskHelper);
			}
			else
			{
				currentChar = 0x0;
			}

			if (remainderBits != 0)
			{
				byte remainingByte = (byte) (bytes[currentByte - 1] & ((byte) (((byte) 0xFF) ^ bitMaskHelper)));

				currentChar = (byte) (currentChar << remainderBits);
				currentChar = (byte) (currentChar |
						((((byte) Math.pow(2, remainderBits)) - 1) & (remainingByte >> (8 - remainderBits))));
			}

			remainderBits = (remainderBits + 1) % 8;
			if (remainderBits != 0)
			{
				currentByte++;
			}

			stringBuilder.append(stdAlphabet[currentChar]);
		}

		return stringBuilder.toString();
	}
	
	public static byte[] valueOf(String text)
	{
		List<Byte> bytes = new ArrayList<Byte>();
//		Byte currentByte = new Byte((byte)0);
//		Integer remainderBits = 8;
		
		for (Integer i = 0; i < text.length(); ++i)
		{
			// TODO
		}
		
		byte[] result = new byte[bytes.size()];
		for (Integer i = 0; i < bytes.size(); ++i)
		{
			result[i] = bytes.get(i);
		}
		
		return result;
	}

}

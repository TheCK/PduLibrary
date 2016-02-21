package org.ck.pduLibrary.util;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class ByteUtil
{

	public static Integer convertUnsignedByteToInteger(byte input)
	{
		return input & 0xFF;
	}

	public static byte[] convertIntegerToUnsignedBytes(Integer input)
	{
		ByteBuffer bb = ByteBuffer.allocate(4);
		bb.putInt(input);
		byte[] paddedBytes = bb.array();

		Integer position = getFirstUsedByte(paddedBytes);

		return Arrays.copyOfRange(paddedBytes, position, 4);
	}

	private static Integer getFirstUsedByte(byte[] paddedBytes)
	{
		Integer position = 0;
		for (byte temp : paddedBytes)
		{
			if (temp != 0 || position == 3)
			{
				break;
			}
			position++;
		}
		return position;
	}
}

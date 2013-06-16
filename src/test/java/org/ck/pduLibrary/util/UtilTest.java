package org.ck.pduLibrary.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class UtilTest
{

	@Test
	public void testConvertUnsignedByteToInteger()
	{
		byte test = 0;
		
		for (Integer i = 0; i <= 255; ++i)
		{
			assertEquals(i, Util.convertUnsignedByteToInteger(test++));
		}
	}
	
	@Test
	public void testConvertIntegerToUnsignedBytes()
	{
		for (Integer i = 0; i < 65536; ++i)
		{
			byte[] result = Util.convertIntegerToUnsignedBytes(i);
			
			assertNotNull(result);
			
			if (i < 256)
			{
				assertEquals(1, result.length);
			}
			else
			{
				assertEquals(2, result.length);
			}
			
			if (i < 256)
			{
				assertEquals((byte) (int) i, result[0]);
			}
			else
			{
				assertEquals((byte) (int) ((int) i / (int) 256), (byte) result[0]);
				assertEquals((byte) (int) ((int) i % (int) 256), (byte) result[1]);
			}
		}
	}
	
}

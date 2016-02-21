package org.ck.pduLibrary.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

@SuppressWarnings("static-method")
public class ByteUtilTest
{

	@Test
	public void testConvertUnsignedByteToInteger()
	{
		byte test = 0;
		
		for (Integer i = 0; i <= 255; ++i)
		{
			assertEquals(i, ByteUtil.convertUnsignedByteToInteger(test++));
		}
	}
	
	@Test
	public void testConvertIntegerToUnsignedBytes()
	{
		for (Integer i = 0; i < 65536; ++i)
		{
			byte[] result = ByteUtil.convertIntegerToUnsignedBytes(i);
			
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
				assertEquals((byte) (i / 256), result[0]);
				assertEquals((byte) (i % 256), result[1]);
			}
		}
	}
	
}

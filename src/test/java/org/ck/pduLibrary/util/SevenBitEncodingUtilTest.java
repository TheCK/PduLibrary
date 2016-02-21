package org.ck.pduLibrary.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

@SuppressWarnings("static-method")
public class SevenBitEncodingUtilTest
{

	@Test
	public void test()
	{
		assertEquals(
				"diafaan",
				SevenBitEncodingUtil.valueOf(13, new byte[] { (byte) 0xE4, 0x74, (byte) 0xD8, 0x1C,
						0x0E, (byte) 0xBB, 0x01 }));
	}
	
	@Test
	public void foo()
	{
		for (char c : SevenBitEncodingUtil.stdAlphabet)
		{
			System.out.println(c);
		}
	}

}

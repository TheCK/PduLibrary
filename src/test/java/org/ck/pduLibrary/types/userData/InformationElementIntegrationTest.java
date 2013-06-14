package org.ck.pduLibrary.types.userData;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.ck.pduLibrary.types.userData.informationElement.Concatenation8BitElement;
import org.junit.Test;

public class InformationElementIntegrationTest
{

	@Test
	public void testNoInput()
	{
		assertNull(InformationElement.valueOf(null));
	}
	
	@Test
	public void testEmptyInput()
	{
		assertNull(InformationElement.valueOf(new byte[]{}));
	}
	
	@Test
	public void testWithInvalidElement()
	{
		assertNull(InformationElement.valueOf(new byte[]{(byte) 0xFF}));
	}
	
	@Test
	public void testWithValidElement()
	{
		InformationElement informationElement = InformationElement.valueOf(new byte[]{0x00});
		
		assertTrue(Concatenation8BitElement.class.isAssignableFrom(informationElement.getClass()));
	}
	
}

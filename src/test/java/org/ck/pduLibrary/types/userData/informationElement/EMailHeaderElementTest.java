package org.ck.pduLibrary.types.userData.informationElement;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

@SuppressWarnings("static-method")
public class EMailHeaderElementTest
{

	@Test
	public void testConstructorSuccessful()
	{
		EMailHeaderElement result = new EMailHeaderElement(2);

		assertEquals((Integer) 2, result.getEMailHeaderLengthIndicator());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorNegativeEMailHeaderLengthIndicator()
	{
		new EMailHeaderElement(-1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorTooBigEMailHeaderLengthIndicator()
	{
		new EMailHeaderElement(300);
	}
	
	@Test
	public void testGetLength()
	{
		assertEquals((Integer) 1, (new EMailHeaderElement(2)).getLength());
	}
	
	@Test
	public void testIsRepeatable()
	{
		assertFalse((new EMailHeaderElement(3)).isRepeatable());
	}
	
	@Test
	public void testAsByteArray()
	{
		assertArrayEquals(new byte[]{5}, (new EMailHeaderElement(5)).asByteArray());
	}
	
	@Test
	public void testValueOfSuccess()
	{
		EMailHeaderElement result = EMailHeaderElement.valueOf(new byte[]{4});
		
		assertEquals((Integer) 4, result.getEMailHeaderLengthIndicator()); 
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testValueOfNoInput()
	{
		EMailHeaderElement.valueOf(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testValueOfEmptyInput()
	{
		EMailHeaderElement.valueOf(new byte[]{});
	}

}

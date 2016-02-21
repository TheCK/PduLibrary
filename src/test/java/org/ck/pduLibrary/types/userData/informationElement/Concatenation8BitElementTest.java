package org.ck.pduLibrary.types.userData.informationElement;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

@SuppressWarnings("static-method")
public class Concatenation8BitElementTest
{

	@Test(expected=IllegalArgumentException.class)
	public void testValueOfNoInput()
	{
		Concatenation8BitElement.valueOf(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testValueOfEmptyInput()
	{
		Concatenation8BitElement.valueOf(new byte[]{});
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValueOfInvalidCurrentPart()
	{
		Concatenation8BitElement.valueOf(new byte[]{1, 2, 3});
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValueOfInvalidCurrentPart0()
	{
		Concatenation8BitElement.valueOf(new byte[]{1, 2, 0});
	}
	
	@Test
	public void testValueOfSuccess()
	{
		Concatenation8BitElement result = Concatenation8BitElement.valueOf(new byte[]{1, 3, 2});
		
		assertEquals((Integer) 1, result.getReferenceNumber());
		assertEquals((Integer) 3, result.getTotalParts());
		assertEquals((Integer) 2, result.getCurrentPart());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorNegativeReferenceNumber()
	{
		new Concatenation8BitElement(-1, 100, 100);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorInvalidReferenceNumber()
	{
		new Concatenation8BitElement(300, 100, 100);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorNegativeTotalParts()
	{
		new Concatenation8BitElement(100, -1, 100);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorInvalidTotalParts()
	{
		new Concatenation8BitElement(100, 300, 100);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorInvalidCurrentPart()
	{
		new Concatenation8BitElement(100, 100, 300);
	}
	
	@Test
	public void testGetLenght()
	{
		assertEquals((Integer) 3, (new Concatenation8BitElement(1, 1, 1)).getLength());
	}
	
	@Test
	public void testIsRepeatable()
	{
		assertFalse((new Concatenation8BitElement(1, 1, 1)).isRepeatable());
	}
	
	@Test
	public void testAsByteArray()
	{
		assertArrayEquals(new byte[]{123, 42, 23}, (new Concatenation8BitElement(123, 42, 23)).asByteArray());
	}
	
}

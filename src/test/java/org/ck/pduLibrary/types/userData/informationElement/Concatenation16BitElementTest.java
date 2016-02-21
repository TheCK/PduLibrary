package org.ck.pduLibrary.types.userData.informationElement;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

@SuppressWarnings("static-method")
public class Concatenation16BitElementTest
{

	@Test(expected=IllegalArgumentException.class)
	public void testValueOfNoInput()
	{
		Concatenation16BitElement.valueOf(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testValueOfEmptyInput()
	{
		Concatenation16BitElement.valueOf(new byte[]{});
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValueOfInvalidCurrentPart()
	{
		Concatenation16BitElement.valueOf(new byte[]{0, 1, 2, 3});
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValueOfInvalidCurrentPart0()
	{
		Concatenation16BitElement.valueOf(new byte[]{0, 1, 2, 0});
	}
	
	@Test
	public void testValueOfSuccess()
	{
		Concatenation16BitElement result = Concatenation16BitElement.valueOf(new byte[]{2, 1, 3, 2});
		
		assertEquals((Integer) 513, result.getReferenceNumber());
		assertEquals((Integer) 3, result.getTotalParts());
		assertEquals((Integer) 2, result.getCurrentPart());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorNegativeReferenceNumber()
	{
		new Concatenation16BitElement(-1, 100, 100);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorInvalidReferenceNumber()
	{
		new Concatenation16BitElement(300000, 100, 100);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorNegativeTotalParts()
	{
		new Concatenation16BitElement(100, -1, 100);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorInvalidTotalParts()
	{
		new Concatenation16BitElement(100, 300, 100);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorZeroCurrentPart()
	{
		new Concatenation16BitElement(100, 100, 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorInvalidCurrentPart()
	{
		new Concatenation16BitElement(100, 100, 300);
	}
	

	
	@Test
	public void testGetLenght()
	{
		assertEquals((Integer) 4, (new Concatenation16BitElement(1, 1, 1)).getLength());
	}
	
	@Test
	public void testIsRepeatable()
	{
		assertFalse((new Concatenation16BitElement(1, 1, 1)).isRepeatable());
	}
	
	@Test
	public void testAsByteArrayOneByte()
	{
		assertArrayEquals(new byte[]{0, 123, 42, 23}, (new Concatenation16BitElement(123, 42, 23)).asByteArray());
	}
	
	@Test
	public void testAsByteArrayTwoByte()
	{
		assertArrayEquals(new byte[]{2, 1, 42, 23}, (new Concatenation16BitElement(513, 42, 23)).asByteArray());
	}
	
}

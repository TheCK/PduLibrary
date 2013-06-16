package org.ck.pduLibrary.types.userData.informationElement;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class ApplicationPortAddressingScheme16BitElementTest
{

	@Test
	public void testConstructorSuccess()
	{
		ApplicationPortAddressingScheme16BitElement result = new ApplicationPortAddressingScheme16BitElement(2, 3);

		assertEquals((Integer) 2, result.getDestinationPort());
		assertEquals((Integer) 3, result.getOriginatorPort());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testContructorNegativeDestinationPort()
	{
		new ApplicationPortAddressingScheme16BitElement(-1, 3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testContructorTooBigDestinationPort()
	{
		new ApplicationPortAddressingScheme16BitElement(300000, 3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testContructorNegativeOriginatorPort()
	{
		new ApplicationPortAddressingScheme16BitElement(2, -1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testContructorTooBigOriginatorPort()
	{
		new ApplicationPortAddressingScheme16BitElement(2, 300000);
	}

	@Test
	public void testGetLength()
	{
		assertEquals((Integer) 4, (new ApplicationPortAddressingScheme16BitElement(1, 1)).getLength());
	}

	@Test
	public void testIsRepeatable()
	{
		assertFalse((new ApplicationPortAddressingScheme16BitElement(1, 1)).isRepeatable());
	}

	@Test
	public void testAsByteArraySingleBytePorts()
	{
		assertArrayEquals(new byte[] { 0, 2, 0, 3 },
				(new ApplicationPortAddressingScheme16BitElement(2, 3)).asByteArray());
	}

	@Test
	public void testAsByteArrayDoubleBytePorts()
	{
		assertArrayEquals(new byte[] { 1, 2, 2, 3 },
				(new ApplicationPortAddressingScheme16BitElement(258, 515)).asByteArray());
	}
	
	@Test
	public void testValueOfSuccess()
	{
		ApplicationPortAddressingScheme16BitElement result =
				ApplicationPortAddressingScheme16BitElement.valueOf(new byte[] { 1, 4, 2, 5 });

		assertEquals((Integer) 260, result.getDestinationPort());
		assertEquals((Integer) 517, result.getOriginatorPort());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValueOfNoInput()
	{
		ApplicationPortAddressingScheme16BitElement.valueOf(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValueOfEmptyInput()
	{
		ApplicationPortAddressingScheme16BitElement.valueOf(new byte[] {});
	}

}

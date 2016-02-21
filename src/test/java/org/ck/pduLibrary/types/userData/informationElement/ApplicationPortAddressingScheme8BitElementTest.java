package org.ck.pduLibrary.types.userData.informationElement;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

@SuppressWarnings("static-method")
public class ApplicationPortAddressingScheme8BitElementTest
{

	@Test
	public void testConstructorSuccess()
	{
		ApplicationPortAddressingScheme8BitElement result = new ApplicationPortAddressingScheme8BitElement(2, 3);

		assertEquals((Integer) 2, result.getDestinationPort());
		assertEquals((Integer) 3, result.getOriginatorPort());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testContructorNegativeDestinationPort()
	{
		new ApplicationPortAddressingScheme8BitElement(-1, 3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testContructorTooBigDestinationPort()
	{
		new ApplicationPortAddressingScheme8BitElement(300, 3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testContructorNegativeOriginatorPort()
	{
		new ApplicationPortAddressingScheme8BitElement(2, -1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testContructorTooBigOriginatorPort()
	{
		new ApplicationPortAddressingScheme8BitElement(2, 300);
	}

	@Test
	public void testGetLength()
	{
		assertEquals((Integer) 2, (new ApplicationPortAddressingScheme8BitElement(1, 1)).getLength());
	}

	@Test
	public void testIsRepeatable()
	{
		assertFalse((new ApplicationPortAddressingScheme8BitElement(1, 1)).isRepeatable());
	}

	@Test
	public void testAsByteArray()
	{
		assertArrayEquals(new byte[] { 1, 2 }, (new ApplicationPortAddressingScheme8BitElement(1, 2)).asByteArray());
	}
	
	@Test
	public void testValueOfSuccess()
	{
		ApplicationPortAddressingScheme8BitElement result =
				ApplicationPortAddressingScheme8BitElement.valueOf(new byte[] { 4, 5 });
		
		assertEquals((Integer) 4, result.getDestinationPort());
		assertEquals((Integer) 5, result.getOriginatorPort());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValueOfNoInput()
	{
		ApplicationPortAddressingScheme8BitElement.valueOf(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValueOfEmptyInput()
	{
		ApplicationPortAddressingScheme8BitElement.valueOf(new byte[] {});
	}

}

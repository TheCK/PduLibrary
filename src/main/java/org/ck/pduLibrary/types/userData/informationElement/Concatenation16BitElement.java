package org.ck.pduLibrary.types.userData.informationElement;

import static org.ck.pduLibrary.util.Util.convertIntegerToUnsignedBytes;
import static org.ck.pduLibrary.util.Util.convertUnsignedByteToInteger;

import org.ck.pduLibrary.annotations.InfoElement;
import org.ck.pduLibrary.types.userData.InformationElement;

@InfoElement(indication = 0x08)
public class Concatenation16BitElement extends InformationElement
{

	private final static Integer ELEMENT_LENGTH = 4;
	private final static Boolean IS_REPEATABLE = false;

	private Integer referenceNumber;
	private Integer totalParts;
	private Integer currentPart;

	public Concatenation16BitElement(Integer referenceNumber, Integer totalParts, Integer currentPart)
	{
		checkReferenceNumber(referenceNumber);
		checkTotalParts(totalParts);
		checkCurrentPart(totalParts, currentPart);

		this.referenceNumber = referenceNumber;
		this.totalParts = totalParts;
		this.currentPart = currentPart;
	}

	private void checkReferenceNumber(Integer referenceNumber)
	{
		if (referenceNumber < 0 || referenceNumber > 65535)
		{
			throw new IllegalArgumentException("referneceNumber out of bounds");
		}
	}

	private void checkTotalParts(Integer totalParts)
	{
		if (totalParts < 0 || totalParts > 255)
		{
			throw new IllegalArgumentException("totalParts out of bounds");
		}
	}

	private void checkCurrentPart(Integer totalParts, Integer currentPart)
	{
		if (currentPart < 1 || currentPart > 255 || currentPart > totalParts)
		{
			throw new IllegalArgumentException("currentPart out of bounds");
		}
	}

	public Integer getReferenceNumber()
	{
		return referenceNumber;
	}

	public Integer getTotalParts()
	{
		return totalParts;
	}

	public Integer getCurrentPart()
	{
		return currentPart;
	}

	@Override
	public Integer getLength()
	{
		return ELEMENT_LENGTH;
	}

	@Override
	public Boolean isRepeatable()
	{
		return IS_REPEATABLE;
	}

	@Override
	public byte[] asByteArray()
	{
		byte[] bytes = new byte[ELEMENT_LENGTH];

		byte[] referenceBytes = convertIntegerToUnsignedBytes(referenceNumber);
		if (referenceBytes.length == 1)
		{
			System.arraycopy(referenceBytes, 0, bytes, 1, 1);
		}
		else
		{
			System.arraycopy(referenceBytes, 0, bytes, 0, 2);
		}

		bytes[2] = convertIntegerToUnsignedBytes(totalParts)[0];
		bytes[3] = convertIntegerToUnsignedBytes(currentPart)[0];

		return bytes;
	}

	public static Concatenation16BitElement valueOf(byte[] informationElement) throws IllegalArgumentException
	{
		if (informationElement != null && informationElement.length == ELEMENT_LENGTH)
		{
			Integer referenceNumber = (convertUnsignedByteToInteger(informationElement[0]) << 8)
					+ convertUnsignedByteToInteger(informationElement[1]);
			Integer totalParts = convertUnsignedByteToInteger(informationElement[2]);
			Integer currentPart = convertUnsignedByteToInteger(informationElement[3]);

			return new Concatenation16BitElement(referenceNumber, totalParts, currentPart);
		}

		throw new IllegalArgumentException();
	}

}

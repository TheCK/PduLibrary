package org.ck.pduLibrary.types.userData.informationElement;

import static org.ck.pduLibrary.util.ByteUtil.convertIntegerToUnsignedBytes;
import static org.ck.pduLibrary.util.ByteUtil.convertUnsignedByteToInteger;

import org.ck.pduLibrary.annotations.InfoElement;
import org.ck.pduLibrary.types.userData.InformationElement;

@InfoElement(indication = 0x20)
public class EMailHeaderElement extends InformationElement
{

	private final static Integer ELEMENT_LENGTH = 1;
	private final static Boolean IS_REPEATABLE = false;

	private Integer eMailHeaderLengthIndicator;

	public EMailHeaderElement(Integer eMailHeaderLengthIndicator)
	{
		checkEMailHeaderLengthIndicator(eMailHeaderLengthIndicator);

		this.eMailHeaderLengthIndicator = eMailHeaderLengthIndicator;
	}

	private static void checkEMailHeaderLengthIndicator(Integer eMailHeaderLengthIndicator)
	{
		if (eMailHeaderLengthIndicator < 0 || eMailHeaderLengthIndicator > 255)
		{
			throw new IllegalArgumentException("eMailHeaderLengthIndicator out of bounds");
		}
	}

	public Integer getEMailHeaderLengthIndicator()
	{
		return eMailHeaderLengthIndicator;
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
		bytes[0] = convertIntegerToUnsignedBytes(eMailHeaderLengthIndicator)[0];

		return bytes;
	}

	public static EMailHeaderElement valueOf(byte[] informationElement)
	{
		if (informationElement != null && informationElement.length == ELEMENT_LENGTH)
		{
			Integer eMailHeaderLengthIndicator = convertUnsignedByteToInteger(informationElement[0]);

			return new EMailHeaderElement(eMailHeaderLengthIndicator);
		}

		throw new IllegalArgumentException();
	}

}

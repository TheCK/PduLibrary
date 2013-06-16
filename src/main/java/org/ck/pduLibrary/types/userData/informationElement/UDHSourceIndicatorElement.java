package org.ck.pduLibrary.types.userData.informationElement;

import org.ck.pduLibrary.annotations.InfoElement;
import org.ck.pduLibrary.types.userData.InformationElement;

@InfoElement(indication = 0x07)
public class UDHSourceIndicatorElement extends InformationElement
{

	private final static Integer ELEMENT_LENGTH = 1;
	private final static Boolean IS_REPEATABLE = true;

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
		// TODO Auto-generated method stub
		return null;
	}

	public static UDHSourceIndicatorElement valueOf(byte[] informationElement)
	{
		// TODO parse bytes to fill values
		return new UDHSourceIndicatorElement();
	}

}

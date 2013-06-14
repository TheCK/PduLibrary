package org.ck.pduLibrary.types.userData.informationElement;

import org.ck.pduLibrary.annotations.InfoElement;
import org.ck.pduLibrary.types.userData.InformationElement;

@InfoElement(indication = 0x05)
public class ApplicationPortAddressingScheme16BitElement extends InformationElement
{

	private final static Integer ELEMENT_LENGTH = 4;
	private final static Boolean IS_REPEATABLE = false;

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

	public static ApplicationPortAddressingScheme16BitElement valueOf(byte[] informationElement)
	{
		// TODO parse bytes to fill values
		return new ApplicationPortAddressingScheme16BitElement();
	}

}

package org.ck.pduLibrary.types.userData.informationElement;

import org.ck.pduLibrary.annotations.InfoElement;
import org.ck.pduLibrary.types.userData.InformationElement;

@InfoElement(indication = 0x24)
public class NationalLanguageSingleShiftElement extends InformationElement
{

	private final static Integer ELEMENT_LENGTH = 1;
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

	public static NationalLanguageSingleShiftElement valueOf(byte[] informationElement)
	{
		// TODO parse bytes to fill values
		return new NationalLanguageSingleShiftElement();
	}

}

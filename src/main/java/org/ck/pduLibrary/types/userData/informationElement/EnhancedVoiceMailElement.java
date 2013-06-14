package org.ck.pduLibrary.types.userData.informationElement;

import org.ck.pduLibrary.annotations.InfoElement;
import org.ck.pduLibrary.types.userData.InformationElement;

@InfoElement(indication = 0x23)
public class EnhancedVoiceMailElement extends InformationElement
{

	private final static Boolean IS_REPEATABLE = false;

	private byte[] content;

	@Override
	public Integer getLength()
	{
		return content.length;
	}

	@Override
	public Boolean isRepeatable()
	{
		return IS_REPEATABLE;
	}

	public static EnhancedVoiceMailElement valueOf(byte[] informationElement)
	{
		// TODO parse bytes to fill values
		return new EnhancedVoiceMailElement();
	}

}

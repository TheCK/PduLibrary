package org.ck.pduLibrary.types.userData.informationElement;

import org.ck.pduLibrary.annotations.InfoElement;
import org.ck.pduLibrary.types.userData.InformationElement;

@InfoElement(indication = 0x20)
public class EMailHeaderElement extends InformationElement
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
	
	@Override
	public byte[] asByteArray()
	{
		// TODO Auto-generated method stub
		return null;
	}

	public static EMailHeaderElement valueOf(byte[] informationElement)
	{
		// TODO parse bytes to fill values
		return new EMailHeaderElement();
	}

}

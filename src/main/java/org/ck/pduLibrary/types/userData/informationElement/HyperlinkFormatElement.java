package org.ck.pduLibrary.types.userData.informationElement;

import org.ck.pduLibrary.types.userData.InformationElement;

public class HyperlinkFormatElement extends InformationElement
{
	
	private final static Boolean IS_REPEATABLE = true;
	
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
	
	public static HyperlinkFormatElement valueOf(byte[] informationElement)
	{
		//TODO parse bytes to fill values
		return new HyperlinkFormatElement();
	}

}

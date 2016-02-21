package org.ck.pduLibrary.types;

import java.util.ArrayList;
import java.util.List;

import org.ck.pduLibrary.types.userData.InformationElement;

public class UserData
{

	private List<InformationElement> userDataHeader = new ArrayList<InformationElement>();
	private String stringContent;
	private byte[] binaryContent;
	
	public List<InformationElement> getUserDataHeader()
	{
		return userDataHeader;
	}
	
	public String getStringContent()
	{
		return stringContent;
	}
	
	public byte[] getBinaryContent()
	{
		return binaryContent;
	}
	
	public byte[] getContent()
	{
		if (stringContent != null)
		{
			//TODO ensure 7-bit encoding of String content
			return stringContent.getBytes();
		}
		
		return binaryContent;
	}
	
}

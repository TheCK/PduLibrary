package org.ck.pduLibrary;

import org.ck.pduLibrary.types.Address;
import org.ck.pduLibrary.types.UserData;

public abstract class Pdu
{
	
	private Address serviceCentreAddress;
	private UserData userData;
	
	public Address getServiceCentreAddress()
	{
		return serviceCentreAddress;
	}
	
	public String getServiceCentreAddressString()
	{
		if (serviceCentreAddress != null)
		{
			return serviceCentreAddress.getContent();
		}
		
		return null;
	}
	
	public UserData getUserData()
	{
		return userData;
	}
	
}

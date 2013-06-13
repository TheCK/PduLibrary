package org.ck.pduLibrary;

import org.ck.pduLibrary.types.Address;

public class Pdu
{
	
	private Address serviceCentreAddress;
	
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
	
}

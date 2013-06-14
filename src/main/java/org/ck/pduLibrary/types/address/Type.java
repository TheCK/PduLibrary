package org.ck.pduLibrary.types.address;

public enum Type
{
	
	UNKOWN(0x0),
	INTERNATIONAL(0x1),
	NATIONAL(0x2),
	NETWORK_SPECIFIC(0x3),
	SUBSCRIBER(0x4),
	ALPHANUMERIC(0x5),
	ABBREVIATED(0x6),
	RESERVED(0x7);
	
	private Integer value;
	
	Type(Integer value)
	{
		this.value = value;
	}
	
	public Integer getValue()
	{
		return value;
	}
	
}

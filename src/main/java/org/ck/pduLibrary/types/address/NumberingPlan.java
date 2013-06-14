package org.ck.pduLibrary.types.address;

public enum NumberingPlan
{
	
	UNKNOWN(0x0),
	ISDN(0x1),
	DATA(0x3),
	TELEX(0x4),
	NATIONAL(0x8),
	PRIVATE(0x9),
	ERMES(0xA),
	RESERVED(0xF);
	
	private Integer value;
	
	NumberingPlan(Integer value)
	{
		this.value = value;
	}
	
	public Integer getValue()
	{
		return value;
	}
	
}

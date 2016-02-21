package org.ck.pduLibrary.types;

import org.ck.pduLibrary.types.address.NumberingPlan;
import org.ck.pduLibrary.types.address.Type;

public class Address implements PduType
{

	private Type type;
	private NumberingPlan numberingPlan;
	private String content;
	
	public Type getType()
	{
		return type;
	}

	public void setType(Type type)
	{
		this.type = type;
	}

	public NumberingPlan getNumberingPlan()
	{
		return numberingPlan;
	}

	public void setNumberingPlan(NumberingPlan numberingPlan)
	{
		this.numberingPlan = numberingPlan;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public Integer getLength()
	{
		// TODO Auto-generated method stub
		return null;
	}

	public byte[] asByteArray()
	{
		// TODO Auto-generated method stub
		return null;
	}

}

package org.ck.pduLibrary.types;

public interface PduType
{
	
	public abstract Integer getLength();
	
	public abstract byte[] asByteArray();

}

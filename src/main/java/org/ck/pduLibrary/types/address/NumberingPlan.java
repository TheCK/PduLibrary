package org.ck.pduLibrary.types.address;

/*
 * 0 0 0 0 Unknown
 * 0 0 0 1 ISDN/telephone numbering plan
 * 0 0 1 1 Data numbering plan (X.121)
 * 0 1 0 0 Telex numbering plan
 * 1 0 0 0 National numbering plan 
 * 1 0 0 1 Private numbering plan
 * 1 0 1 0 ERMES numbering plan
 * 1 1 1 1 Reserved for extension 
 */
public enum NumberingPlan
{
	UNKNOWN, ISDN, DATA, TELEX, NATIONAL, PRIVATE, ERMES, RESERVED;
}

package org.ck.pduLibrary.types.address;

/*
 * 0 0 0 Unknown
 * 0 0 1 International number
 * 0 1 0 National number
 * 0 1 1 Network specific number
 * 1 0 0 Subscriber number
 * 1 0 1 Alphanumeric
 * 1 1 0 Abbreviated number
 * 1 1 1 Reserved for extension 
 */
public enum Type
{
	UNKOWN, INTERNATIONAL, NATIONAL, NETWORK_SPECIFIC, SUBSCRIBER, ALPHANUMERIC, ABBREVIATED, RESERVED;
}

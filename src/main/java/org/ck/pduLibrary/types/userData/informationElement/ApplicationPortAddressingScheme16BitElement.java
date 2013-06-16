package org.ck.pduLibrary.types.userData.informationElement;

import static org.ck.pduLibrary.util.Util.convertIntegerToUnsignedBytes;
import static org.ck.pduLibrary.util.Util.convertUnsignedByteToInteger;

import org.ck.pduLibrary.annotations.InfoElement;
import org.ck.pduLibrary.types.userData.InformationElement;

@InfoElement(indication = 0x05)
public class ApplicationPortAddressingScheme16BitElement extends InformationElement
{

	private final static Integer ELEMENT_LENGTH = 4;
	private final static Boolean IS_REPEATABLE = false;
	
	private Integer destinationPort;
	private Integer originatorPort;

	public ApplicationPortAddressingScheme16BitElement(Integer destinationPort, Integer originatorPort)
	{
		checkDestinationPort(destinationPort);
		checkOriginatorPort(originatorPort);
		
		this.destinationPort = destinationPort;
		this.originatorPort = originatorPort;
	}
	
	private void checkDestinationPort(Integer destinationPort)
	{
		if (destinationPort < 0 || destinationPort > 65535)
		{
			throw new IllegalArgumentException("destinationPort out of bounds");
		}
	}
	
	private void checkOriginatorPort(Integer originatorPort)
	{
		if (originatorPort < 0 || originatorPort > 65535)
		{
			throw new IllegalArgumentException("originatorPort out of bounds");
		}
	}
	
	public Integer getDestinationPort()
	{
		return destinationPort;
	}
	
	public Integer getOriginatorPort()
	{
		return originatorPort;
	}
	
	@Override
	public Integer getLength()
	{
		return ELEMENT_LENGTH;
	}

	@Override
	public Boolean isRepeatable()
	{
		return IS_REPEATABLE;
	}
	
	@Override
	public byte[] asByteArray()
	{
		byte[] bytes = new byte[ELEMENT_LENGTH];

		byte[] destinationPortBytes = convertIntegerToUnsignedBytes(destinationPort);
		if (destinationPortBytes.length == 1)
		{
			System.arraycopy(destinationPortBytes, 0, bytes, 1, 1);
		}
		else
		{
			System.arraycopy(destinationPortBytes, 0, bytes, 0, 2);
		}
		
		byte[] originatorPortBytes = convertIntegerToUnsignedBytes(originatorPort);
		if (originatorPortBytes.length == 1)
		{
			System.arraycopy(originatorPortBytes, 0, bytes, 3, 1);
		}
		else
		{
			System.arraycopy(originatorPortBytes, 0, bytes, 2, 2);
		}

		return bytes;
	}

	public static ApplicationPortAddressingScheme16BitElement valueOf(byte[] informationElement)
	{
		if (informationElement != null && informationElement.length == ELEMENT_LENGTH)
		{
			Integer destinationPort = (convertUnsignedByteToInteger(informationElement[0]) << 8)
					+ convertUnsignedByteToInteger(informationElement[1]);
			Integer originatorPort = (convertUnsignedByteToInteger(informationElement[2]) << 8)
					+ convertUnsignedByteToInteger(informationElement[3]);

			return new ApplicationPortAddressingScheme16BitElement(destinationPort, originatorPort);
		}

		throw new IllegalArgumentException();
	}

}

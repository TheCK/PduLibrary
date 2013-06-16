package org.ck.pduLibrary.types.userData.informationElement;

import static org.ck.pduLibrary.util.Util.convertIntegerToUnsignedBytes;
import static org.ck.pduLibrary.util.Util.convertUnsignedByteToInteger;

import org.ck.pduLibrary.annotations.InfoElement;
import org.ck.pduLibrary.types.userData.InformationElement;

@InfoElement(indication = 0x04)
public class ApplicationPortAddressingScheme8BitElement extends InformationElement
{

	private final static Integer ELEMENT_LENGTH = 2;
	private final static Boolean IS_REPEATABLE = false;
	
	private Integer destinationPort;
	private Integer originatorPort;

	public ApplicationPortAddressingScheme8BitElement(Integer destinationPort, Integer originatorPort)
	{
		checkDestinationPort(destinationPort);
		checkOriginatorPort(originatorPort);
		
		this.destinationPort = destinationPort;
		this.originatorPort = originatorPort;
	}
	
	private void checkDestinationPort(Integer destinationPort)
	{
		if (destinationPort < 0 || destinationPort > 255)
		{
			throw new IllegalArgumentException("destinationPort out of bounds");
		}
	}
	
	private void checkOriginatorPort(Integer originatorPort)
	{
		if (originatorPort < 0 || originatorPort > 255)
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
		bytes[0] = convertIntegerToUnsignedBytes(destinationPort)[0];
		bytes[1] = convertIntegerToUnsignedBytes(originatorPort)[0];

		return bytes;
	}

	public static ApplicationPortAddressingScheme8BitElement valueOf(byte[] informationElement)
	{
		if (informationElement != null && informationElement.length == ELEMENT_LENGTH)
		{
			Integer destinationPort = convertUnsignedByteToInteger(informationElement[0]);
			Integer originatorPort = convertUnsignedByteToInteger(informationElement[1]);

			return new ApplicationPortAddressingScheme8BitElement(destinationPort, originatorPort);

		}

		throw new IllegalArgumentException();
	}

}

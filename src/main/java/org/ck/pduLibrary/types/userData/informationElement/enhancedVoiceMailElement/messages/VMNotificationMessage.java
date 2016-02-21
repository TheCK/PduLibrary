package org.ck.pduLibrary.types.userData.informationElement.enhancedVoiceMailElement.messages;

import org.ck.pduLibrary.types.Address;

public class VMNotificationMessage
{
	private Integer vmMessageId; /* 2 byte */
	private Integer vmMessageLength; /* 1 byte */
	// byte boundary
	private Integer vmMessageRetentionDays; /* 5 bit */
	private Boolean vmMessagePriotityIndication;
	private Address vmMessageCallingLineIdentity;
	// byte boundary
	// private Integer vmMessageExtensionLength; /* 1 byte; not used */
	// private VmMessageExtensionData vmMessageExtensionData; /* 1+ byte; not used */

	public VMNotificationMessage(Integer vmMessageId, Integer vmMessageLength, Integer vmMessageRetentionDays,
									Boolean vmMessagePriotityIndication, Address vmMessageCallingLineIdentity)
	{
		checkVmMessageId(vmMessageId);
		checkVmMessageLength(vmMessageLength);
		checkVmMessageRetentionDays(vmMessageRetentionDays);
		
		this.vmMessageId = vmMessageId;
		this.vmMessageLength = vmMessageLength;
		this.vmMessageRetentionDays = vmMessageRetentionDays;
		this.vmMessagePriotityIndication = vmMessagePriotityIndication;
		this.vmMessageCallingLineIdentity = vmMessageCallingLineIdentity;
	}

	private static void checkVmMessageId(Integer vmMessageId)
	{
		if (vmMessageId < 0 || vmMessageId > 65535)
		{
			throw new IllegalArgumentException("vmMessageId out of bounds");
		}
	}

	private static void checkVmMessageLength(Integer vmMessageLength)
	{
		if (vmMessageLength < 0 || vmMessageLength > 255)
		{
			throw new IllegalArgumentException("vmMessageLength out of bounds");
		}
	}

	private static void checkVmMessageRetentionDays(Integer vmMessageRetentionDays)
	{
		if (vmMessageRetentionDays < 0 || vmMessageRetentionDays > 255)
		{
			throw new IllegalArgumentException("vmMessageRetentionDays out of bounds");
		}
	}

	public Integer getVmMessageId()
	{
		return vmMessageId;
	}

	public Integer getVmMessageLength()
	{
		return vmMessageLength;
	}

	public Integer getVmMessageRetentionDays()
	{
		return vmMessageRetentionDays;
	}

	public Boolean getVmMessagePriotityIndication()
	{
		return vmMessagePriotityIndication;
	}

	public static Boolean getVmMessageExtensionIndicator()
	{
		// no extensions are defined at this point
		return false;
	}

	public Address getVmMessageCallingLineIdentity()
	{
		return vmMessageCallingLineIdentity;
	}
}

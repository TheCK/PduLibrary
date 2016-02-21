package org.ck.pduLibrary.types.userData.informationElement.enhancedVoiceMailElement;

import java.util.ArrayList;
import java.util.List;

import org.ck.pduLibrary.types.Address;
import org.ck.pduLibrary.types.userData.informationElement.EnhancedVoiceMailElement;
import org.ck.pduLibrary.types.userData.informationElement.enhancedVoiceMailElement.messages.VMNotificationMessage;

public class EnhancedVoiceMailNotificationElement extends EnhancedVoiceMailElement
{

	private Integer multipleSubscriberProfile; /* 2 bit; 1-4 */
	private Boolean smStorage; /* 1 bit */
	private Boolean vmMailboxAlmostFull; /* 1 bit */
	private Boolean vmMailboxFull; /* 1 bit */
	// byte boundary
	private Address vmMailboxAccessAddress; /* (n + 2) byte */
	// byte boundary
	private Integer numberOfVoiceMessages; /* 1 byte */
	// byte boundary
	// private Integer vmMailboxStatusExtensionLength; /* 1 byte; not used */
	// private VmMailboxStatusExtensionData vmMailboxStatusExtensionData; /* 1+ byte; not used */
	private List<VMNotificationMessage> vmNotificationMessages = new ArrayList<VMNotificationMessage>();

	public EnhancedVoiceMailNotificationElement(Integer multipleSubscriberProfile, Boolean smStorage,
												Boolean vmMailboxAlmostFull, Boolean vmMailboxFull,
												Address vmMailboxAccessAddress, Integer numberOfVoiceMessages,
												List<VMNotificationMessage> vmNotificationMessages)
	{
		checkMultipleSubscriberProfile(multipleSubscriberProfile);
		checkNumberOfVoiceMessages(numberOfVoiceMessages);
		checkVmNotificationMessages(vmNotificationMessages);
		
		this.multipleSubscriberProfile = multipleSubscriberProfile;
		this.smStorage = smStorage;
		this.vmMailboxAlmostFull = vmMailboxAlmostFull;
		this.vmMailboxFull = vmMailboxFull;
		this.vmMailboxAccessAddress = vmMailboxAccessAddress;
		this.numberOfVoiceMessages = numberOfVoiceMessages;
		this.vmNotificationMessages = vmNotificationMessages;
	}

	private static void checkMultipleSubscriberProfile(Integer multipleSubscriberProfile)
	{
		if (multipleSubscriberProfile < 1 || multipleSubscriberProfile > 4)
		{
			throw new IllegalArgumentException("multipleSubscriberProfile out of bounds");
		}
	}
	
	private static void checkNumberOfVoiceMessages(Integer numberOfVoiceMessages)
	{
		if (numberOfVoiceMessages < 0 || numberOfVoiceMessages > 255)
		{
			throw new IllegalArgumentException("numberOfVoiceMessages out of bounds");
		}
	}
	
	private static void checkVmNotificationMessages(List<VMNotificationMessage> vmNotificationMessages)
	{
		if (vmNotificationMessages.size() > 15)
		{
			throw new IllegalArgumentException("vmNotificationMessages is too large");
		}
	}

	public Integer getMultipleSubscriberProfile()
	{
		return multipleSubscriberProfile;
	}

	public Boolean getSmStorage()
	{
		return smStorage;
	}

	public Boolean getVmMailboxAlmostFull()
	{
		return vmMailboxAlmostFull;
	}

	public Boolean getVmMailboxFull()
	{
		return vmMailboxFull;
	}
	
	public static Boolean getVmMailboxStatusExtensionIndicatior()
	{
		// no extensions are defined at this point
		return false;
	}

	public Address getVmMailboxAccessAddress()
	{
		return vmMailboxAccessAddress;
	}

	public Integer getNumberOfVoiceMessages()
	{
		return numberOfVoiceMessages;
	}

	public Integer getNumberOfVmNotifications()
	{
		return vmNotificationMessages.size();
	}
	
	public List<VMNotificationMessage> getVmNotificationMessages()
	{
		return vmNotificationMessages;
	}
	
	
}

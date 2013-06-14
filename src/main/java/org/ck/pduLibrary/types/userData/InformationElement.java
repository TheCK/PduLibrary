package org.ck.pduLibrary.types.userData;

import org.ck.pduLibrary.types.userData.informationElement.ApplicationPortAddressingScheme16BitElement;
import org.ck.pduLibrary.types.userData.informationElement.ApplicationPortAddressingScheme8BitElement;
import org.ck.pduLibrary.types.userData.informationElement.Concatenation16BitElement;
import org.ck.pduLibrary.types.userData.informationElement.Concatenation8BitElement;
import org.ck.pduLibrary.types.userData.informationElement.EMailHeaderElement;
import org.ck.pduLibrary.types.userData.informationElement.EnhancedVoiceMailElement;
import org.ck.pduLibrary.types.userData.informationElement.HyperlinkFormatElement;
import org.ck.pduLibrary.types.userData.informationElement.NationalLanguageLockingShiftElement;
import org.ck.pduLibrary.types.userData.informationElement.NationalLanguageSingleShiftElement;
import org.ck.pduLibrary.types.userData.informationElement.ReplyAddressElement;
import org.ck.pduLibrary.types.userData.informationElement.SMSCControlParametersElement;
import org.ck.pduLibrary.types.userData.informationElement.SpecialSMSMessageIndicationElement;
import org.ck.pduLibrary.types.userData.informationElement.UDHSourceIndicatorElement;
import org.ck.pduLibrary.types.userData.informationElement.WirelessControlMessageProtocolElement;

/*
 * 2 4			National Language Single Shift									SMS Control		No
 * 2 5			National Language Locking Shift									SMS Control		No
 */
public abstract class InformationElement
{

	public abstract Integer getLength();
	
	public abstract Boolean isRepeatable(); 
	
	public static InformationElement valueOf(byte[] informationElement)
	{
		//TODO acertain type of the information element and return the according type
		Integer identifier = 0;
		
		//TODO use annotation in subclasses to find the implemented elements and check with defined identifier
		switch (identifier){
			case 0x00:
				return Concatenation8BitElement.valueOf(informationElement);
			case 0x01:
				return SpecialSMSMessageIndicationElement.valueOf(informationElement);
			case 0x04:
				return ApplicationPortAddressingScheme8BitElement.valueOf(informationElement);
			case 0x05:
				return ApplicationPortAddressingScheme16BitElement.valueOf(informationElement);
			case 0x06:
				return SMSCControlParametersElement.valueOf(informationElement);
			case 0x07:
				return UDHSourceIndicatorElement.valueOf(informationElement);
			case 0x08:
				return Concatenation16BitElement.valueOf(informationElement);
			case 0x09:
				return WirelessControlMessageProtocolElement.valueOf(informationElement);
			case 0x20:
				return EMailHeaderElement.valueOf(informationElement);
			case 0x21:
				return HyperlinkFormatElement.valueOf(informationElement);
			case 0x22:
				return ReplyAddressElement.valueOf(informationElement);
			case 0x23:
				return EnhancedVoiceMailElement.valueOf(informationElement);
			case 0x24:
				return NationalLanguageSingleShiftElement.valueOf(informationElement);
			case 0x25:
				return NationalLanguageLockingShiftElement.valueOf(informationElement);
			default:
				return null;
		}
		
	}
	
}

package org.ck.pduLibrary.types.userData.informationElement.enhancedVoiceMailElement;

import org.ck.pduLibrary.types.userData.informationElement.EnhancedVoiceMailElement;

/*
 * ENHANCED_VOICE_MAIL_PDU_TYPE Bit 0 Octet 1 M
RESERVED_FOR_FUTURE_USE Bit 1 Octet 1 M
MULTIPLE_SUBSCRIBER_PROFILE Bits 3..2 Octet 1 M
SM_STORAGE Bit 4 Octet 1 M
VM_MAILBOX_ALMOST_FULL Bit 5 Octet 1 M
VM_MAILBOX_FULL Bit 6 Octet 1 M
VM_MAILBOX_STATUS_EXTENSION_INDICATOR Bit 7 Octet 1 M
VM_MAILBOX_ACCESS_ADDRESS Octets 2..n+2 (NOTE 2) M
NUMBER_OF_VOICE_MESSAGES Bits 0..7 Octet n+3 M
NUMBER_OF_VM_DELETES Bits 0..4 Octet n+4 M
RESERVED_FOR_FUTURE_USE Bits 5..7 Octet n+4 M
VM_MAILBOX_STATUS_EXTENSION_LENGTH 1 Octet (NOTE 3) C
VM_MAILBOX_STATUS_EXTENSION_DATA 1 or more Octets (NOTE 3) C
VM_MESSAGE_ID (NOTE 1) Octets n+5..n+6 M
RESERVED_FOR_FUTURE_USE (NOTE 1) Bits 0..6 Octet n+7 M
VM_MESSAGE_EXTENSION_INDICATOR (NOTE 1) Bit 7 Octet n+7 M
VM_MESSAGE_EXTENSION_LENGTH (NOTE 1) 1 Octet (NOTE 3) C
VM_MESSAGE_EXTENSION_DATA (NOTE 1) 1 or more Octets (NOTE 3) C
NOTE 1: This sequence of parameters are repeated a number of times according to the number of Voice Mail
Delete Confirmations conveyed in this IE.
NOTE 2: ‘n’ denotes the number of octets required for the VM_MAILBOX_ACCESS_ADDRESS including the
Address-Length, Type-of-address and Address-value (see 9.1.2.5).
NOTE 3: The Conditional Octets are excluded from the
 */
public class EnhancedVoiceMailDeleteConfirmationElement extends EnhancedVoiceMailElement
{
	// TODO
}

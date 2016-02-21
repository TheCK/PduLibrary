package org.ck.pduLibrary.mo;

import org.ck.pduLibrary.Pdu;
import org.ck.pduLibrary.types.Address;
import org.ck.pduLibrary.types.ProtocolIdentifier;

public class SubmitPdu extends Pdu
{
	Boolean rejectDuplicates;
	
	Boolean statusReportRequest;
	
	Boolean replyPath;
	
	Integer messageReferenceField;
	
	Address destinationAddress;
		
	ProtocolIdentifier protocalIdentifier;
	
	// TODO
}

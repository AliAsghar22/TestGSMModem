
package org.smslib.message;

import org.ajwcc.pduUtils.gsm3040.SmsDeliveryPdu;
import org.smslib.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class InboundEncryptedMessage extends InboundBinaryMessage
{
	private static final long serialVersionUID = 1L;

	public InboundEncryptedMessage(SmsDeliveryPdu pdu, String memLocation, int memIndex)
	{
		super(pdu, memLocation, memIndex);
	}

	public byte[] getDecryptedData() throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, NoSuchAlgorithmException
	{
		if (Service.getInstance().getKeyManager().getKey(getOriginatorAddress()) != null) return (Service.getInstance().getKeyManager().decrypt(getOriginatorAddress(), getPayload().getBytes()));
		return new byte[0];
	}
}

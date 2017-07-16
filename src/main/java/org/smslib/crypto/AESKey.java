
package org.smslib.crypto;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class AESKey extends AbstractSymmetricKey
{
	public AESKey() throws NoSuchAlgorithmException
	{
		setKey(generateKey());
	}

	public AESKey(SecretKeySpec key)
	{
		setKey(key);
	}

	@Override
	public SecretKeySpec generateKey() throws NoSuchAlgorithmException
	{
		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		keyGen.init(128);
		SecretKey secretKey = keyGen.generateKey();
		byte[] raw = secretKey.getEncoded();
		return new SecretKeySpec(raw, "AES");
	}

	@Override
	public byte[] encrypt(byte[] message) throws NoSuchAlgorithmException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException
	{
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, getKey());
		return cipher.doFinal(message);
	}

	@Override
	public byte[] decrypt(byte[] message) throws NoSuchAlgorithmException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException
	{
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, getKey());
		return cipher.doFinal(message);
	}
}

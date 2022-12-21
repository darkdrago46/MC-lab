

import java.io.*;
import java.security.*;
import java.util.*;

import javax.crypto.*;
import javax.crypto.spec.*;

public class AES {
	
	private SecretKey secretKey;
	private SecureRandom secureRandom;
	private Cipher encryptCipher;
	private Cipher decryptCipher;
	private IvParameterSpec params;

	public AES() {
		try {
			secretKey = KeyGenerator.getInstance("AES").generateKey();
			secureRandom = new SecureRandom();
			encryptCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			decryptCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			byte[] initializationVector = new byte[encryptCipher.getBlockSize()];
			secureRandom.nextBytes(initializationVector);
			params = new IvParameterSpec(initializationVector);
			encryptCipher.init(Cipher.ENCRYPT_MODE, secretKey, params);
			decryptCipher.init(Cipher.DECRYPT_MODE, secretKey, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String encryptText(String plainText) {
		byte[] bytePlainText = plainText.getBytes();
		try {
			byte[] byteEncryptText = encryptCipher.doFinal(bytePlainText);
			return Base64.getEncoder().encodeToString(byteEncryptText);
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String decryptText(String encryptText) {
		byte[] byteEncryptText = encryptText.getBytes();
		byte[] byteDecryptText;
		try {
			byteDecryptText = decryptCipher.doFinal(Base64.getDecoder().decode(byteEncryptText));
			return new String(byteDecryptText, "UTF8");
		} catch (IllegalBlockSizeException | BadPaddingException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

}

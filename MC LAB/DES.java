

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class DES {
	private SecretKey secretKey;
	private SecureRandom secureRandom;
	private Cipher encryptCipher;
	private Cipher decryptCipher;
	private IvParameterSpec params;

	public DES() {
		try {
			secretKey = KeyGenerator.getInstance("DES").generateKey();
			System.out.println(secretKey.getEncoded());
			secureRandom = new SecureRandom();
			encryptCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
			decryptCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
			byte[] intializationVector = new byte[encryptCipher.getBlockSize()];
			secureRandom.nextBytes(intializationVector);
			params = new IvParameterSpec(intializationVector);
			encryptCipher.init(Cipher.ENCRYPT_MODE, secretKey, params);
			decryptCipher.init(Cipher.DECRYPT_MODE, secretKey, params);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException
				| InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		}
	}

	public String encryptText(String plainText) {
		byte[] bytePlainText = plainText.getBytes();
		try {
			byte[] encryptText = encryptCipher.doFinal(bytePlainText);
			return Base64.getEncoder().encodeToString(encryptText);
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String decryptText(String encryptText) {
		byte[] byteEncryptText = encryptText.getBytes();
		try {
			byte[] decryptText = decryptCipher.doFinal(Base64.getDecoder().decode(byteEncryptText));
			return new String(decryptText, "UTF8");
		} catch (IllegalBlockSizeException | BadPaddingException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
	

	


import java.math.BigInteger;
import java.security.SecureRandom;

public class RSA {
	private BigInteger publicKey;
	private BigInteger privateKey;
	private BigInteger p;
	private BigInteger q;
	private BigInteger n;
	private BigInteger phi;
	private SecureRandom random;

	public RSA() {
		random = new SecureRandom();
	}

	public void generateKeys(int bitLength) {
		p = BigInteger.probablePrime(bitLength, random);
		q = BigInteger.probablePrime(bitLength, random);
		n = p.multiply(q);
		phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
		publicKey = generatePublicKeyFactor(phi);
		privateKey = publicKey.modInverse(phi);
	}

	public BigInteger generatePublicKeyFactor(BigInteger phi) {
		BigInteger e = new BigInteger(phi.bitLength(), random);
		while (!e.gcd(phi).equals(BigInteger.ONE))
			e = new BigInteger(phi.bitLength(), random);
		return e;
	}

	public BigInteger encryptText(String plainText) {
		byte[] bytePlainText = plainText.getBytes();
		BigInteger bytePlainMessage = new BigInteger(bytePlainText);
		return bytePlainMessage.modPow(publicKey, n);
	}

	public String decrypText(BigInteger cipherText) {
		return new String(cipherText.modPow(privateKey, n).toByteArray());
	}
	
}

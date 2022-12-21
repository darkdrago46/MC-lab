import java.math.BigInteger;
import java.util.Scanner;

public class Main3{
	private static final Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		RSA rsa = new RSA();
		rsa.generateKeys(1024);
		System.out.print("Enter the message :");
		String plainText = input.nextLine();
		BigInteger encryptText = rsa.encryptText(plainText);
		String decryptMessage = rsa.decrypText(encryptText);
		System.out.println("The Plain Text is " + plainText + "\nThe encrypted text is " + encryptText
				+ "\nThe decrypted text is " + decryptMessage);
	}
}
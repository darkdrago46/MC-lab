import java.util.Scanner;

public class Main2{
	private static final Scanner input = new Scanner(System.in);

	public static void main(String[] args) { 
		AES aes = new AES();
		System.out.print("Enter a message :");
		String plainText = input.nextLine();
		String encryptText = aes.encryptText(plainText);
		String decryptText = aes.decryptText(encryptText);
		System.out.println("The plain text is " + plainText + "\nThe encrypted text is " + encryptText
				+ "\nThe decrypted text is " + decryptText);
	}
}

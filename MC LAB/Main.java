import java.util.Scanner;

public class Main{
	private static final Scanner input = new Scanner(System.in);

	public static void main(String args[]) { 
		DES des = new DES();
		System.out.print("Enter a message :");
		String plainText = input.nextLine();
		String encryptText = des.encryptText(plainText);
		String decryptText = des.decryptText(encryptText);
		System.out.println("The plain text is " + plainText + "\nThe encrypted text is " + encryptText
				+ "\nThe decrypted text is " + decryptText);
	}
}
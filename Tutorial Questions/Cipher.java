import java.util.Random;
import java.util.Scanner;

public class Cipher {

	public static final char[] CHARACTERS = " abcdefghijklmnopqrstuvwxyz".toCharArray();
	public static final char[] CIPHER = " abcdefghijklmnopqrstuvwxyz".toCharArray();

	public static int findIndex(char[] arr, int t)
	{
		if (arr == null)
			return -1;
		int i = 0;
		while (i < arr.length) 
		{
			if (arr[i] == t)
				return i;
			else
				i++;
		}
		return -1;
	}

	public static void createCipher(char[] array) {
		if (array!= null)
		{
			Random generator = new Random();
			for (int index=0; index<array.length; index++ )
			{
				int otherIndex = generator.nextInt(array.length);
				char temp = array[index];
				array[index] = array[otherIndex];
				array[otherIndex] = temp;
			}
		}
	}

	public static String encrypt(String text, char[] cipher) {
		char[] textArray =  text.toLowerCase().toCharArray();
		for (int index = 0; index < textArray.length; index++)
			textArray[index] = cipher[findIndex(CHARACTERS, textArray[index])];
		text = new String(textArray);
		return text;
	}

	public static String decrypt(String text, char[] cipher) {
		char[] textArray =  text.toLowerCase().toCharArray();
		for (int index = 0; index < textArray.length; index++)
			textArray[index] = CHARACTERS[findIndex(cipher, textArray[index])];
		text = new String(textArray);
		return text;
	}

	public static boolean validCharacters(String text, char[] characters) {
		char[] textArray =  text.toLowerCase().toCharArray();
		for (int index = 0; index < textArray.length; index++)
		{
			if (findIndex(characters, textArray[index]) == -1)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.print("Enter the sentence to be encrypted: ");
		Scanner input = new Scanner(System.in);
		String text = input.nextLine();
		input.close();

		if (validCharacters(text, CHARACTERS)) 
		{
			createCipher(CIPHER);

			System.out.println("Encrypted version: " + encrypt(text, CIPHER));
			System.out.println("Decrypted version: " + decrypt(encrypt(text, CIPHER), CIPHER));
		}
		else
			System.out.println("invalid input");
	}
}
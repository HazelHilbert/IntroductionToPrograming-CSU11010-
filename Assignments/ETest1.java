import java.util.Scanner;

public class ETest1 {
	public static final double MINIMUM_NUDE_AND_ZYGODROME = 11;

	public static int getNumberOfDigits(int number) {
		number = (number < 0) ? Math.abs(number) : number;
		int digits = 1;
		while (number / 10 >= 1) 
		{
			number /= 10;
			digits++;
		}
		return digits;
	}

	public static int getDigit(int number, int digitNumber) {
		if (digitNumber > getNumberOfDigits(number) || digitNumber < 1)
			return -1;
		else
		{
			int digit = number;
			for (int index = 0; index < (getNumberOfDigits(number)-digitNumber); index++)
				digit /= 10;
			return (digit % 10);
		}
	}

	public static boolean isNude(int number) {
		for (int index = 1; index <= getNumberOfDigits(number); index++) 
		{
			if (getDigit(number, index) == 0)
				return false;
			if (number % getDigit(number, index) != 0)
				return false;
		}
		return true;
	}

	public static boolean isZygodrome(int number) {
		int previousDigit = getDigit(number, 1);
		int currentDigit = getDigit(number, 2);
		if (previousDigit != currentDigit || 
				getDigit(number, getNumberOfDigits(number)) !=
				getDigit(number, getNumberOfDigits(number) - 1))
			return false;
		for (int index = 2; index < getNumberOfDigits(number); index++) 
		{
			currentDigit = getDigit(number, index);
			if (previousDigit != currentDigit && 
					currentDigit != getDigit(number, ++index))
				return false;
			previousDigit = currentDigit;
		}
		return true;
	}

	public static int biggestNudeZygodrome(int number) {
		int count = number;
		while (!(isNude(count) && isZygodrome(count)))
			count--;
		return count;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean quit = false;
		while(!quit) 
		{
			System.out.print("Enter the maximum positive whole number to be considered (or -1 to quit)> ");
			if (input.hasNextInt()) {
				int number = input.nextInt();
				if (number == -1)
					quit = true;
				else if (number < 0)
					System.out.printf("Error: %d is not a positive number.%n", number);
				else
				{
					if (number < MINIMUM_NUDE_AND_ZYGODROME)
						System.out.printf("There are no numbers which are both zygodromes and nude up to %d", number);
					else {
						System.out.printf("The numbers which are both zygodromes and nude up to %d are ", number);
						for(int count = 0; count <= number; count++) 
						{
							if (isNude(count) && isZygodrome(count))
								System.out.print(count + 
										((count == biggestNudeZygodrome(number)) ? "" : ", "));
						}
					}
					System.out.println();
				}
			}
			else
			{
				System.out.printf("Error: %s is not a positive whole number.%n", input.next());
				input.nextLine();
			}
		}
		input.close();
	}
}
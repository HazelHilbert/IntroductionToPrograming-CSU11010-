import java.util.Scanner;

public class factorian {

	public static int computeFactorialItirative(int integer){
		int result = 1;
		for (int count = 2; count <= integer; count++) {
			result *= count;
		}
		return result;
	}
	
	public static int computeFactorial(int integer){
		return (integer <= 1) ? 1 : (integer * computeFactorial(integer - 1));
	}

	public static boolean isFactorian(int factorian){
		if (factorian == 0)
			return false;
		int result = 0;
		int count = factorian;
		while (count > 0) {
			result += computeFactorial(count % 10);
			count /= 10;
		}
		return (result == factorian);
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean quit = false;
		while (!quit) 
		{
			System.out.print("Enter an integer (or 'quit' to finish)> ");
			int number = 0;
			if (input.hasNextDouble()) 
			{
				number = input.nextInt();
				if (isFactorian(number))
					System.out.println(number + " is a factorian number");
				else
					System.out.println(number + " is not a factorian number");
			}
			else if (input.next().equalsIgnoreCase("quit"))
				quit = true;
			else
				System.out.println("Error: Enter a positive integer");
			input.nextLine();
		} 
		input.close();
	}
}

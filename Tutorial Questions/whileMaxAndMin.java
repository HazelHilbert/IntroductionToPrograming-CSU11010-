import java.util.Scanner;

public class whileMaxAndMin {
	public static void main(String[] args) {
		
		System.out.print("Enter a list of of numbers: ");
		Scanner input = new Scanner( System.in );
		Scanner inputLine = new Scanner( input.nextLine() );
		
		double max = inputLine.nextDouble();
		double min = max;

		while (inputLine.hasNextDouble()) 
		{
			double currentNumber = inputLine.nextDouble();
			if (currentNumber > max)
				max = currentNumber;
			if (currentNumber < min)
				min = currentNumber;
		}
		
		System.out.print("Max: " + max + " Min: " + min);
		
		inputLine.close();
		input.close();

	}
}

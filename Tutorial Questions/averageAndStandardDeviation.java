import java.util.Scanner;

public class averageAndStandardDeviation {
	public static void main(String[] args) {
		
		// input 3 numbers
		final int NUMBERS = 3; //how many numbers there are
		
		System.out.print("First number: ");
		Scanner input = new Scanner( System.in );
		Double number1 = input.nextDouble();
		
		System.out.print("Second number: ");
		Double number2 = input.nextDouble();
		
		System.out.print("Third number: ");
		Double number3 = input.nextDouble();
		input.close();
		
		// Average
		double average = (number1 + number2 + number3) / NUMBERS;
		
		// Standard Deviation
		double standardDeviation = Math.sqrt((Math.pow((number1 - average), 2)
								   + Math.pow((number2 - average), 2)
								   + Math.pow((number3 - average), 2)) / NUMBERS);
		
		//Print Average and Standard Deviation
		System.out.printf("The average is: %.3f %n"
						+ "The standard deviation is: %.3f", average, standardDeviation);
		//test: 76, 5, 13 should give 31.3333... and 31.7525...
	}
}

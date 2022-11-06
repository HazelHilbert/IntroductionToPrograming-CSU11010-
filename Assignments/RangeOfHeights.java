/*  SELF ASSESSMENT of whether my code is easy to understand.
   1. Did I use easy-to-understand meaningful variable names?
       Mark out of 5:   5
       Comment: yes the variable names are easy to understand
   2. Did I format the variable names properly (in lowerCamelCase)?
       Mark out of 5:   5
       Comment: yes variable names are in lowerCamelCase
   3. Did I indent the code appropriately?
       Mark out of 5:  5 
       Comment: the code is indented properly
   4. Did I implement a while loop or do-while loop as required?
       Mark out of 10:   10
       Comment: yes, a while loop is used
      Total Mark out of  25 (Add all the previous marks):  25
 */

import java.util.Scanner;

public class RangeOfHeights {
	public static void main(String[] args) {

		System.out.print("Enter a height in metres (0.0 to finish)> ");
		Scanner input = new Scanner( System.in );

		if (input.hasNextDouble())
		{
			double currentNumber = input.nextDouble();
			double maximumValue = currentNumber;
			double minimumValue = currentNumber;

			while (currentNumber != 0) 
			{
				if (currentNumber < 0)
					System.out.println("Negative heights are invalid.");		

				else
				{
					if (currentNumber < minimumValue)
						minimumValue = currentNumber;
					else if (currentNumber > maximumValue)
						maximumValue = currentNumber;
					System.out.println("Heights entered so far are in the range "
							+ minimumValue + " to " + maximumValue);
				}

				System.out.print("Enter a height in metres (0.0 to finish)> ");
				if (input.hasNextDouble())
					currentNumber = input.nextDouble();
				else
				{
					currentNumber = 0;
					System.out.print("Error: please enter a number");		
				}
			}
		}
		
		else
			System.out.print("Error: please enter a number");	

		input.close();

	}
}


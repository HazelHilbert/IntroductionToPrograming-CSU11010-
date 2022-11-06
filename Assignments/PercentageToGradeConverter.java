/*  SELF ASSESSMENT of whether my code is easy to understand.
   1. Did I use easy-to-understand meaningful variable names?
       Mark out of 5:   5
       Comment: yes, variable and constant names are easy to understand
   2. Did I format the variable names properly (in lowerCamelCase)?
       Mark out of 5:   5
       Comment: yes, variable and constant names formated according to the coding standard
   3. Did I indent the code appropriately?
       Mark out of 5:   5
       Comment: yes, the code is properly indented
   4. Did I implement a switch statement as required?
       Mark out of 10:   10
       Comment: yes, a switch statement was used
   5. Did I implement a switch statement as required?
       Mark out of 10:   10
       Comment: yes, a do while loop was used
     Total Mark out of  25 (Add all the previous marks):  25
 */


import java.util.Scanner;

public class PercentageToGradeConverter {

	public static final double MINIMUM_PERCENTAGE = 0.0;
	public static final double MAXIMUM_PERCENTAGE = 100.0;
	public static final double MINIMUM_PERCENTAGE_F1 = 35.0;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		boolean quit = false;

		do	// while (!quit)
		{
			System.out.print("Enter a percentage (or 'quit' to finish)> ");

			if (input.hasNextDouble()) 
			{
				double percentage = input.nextDouble();
				int roundedPercentage = (int) Math.round(percentage);

				if (percentage <= MAXIMUM_PERCENTAGE && percentage >= MINIMUM_PERCENTAGE)
				{
					String grade = "";
					String indefiniteArticle = "a ";	
					switch ((roundedPercentage / 10) * 10)
					{
						case 100:
						case 90:
						case 80:
						case 70:
							grade = "I";
							break;
						case 60:
							grade = "II.1";
							break;
						case 50:
							grade = "II.2";
							break;
						case 40:
							grade = "III";
							break;
						default:
							indefiniteArticle = "an ";
							grade = (roundedPercentage >= MINIMUM_PERCENTAGE_F1) ? "F1" : "F2";
							break;
						}
					System.out.println("The grade for " + percentage + "% is " + 
							indefiniteArticle + grade);
				}
				else
					System.out.println("Error: Percentages must be between 0.0% and 100.0%");	
			}
			else
			{
				if (input.next().equalsIgnoreCase("quit"))
					quit = true;
				else
					System.out.println("Error: Enter a number between 0.0 and "
							+ "100.0, or the word quit to exit the program.");
			}

		} while (!quit);

		input.close();
	}
}

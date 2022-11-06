import java.util.Scanner;
public class FirstsAndPasses {

	/*  SELF ASSESSMENT of whether my code is easy to understand.
	   1. Did I use easy-to-understand meaningful variable and constant names?
	       Mark out of 10: 10  
	       Comment: yes, the constant and variable names are meaningful
	   2. Did I format the variable and constant names properly (in lowerCamelCase and UPPERCASE)?
	       Mark out of 5: 5
	       Comment: yes, variables use lowerCamelCase and constants use UPPERCASE
	   3. Did I indent the code appropriately?
	       Mark out of 10: 10
	       Comment: yes, the body of selection and iteration statements are indented
	   4. Did I implement a for loop to read the input as required?
	       Mark out of 10: 10
	       Comment: yes, the input is checked using if statements
	      Total Mark out of  35 (Add all the previous marks): 35
	 */

	public static final double MINIMUM_FIRST_CLASS_PERCENTAGE = 70.0;
	public static final double MINIMUM_PASS_PERCENTAGE = 40.0;
	public static final double MINIMUM_MARK = 0.0;
	public static final double MAXIMUM_MARK = 100.0;
	public static final int MINIMUM_NUMBER_OF_STUDENTS = 1;

	public static void main(String[] args) {
		System.out.print("Enter the number of students in the class> ");
		Scanner input = new Scanner( System.in );
		int numberOfStudents = input.nextInt();

		int numberOfFirsts = 0;
		int numberOfPasses = 0;

		if (numberOfStudents >= MINIMUM_NUMBER_OF_STUDENTS) 
		{
			int studentCounter = 1;
			while (studentCounter <= numberOfStudents)
			{
				System.out.printf("Enter the percentage obtained by student %d> ", studentCounter);
				double precentage = input.nextDouble();

				if (precentage >= MINIMUM_MARK && precentage <= MAXIMUM_MARK) 
				{

					if (Math.round(precentage) >= MINIMUM_FIRST_CLASS_PERCENTAGE)
						numberOfFirsts++;
					if (Math.round(precentage) >= MINIMUM_PASS_PERCENTAGE)
						numberOfPasses++;
					studentCounter++;
				}

				else
					System.out.print("Invalid percentage.  Please enter the mark again for this student.\n");
			}

			double precentOfPasses = (numberOfPasses * 100.0)/numberOfStudents;

			System.out.printf("In this class of %d students, %d got a first class honour and %.1f%% passed the class",
					numberOfStudents, numberOfFirsts, precentOfPasses);
		}
		else
			System.out.printf("Error:  The number of students must be greater than 0");
		
		input.close();
	}
} 
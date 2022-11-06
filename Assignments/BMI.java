import java.util.Scanner;

public class BMI {
	public static void main(String[] args) {
		
		/*  SELF ASSESSMENT of whether my code is easy to understand.
		   1. Did I use easy-to-understand meaningful variable names?
		       Mark out of 10:  10  
		       Comment: yes, I used variable names such as height, weight, and BMI
		   2. Did I format the variable names properly (in lowerCamelCase)?
		       Mark out of 10:  10 
		       Comment: yes the variable names use lowerCamelCase
		   3. Did I indent the code appropriately?
		       Mark out of 10:  9
		       Comment: I believe I did indent the code appropriately, but I am not sure
		     Total Mark out of  30 (Add all the previous marks):  29
		*/
		
		System.out.print("What is your weight in kg?");
		Scanner imput = new Scanner( System.in );
		Double weight = imput.nextDouble();
		
		System.out.print("What is your height in metres?");
		Double height = imput.nextDouble();
		imput.close();
		
		Double BMI = weight / Math.pow(height, 2);
		System.out.println("Your BMI is " + BMI);
	}

}

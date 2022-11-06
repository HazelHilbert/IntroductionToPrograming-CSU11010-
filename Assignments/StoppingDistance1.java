import java.util.Scanner;

public class StoppingDistance1 {
	public static void main(String[] args) {
		/*  SELF ASSESSMENT of whether my code is easy to understand.
		   1. Did I use appropriate CONSTANTS instead of numbers within the code?
		       Mark out of 5: 5
		       Comment: yes, a constant was used for the unit conversion
		   2. Did I use easy-to-understand, meaningful CONSTANT names?
		       Mark out of 5: 5
		       Comment: I used the constant name KM_PER_H_TO_M_PER_S, 
		       			which has a relatively self-explanatory meaning 
		   3. Did I format the CONSTANT names properly (in UPPERCASE)?
		       Mark out of 5: 5
		       Comment: yes the constant is all uppercase with underscores
		   4. Did I use easy-to-understand meaningful variable names?
		       Mark out of 10: 10
		       Comment: yes, I used variable names such as: 
		       			speedInMetersPerSecond, reactionDistance, stoppingDistance, etc.
		   5. Did I format the variable names properly (in lowerCamelCase)?
		       Mark out of 5: 5   
		       Comment: yes, all variable names are in lowerCamelCase
		   6. Did I indent the code appropriately?
		       Mark out of 10: 10  
		       Comment: yes, code is indented appropriately
		     Total Mark out of  40 (Add all the previous marks): 40  
		*/

		
		//receive inputs
		System.out.print("Enter vehicle speed in km/hr> ");
		Scanner imput = new Scanner(System.in);
		Double speedInKilometresPerHour = imput.nextDouble();
		
		System.out.print("Enter reaction time in seconds> ");
		Double reactionTime = imput.nextDouble();
		imput.close();
		
		// multiply by 1000 to convert km to m, and divide by 60^2 to convert hours to seconds 
		final double KILOMETERS_PER_HOUR_TO_METERS_PER_SECOND = 1000 / Math.pow(60, 2);
		double speedInMetersPerSecond = speedInKilometresPerHour * KILOMETERS_PER_HOUR_TO_METERS_PER_SECOND; 
		
		
		//calculate stopping distance
		double reactionDistance = speedInMetersPerSecond * reactionTime;
		double brakingDistance = Math.pow(speedInMetersPerSecond, 2) / 20;
		double stoppingDistance = reactionDistance + brakingDistance;
		
		//print result
		System.out.printf(
			"At a speed of %.1fkm/hr and with a reaction time of %.1fs, the stopping distance would be %.1fm",
			speedInKilometresPerHour, reactionTime, stoppingDistance);
	
	}
}

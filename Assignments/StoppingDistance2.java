import java.util.Scanner;

public class StoppingDistance2 {
	public static void main(String[] args) {
		/*  SELF ASSESSMENT of whether my code is easy to understand.
		   1. Did I use easy-to-understand meaningful variable and constant names?
		       Mark out of 15: 15
		       Comment: yes, I used meaningful names for variables and constants
		   2. Did I format the variable and constant names properly?
		       Mark out of 5: 5
		       Comment: yes, variables names used lowerCamelCase, and constants used UPPERCASE
		   3. Did I indent the code appropriately?
		       Mark out of 10: 10
		       Comment: the code is properly indented
		      Total Mark out of  30 (Add all the previous marks): 30
		*/
		
		//receive inputs
		System.out.print("Enter vehicle speed in km/hr> ");
		Scanner input = new Scanner(System.in);
		Double speedInKilometresPerHour = input.nextDouble();
		
		System.out.print("Enter age in years> ");
		Integer ageInYears = input.nextInt();
		
		System.out.print("Is the road wet (Yes/No)? ");
		Boolean isRoadWet = input.next().equalsIgnoreCase("Yes");
		input.close();
		
		// find reaction time
		double reactionTime = 2.5;
		if (ageInYears < 50) {
			reactionTime = 2.0;
		}
		else if (ageInYears > 59) {
			reactionTime = 3.0;
		}
		
		// find coefficient of friction and road condition (wet or dry)
		String roadCondition = "dry";
		double frictionCoefficient = 0.8;
		if (isRoadWet) {
			frictionCoefficient = 0.4;
			roadCondition = "wet";
		}
		
		// multiply by 1000 to convert km to m, and divide by 60^2 to convert hours to seconds 
		final double KILOMETERS_PER_HOUR_TO_METERS_PER_SECOND = 1000 / Math.pow(60, 2);
		double speedInMetersPerSecond = speedInKilometresPerHour * KILOMETERS_PER_HOUR_TO_METERS_PER_SECOND; 
		
		
		//calculate stopping distance
		double reactionDistance = speedInMetersPerSecond * reactionTime;
		double brakingDistance = Math.pow(speedInKilometresPerHour, 2) / (250 * frictionCoefficient);
		double stoppingDistance = reactionDistance + brakingDistance;
		
		//print result
		System.out.printf(
			"As the road is %s, the coefficient of friction is %.1f%n"
			+ "As the driver is %d years old, his/her reaction time is %.1fs%n"
			+ "At a speed of %.1fkm/hr, the reaction distance is %.0fm, the braking "
			+ "distance is %.0fm, and so the stopping distance is %.0fm",
			roadCondition, frictionCoefficient, ageInYears, reactionTime, 
			speedInKilometresPerHour, reactionDistance, brakingDistance, stoppingDistance);
	}
}

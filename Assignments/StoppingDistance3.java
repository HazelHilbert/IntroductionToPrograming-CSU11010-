/*  SELF ASSESSMENT of whether my code is easy to understand.
   1. Did I use easy-to-understand meaningful and properly formatted variable names and constants?
       Mark out of 5:   5
       Comment: yes the variable and constant names are meaningful and properly formatted
    2. Did I indent the code appropriately?
       Mark out of 5:   5
       Comment: yes the code is properly indented
   3. Did I make use of the functions appropriately within main and the other functions?
       Mark out of 5:   5
       Comment: yes, the functions are implemented and used properly
   4. Have I avoided inappropriate duplication of code?
       Mark out of 5:   5
       Comment: yes, code is not duplicated
     Total Mark out of  20 (Add all the previous marks):  20
*/

import java.util.Scanner;

public class StoppingDistance3 {

	public static final double FRICTION_ICY_ROAD = 0.1;
	public static final double FRICTION_WET_ROAD = 0.4;
	public static final double FRICTION_DRY_ROAD = 0.8;
	public static final double KILOMETERS_PER_HOUR_TO_METERS_PER_SECOND = 1000 / Math.pow(60, 2);
	
	public static double computeCoefficientOfFriction(boolean roadIsIcy, boolean roadIsWet) {
		return roadIsIcy ? FRICTION_ICY_ROAD : roadIsWet ? FRICTION_WET_ROAD : FRICTION_DRY_ROAD;
	}

	public static double computeBrakingDistance(double vehicleSpeed, boolean roadIsIcy, boolean roadIsWet) {
		// numbers from formula for braking distance
		return (Math.pow(vehicleSpeed, 2) / (250 * computeCoefficientOfFriction(roadIsIcy, roadIsWet))); 
	}
	
	public static double computeReactionDistance(double vehicleSpeed, int age) {
		double speedInMetersPerSecond = vehicleSpeed * KILOMETERS_PER_HOUR_TO_METERS_PER_SECOND;  
		// numbers from formula for reaction time:
		double reactionTime = 1.0 + (Math.abs(age - 24) * 0.05);
		return (speedInMetersPerSecond * reactionTime);
	}

	public static int computeStoppingDistance(double vehicleSpeed, int age, boolean roadIsIcy, boolean roadIsWet) {
		return (int) Math.round(computeReactionDistance(vehicleSpeed, age)
				+ computeBrakingDistance(vehicleSpeed, roadIsIcy, roadIsWet));
	}

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		Double vehicleSpeed = -1.0;
		while (vehicleSpeed < 0) 
		{
			System.out.print("Enter vehicle speed in km/hr> ");
			if (input.hasNextDouble())
				vehicleSpeed = input.nextDouble();
			if (vehicleSpeed < 0.0)
				System.out.println("Error: Enter a positive number for the speed of the vehicle.");
			input.nextLine();
		} 
		
		int age = -1;
		while (age < 0) 
		{
			System.out.print("Enter age in years> ");
			if (input.hasNextInt())
				age = input.nextInt();
			if (age < 0)
				System.out.println("Error: Enter a positive whole number for the age of the driver");
			input.nextLine();
		} 
		
		Boolean invalidInput = true;
		String roadConditionInput = "";
		Boolean roadIsWet = true;
		while (invalidInput) 
		{
			System.out.print("Is the road wet (Yes/No)? ");
			if (input.hasNext())
				roadConditionInput = input.next();
				if (roadConditionInput.equalsIgnoreCase("Yes"))
					invalidInput = false;
				else if (roadConditionInput.equalsIgnoreCase("No"))
				{
					roadIsWet = false;
					invalidInput = false;
				}
			if (invalidInput)
				System.out.println("Error: You must enter either Yes or No.");
			input.nextLine();
		} 
		
		invalidInput = true;
		roadConditionInput = "";		
		Boolean roadIsIcy = true;
		while (invalidInput) 
		{
			System.out.print("Is the road icy (Yes/No)? ");
			if (input.hasNext())
				roadConditionInput = input.next();
				if (roadConditionInput.equalsIgnoreCase("Yes"))
					invalidInput = false;
				else if (roadConditionInput.equalsIgnoreCase("No"))
				{
					roadIsIcy = false;
					invalidInput = false;
				}
			if (invalidInput)
				System.out.println("Error: You must enter either Yes or No.");
			input.nextLine();
		} 
		
		input.close();

		String roadCondition = roadIsIcy ? (roadIsWet ? "icy and wet" : "icy and dry") : 
			(roadIsWet ? "wet" : "dry");

		System.out.printf(
				"As the road is %s, the coefficient of friction is %.1f%n"
						+ "At a speed of %.1fkm/hr, a driver who is %d years old, "
						+ "the reaction distance is %.0fm, the braking distance is %.0fm, "
						+ "and so the stopping distance is %dm",
						roadCondition, computeCoefficientOfFriction(roadIsIcy, roadIsWet),
						vehicleSpeed, age, computeReactionDistance(vehicleSpeed, age),
						computeBrakingDistance(vehicleSpeed, roadIsIcy, roadIsWet),
						computeStoppingDistance(vehicleSpeed, age, roadIsIcy, roadIsWet));
	}
}

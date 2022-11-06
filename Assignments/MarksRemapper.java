import java.util.Scanner;

public class MarksRemapper {
	public final static double MINIMUM_PERCENTAGE = 0.0;
	public final static double MAXIMUM_PERCENTAGE = 100.0;
	public final static double DESIRED_AVERAGE = 60.0;
	public final static double DESIRED_STANDARD_DEVIATION = 20.0;

	public static void main(String[] args) {

		System.out.print("Enter all percentages (separated by spaces): ");
		Scanner input = new Scanner(System.in).useDelimiter("[^0-9]+");

		String[] stringArrayOfPercentages = input.nextLine().split(" ");
		double[] inputArrayOfPercentages = new double[stringArrayOfPercentages.length];
		for (int index = 0; index < stringArrayOfPercentages.length; index++) 
		{
			try 
			{
				double precentage = Double.parseDouble(stringArrayOfPercentages[index]);
				if (precentage <  MINIMUM_PERCENTAGE || precentage >  MAXIMUM_PERCENTAGE)
					inputArrayOfPercentages[index] = -1;
				else
					inputArrayOfPercentages[index] = precentage;
			}
			catch (Exception e) 
			{
				inputArrayOfPercentages[index] = -1;
			}
		}  
		input.close();
		
		int invalidInputs = 0;
		for (double precentage : inputArrayOfPercentages)
			invalidInputs += (precentage == -1) ? 1 : 0;
		double[] originalArrayOfPercentages = new double[inputArrayOfPercentages.length - invalidInputs];
		
		int indexForInputArray = 0;
		for (int index = 0; index < originalArrayOfPercentages.length; index++) 
		{
			if (inputArrayOfPercentages[indexForInputArray] == -1)
				index--;
			else
				originalArrayOfPercentages[index] = inputArrayOfPercentages[indexForInputArray];
			indexForInputArray++;
		}
		if (originalArrayOfPercentages.length != inputArrayOfPercentages.length)
			System.out.println("Error: an invalid precentage was entered");
		
		double[] newArrayOfPercentages = originalArrayOfPercentages.clone();
		modifyAllMarks(newArrayOfPercentages, DESIRED_AVERAGE, DESIRED_STANDARD_DEVIATION);

		System.out.printf("The original average was %.1f and the standard deviation was %.1f%n", 
				determineAverage(originalArrayOfPercentages), 
				determineStandardDeviation(originalArrayOfPercentages, determineAverage(originalArrayOfPercentages)));
		for(int index = 0; index < newArrayOfPercentages.length; index++)
			System.out.printf("%.1f->%.1f" + ((index == newArrayOfPercentages.length-1) ? "" : ", "), 
					originalArrayOfPercentages[index], newArrayOfPercentages[index]);
		System.out.printf("%nThe new average is %.1f and the new standard deviation is %.1f%n", 
				determineAverage(newArrayOfPercentages), 
				determineStandardDeviation(newArrayOfPercentages, determineAverage(newArrayOfPercentages)));
	}

	public static double determineAverage(double[] arrayOfNumbers) {
		if (arrayOfNumbers == null || arrayOfNumbers.length == 0)
			return 0.0;
		double sum = 0.0;
		for (double number : arrayOfNumbers)
			sum += number;
		return (sum / arrayOfNumbers.length);
	}

	public static double determineStandardDeviation(double[] arrayOfNumbers, double average) {
		if (arrayOfNumbers == null || arrayOfNumbers.length == 0)
			return 0.0;
		double sum = 0.0;
		for (double number : arrayOfNumbers)
			sum += Math.pow(number - average, 2);
		return Math.sqrt(sum / arrayOfNumbers.length);
	}

	public static boolean modifyAllMarks(double[] arrayOfMarks, double desiredAverage, double desiredStandardDeviation) {
		double currentAverage = determineAverage(arrayOfMarks);
		double currentStandardDeviation = determineStandardDeviation(arrayOfMarks, currentAverage);
		if (arrayOfMarks.length == 1) {
			arrayOfMarks[0] = desiredAverage;
			return false;
		}
		while (currentAverage != desiredAverage && currentStandardDeviation != desiredStandardDeviation) 
		{
			for (int index = 0; index < arrayOfMarks.length; index++)
				arrayOfMarks[index] = desiredAverage + (arrayOfMarks[index] - currentAverage) * desiredStandardDeviation / currentStandardDeviation;
			currentAverage = determineAverage(arrayOfMarks);
			currentStandardDeviation = determineStandardDeviation(arrayOfMarks, currentAverage);
		}
		for (int index = 0; index < arrayOfMarks.length; index++) 
		{
			arrayOfMarks[index] = (arrayOfMarks[index] < MINIMUM_PERCENTAGE) ? MINIMUM_PERCENTAGE : 
				(arrayOfMarks[index] > MAXIMUM_PERCENTAGE) ? MAXIMUM_PERCENTAGE : arrayOfMarks[index];
		}
		return true;
	}
}

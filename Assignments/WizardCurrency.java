import java.util.Scanner;

public class WizardCurrency {

	public static final int POUNDS_TO_PENCE = 100;
	public static final double PENCE_TO_KNUTS = 812.0/499.0;
	public static final int GALLEON_TO_KNUTS = 493;
	public static final int SICKLES_TO_KNUTS = 29;


	public static int convertGBPToKnuts(int pounds, int pence) {
		return (int) Math.round(PENCE_TO_KNUTS * ((pounds * POUNDS_TO_PENCE) + pence));
	}

	public static String convertKnutsToWizardingCurrency(int totalKnuts) {
		return "HP" + (totalKnuts / GALLEON_TO_KNUTS) + ":" + 
				((totalKnuts % GALLEON_TO_KNUTS) /SICKLES_TO_KNUTS) + ":" +
				((totalKnuts % GALLEON_TO_KNUTS) % SICKLES_TO_KNUTS);
	}

	public static String convertGBPToWizardingCurrency(int pounds, int pence) {
		return convertKnutsToWizardingCurrency(convertGBPToKnuts(pounds, pence));
	}

	public static int convertWizardingCurrencyToKnuts(int numGalleons, int numSickles, int numKnuts) {
		return ((numGalleons * GALLEON_TO_KNUTS) + (numSickles * SICKLES_TO_KNUTS) + numKnuts);
	}

	public static int convertWizardingCurrencyToPence(int numGalleons, int numSickles, int numKnuts) {
		return (int) Math.round(convertWizardingCurrencyToKnuts(numGalleons, numSickles, numKnuts) / PENCE_TO_KNUTS);

	}

	public static double getNumberFromUser(String prompt, String errorMessage, Scanner input, boolean integerRequired) {
		double number = -1;
		while (number < 0)
		{
			System.out.print(prompt);
			if (integerRequired && input.hasNextInt()) 
				number = input.nextInt();
			else if (!integerRequired && input.hasNextDouble()) 
				number = input.nextDouble();
			else 
			{
				System.out.print(errorMessage);
			}
			input.nextLine();
		}
		return number;
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		boolean quit = false;

		while (!quit) 
		{
			int function = (int) getNumberFromUser(("1. Convert Wizarding Currency To GBP\n"
					+ "2. Convert Knuts To Wizarding Currency and GBP\n"
					+ "3. Convert GBP to Wizarding Currency\n"
					+ "4. Quit\n"
					+ "Select function> ") , 
					"Error: Invalid selection.\n\n", input, true);

			int galleons = 0;
			int sickles = 0;
			int knuts = 0;
			double pounds = 0.0;

			switch (function) {
			case 1:
				galleons = (int) getNumberFromUser("Enter the number of Galleons > ", 
						"Error: The number of Galleons should be an integer (e.g. 3)\n",
						input, true);
				sickles = (int) getNumberFromUser("Enter the number of Sickles > ", 
						"Error: The number of Sickles should be an integer (e.g. 5)\n",
						input, true);
				knuts = (int) getNumberFromUser("Enter the number of Knuts > ", 
						"Error: The number of Knuts should be an integer (e.g. 12)\n",
						input, true);
				System.out.printf("In British Pounds HP%d:%d:%d is GBP%.2f\n\n", galleons, sickles, knuts, 
						(convertWizardingCurrencyToPence(galleons, sickles, knuts) * 1.0 / POUNDS_TO_PENCE ));
				break;
			case 2:
				knuts = (int) getNumberFromUser("Enter the number of Knuts > ", 
						"Error: The number of Knuts should be an integer (e.g. 56)\n",
						input, true);
				System.out.printf("%d knuts is %s is equal to GBP%.2f\n\n", knuts, convertKnutsToWizardingCurrency(knuts),
						(convertWizardingCurrencyToPence(0, 0, knuts) * 1.0 / POUNDS_TO_PENCE ));
				break;
			case 3:
				pounds = getNumberFromUser("Enter the number of British pounds and pence (e.g. 1.24) > ", 
						"Error: Invalid number of British pounds and pence\n",
						input, false);
				System.out.printf("In wizarding currency GBP%.2f is %s\n\n", pounds,
						convertGBPToWizardingCurrency(0, (int) (pounds * POUNDS_TO_PENCE)));
				break;
			case 4:
				quit = true;
				break;
			}
		}
		input.close();
	}
}

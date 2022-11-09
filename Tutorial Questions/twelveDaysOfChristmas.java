
public class twelveDaysOfChristmas {

	public static int TOTAL_DAYS = 12;

	public static void main(String[] args) {

		for (int day = 1; day <= TOTAL_DAYS; day++)
		{
			System.out.printf("On the %s day of Christmas,%n" +
					"my true love sent to me:%n", ordinalNumbers(day));

			switch (day) 
			{
			case 12:
				System.out.printf("12 Drummers Drumming,%n");
			case 11:
				System.out.printf("11 Pipers Piping,%n");
			case 10:
				System.out.printf("10 Lords a Leaping,%n");
			case 9:
				System.out.printf("9 Ladies Dancing,%n");
			case 8:
				System.out.printf("8 Maids a Milking,%n");
			case 7:
				System.out.printf("7 Swans a Swimming,%n");
			case 6:
				System.out.printf("6 Geese a Laying,%n");
			case 5:
				System.out.printf("5 Golden Rings,%n");
			case 4:
				System.out.printf("4 Calling Birds,%n");
			case 3:
				System.out.printf("3 French Hens,%n");
			case 2:
				System.out.printf("2 Turtle Doves,%nand ");
			case 1:
				System.out.printf("a Partridge in a Pear Tree.%n%n");
			default:
				break;
			}
		}
	}

	// given a number, will return the ordinal number from 1 up to 12
	public static String ordinalNumbers(int number) 
	{
		String[] ordinals = {"first", "second", "thrid", "fourth", 
				"fifth", "sixth", "seventh", "eighth", "ninth", 
				"tenth", "eleventh", "twelfth"};
		return ordinals[--number];
		
	}
}

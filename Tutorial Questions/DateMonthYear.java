import java.util.Scanner;

public class DateMonthYear {

	public static boolean validDate(int day, int month, int year) {
		if (day <= daysInMonth(month, year) && month <= 12 && month > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public static int daysInMonth(int month, int year) {
		int days = 31;
		switch(month) {
			case 2:
				if(isLeapYear(year))
				{
					days = 29;
				}
				else
				{
					days = 28;
				}
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				days = 30;
				break;
		}
		return days;
	}

	public static boolean isLeapYear(int year) {
		boolean leapYear = false;
		if (year % 100 == 0) 
		{
			if (year % 400 == 0)
			{
				leapYear = true;
			}
		}
		else
		{
			if (year % 4 == 0)
			{
				leapYear =  true; 
			}
		}
		return leapYear;
	}

	public static void main(String[] args) {		
		System.out.print("Enter a date (dd/mm/yyyy): ");
		Scanner input = new Scanner( System.in ).useDelimiter("[^0-9]+");
		int day = input.nextInt();
		int month = input.nextInt();
		int year = input.nextInt();
		input.close();
		
		if (validDate(day, month, year))
		{
			System.out.print("valid date");
		}
		else
		{
			System.out.print("invalid date");
		}
	}
}

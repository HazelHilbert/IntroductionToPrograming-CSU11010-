import java.util.Scanner;

public class multiples {
	public static void main(String[] args) {

		System.out.print("Enter factor: ");
		Scanner input = new Scanner( System.in );
		int factor = input.nextInt();

		System.out.print("Enter upper limit: ");
		final int UPPER_LIMIT = input.nextInt();
		input.close();
		
		if ((factor > 0) && (UPPER_LIMIT > 0))
		{
			System.out.printf("The multiples of %d (up to %d) are", factor, UPPER_LIMIT);
			for (int counter = 0; counter <= UPPER_LIMIT; counter += factor) 
				System.out.printf(" %d,", counter);
		}
	}
}

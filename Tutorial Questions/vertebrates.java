import java.util.Scanner;

public class vertebrates {
	public static void main(String[] args) {
		
		System.out.print("Is the animal cold blooded (Yes/No)? ");
		Scanner input = new Scanner( System.in );
		boolean hasColdBlood = input.next().equalsIgnoreCase("Yes");
		
		if (hasColdBlood) {
			System.out.print("Does the animal have scales (Yes/No)? ");
			boolean hasScales = input.next().equalsIgnoreCase("Yes");
			
			if (hasScales) {
				System.out.print("Does the animal have fins (Yes/No)? ");
				boolean hasFins = input.next().equalsIgnoreCase("Yes");
				
				if (hasFins) {
					System.out.print("The animal is an fish");
				}
				else {
					System.out.print("The animal is an reptile");
				}
			}
			else {
				System.out.print("The animal is an amphibian");
			}
		}
		
		else {
			System.out.print("Does the animal have feathers (Yes/No)? ");
			boolean hasFeathers = input.next().equalsIgnoreCase("Yes");
			
			if (hasFeathers) {
				System.out.print("The animal is a bird");
			}
			else {
				System.out.print("The animal is a mammal");
			}
		}
		
		input.close();
		
	}
}

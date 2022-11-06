/* SELF ASSESSMENT 
   1. createSequence:
		Did I use the correct method definition?
		Mark out of 5: 5
		Comment: yes I did
		Did I create an array of size n (passed as the parameter) and initialise it?
		Mark out of 5: 5
		Comment: yes, but it was a two dimensional array
		Did I return the correct item?
		Mark out of 5: 5
		Comment: yes, I returned an array 
   2. crossOutMultiples
		Did I use the correct method definition?
		Mark out of 5: 5
		Comment: yes
		Did I ensure the parameters are not null and one of them is a valid index into the array
		Mark out of 2: 2
		Comment: yes I checked for that
		Did I loop through the array using the correct multiple?
		Mark out of 5: 5
		Comment: yes
		Did I cross out correct items in the array that were not already crossed out?
		Mark out of 3: 3
		Comment: yes, I did so by changing 1 to 0 for each index
   3. sieve   
		Did I have the correct function definition?
		Mark out of 5: 5
		Comment: yes
		Did I make calls to other methods?
		Mark out of 5: 5
		Comment: yes I called createSequence() and crossOutMultiples()
		Did I return an array with all non-prime numbers are crossed out?
		Mark out of 2: 2
		Comment: yes
   4. sequenceTostring  
		Did I have the correct function definition?
		Mark out of 5: 5
		Comment: yes
		Did I ensure the parameter to be used is not null?
		Mark out of 3: 3
		Comment: yes, if it is I return a String saying "error"
		Did I Loop through the array updating the String variable with the non-crossed out numbers and the crossed numbers in brackets? 
		Mark out of 10: 10
		Comment: yes   
   5. nonCrossedOutSubseqToString  
		Did I have the correct function definition
		Mark out of 5: 5
		Comment: I did
		Did I ensure the parameter to be used is not null?  
		Mark out of 3: 3
		Comment: yes, if it is I return a String saying "error"
		Did I loop through the array updating the String variable with just the non-crossed out numbers? 
		Mark out of 5: 5
		Comment: yes
   6. main  
		Did I ask  the user for input n and handles input errors?  
		Mark out of 5: 5
		Comments: yes I asked for an input and handled invalid inputs
		Did I make calls to other methods (at least one)?
		Mark out of 5: 5
		Comment: yes I called sequenceToString() and nonCrossedOutSubseqToString()
		Did I print the output as shown in the question?  
		Mark out of 5: 5
		Comment: yes, but I did so by adding a print statement in the sieve method
   7. Overall
		Is my code indented correctly?
		Mark out of 4: 4
		Comments: yes it is
		Do my variable names make sense?
		Mark out of 4: 4
		Comments: I used variable names consistent with the question, and the others are locical
		Do my variable names, method names and class name follow the Java coding standard
		Mark out of 4: 4
		Comments: they do
   Total Mark out of 100 (Add all the previous marks): 100
 */

import java.util.Scanner;

public class SieveOfEratosthenes {

	public static int[][] createSequence(int n) {
		if (n < 2)
			return null;
		int[][] sigma = new int[2][n];
		for (int count = 2; count <= n; count++) {
			sigma[1][count-2] = 1;
			sigma[0][count-2] = count;
		}
		return sigma;
	}

	public static void crossOutHigherMultiples(int[][] sigma, int n) {
		if (sigma != null && n <= sigma[0].length){
			for (int count = 2; count <= sigma[0].length; count++) {
				if(sigma[0][count-2] % n == 0 && sigma[0][count-2] / n != 1)
					sigma[1][count-2] = 0;
			}
		}
	}

	public static int[][] sieve(int n) {
		int[][] sigma = createSequence(n);
		int counter = 2;
		System.out.println(sequenceToString(sigma));
		while(counter < Math.sqrt(n)) {
			if (sigma[1][counter-2] == 1) {
				crossOutHigherMultiples(sigma, counter);
				System.out.println(sequenceToString(sigma));
			}
			counter++;
		}
		return sigma;
	}

	public static String sequenceToString(int[][] sigma) {
		if (sigma == null)
			return "error";
		String stringSequence = "2";
		for (int count = 3; count <= sigma[0].length; count++) {
			if (sigma[1][count-2] == 1)
				stringSequence += ", " + sigma[0][count-2];
			else
				stringSequence += ", [" + sigma[0][count-2] + "]";
		}
		return stringSequence;
	}

	public static String nonCrossedOutSubseqToString(int[][] sigma) {
		if (sigma == null)
			return "error";
		String stringSequence = "2";
		for (int count = 3; count <= sigma[0].length; count++) {
			if (sigma[1][count-2] == 1)
				stringSequence += ", " + sigma[0][count-2];
		}
		return stringSequence;	
	}

	public static void main(String[] args) {		
		Scanner input = new Scanner(System.in);
		boolean quit = false;
		while (!quit) {
			System.out.print("Enter int >= 2 : ");
			if(input.hasNextInt()) {
				int n = input.nextInt();
				if (n < 2) {
					System.out.println("Please enter a valid input");
					input.nextLine();
				}
				else {
					System.out.println(nonCrossedOutSubseqToString(sieve(n)));
					quit = true;
				}
			}
			else {
				System.out.println("Please enter a valid input");
				input.nextLine();
			}
		}
		input.close();
	}
}

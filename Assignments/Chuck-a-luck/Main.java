/* SELF ASSESSMENT 

1. ResolveBet
I have correctly defined ResolveBet which takes the bet type (String) and the Wallet object, and a void return type [Mark out of 7: 7].
Comment: yes ResolveBet takes in the bet type and wallet and returns nothing
My program presents the amount of cash in the wallet and asks the user how much he/she would like to bet [Mark out of 8: 8].
Comment: yes it does
My program ensures the bet amount is not greater than the cash in the wallet [Mark out of 5: 5].
Comment: yes, if so it outputs an error saying invalid bet
My program creates three Dice objects, rolls them and creates a total variable with a summation of the roll values returned [Mark out of 15: 15]..
Comment: yes the resolveBet method does this
My program determines the winnings by comparing the bet type with the total and comparing the bet type with the dice faces for the triple bet [Mark out of 20: 20].
Comment: yes it checks to see if the bet type matches the dice
My program outputs the results (win or loss) and adds the winnings to the wallet if user wins or removes the bet amount from the wallet if the user loses [Mark out of 10: 10].
Comment: yes winnings or losses are displayed and taken from the wallet

2. Main
I ask the user for the amount of cash he/she has, create a Wallet object and put this cash into it [Mark out of 15: 15]
Comment: yes I have done this
My program loops continuously until the user either enters quit or the cash in the wallet is 0 [Mark out of 5: 5]
Comment: yes, the program stops once the money runs out or quit is entered
I ask the user to enter any of the four bet types or quit [Mark out of 5: 5].
Comment: yes
My program calls resolveBet for each bet type entered [Mark out of 5: 5].
Comment: yes the main does this
At the end of the game my program presents a summary message regarding winnings and losses [Mark out of 5: 5]
Comment: yep at the end it will present a summary

 Total Mark out of 100 (Add all the previous marks): 100
*/

import java.util.Scanner;

public class Main {
	public static void ResolveBet(String betType, Wallet wallet, Scanner input) {
		System.out.print("You have " + wallet.check() + " in your wallet, how much would you like to bet? ");
		double bet = -1;
		if (input.hasNextDouble()) bet = input.nextDouble();
		if (bet > wallet.check() || bet < 0) {
			System.out.println("Invalid bet");
		}
		else {
			Dice d1 = new Dice();
			d1.roll();
			int f1 = d1.topFace();
			Dice d2 = new Dice();
			d2.roll();
			int f2 = d2.topFace();
			Dice d3 = new Dice();
			d3.roll();
			int f3 = d3.topFace();
			int sum = f1 + f2 + f3;
			
			boolean won = false;

			if (betType.equalsIgnoreCase("Triple")) {
				if (f1 == f2 && f1 == f3 && f1 != 1 && f1 != 6) {
					won = true;
				}
			}
			else if (betType.equalsIgnoreCase("Field")) {
				if (sum < 8 || sum > 12)
					won = true;
			}
			else if (betType.equalsIgnoreCase("High")) {
				if (sum > 10 && (f1 != f2 || f1 != f3))
					won = true;
			}
			else if (betType.equalsIgnoreCase("Low")) {
				if (sum < 10 && (f1 != f2 || f1 != f3))
					won = true;
			}

			if(won) {
				System.out.println("You Won");
				wallet.put(betType.equalsIgnoreCase("Triple") ? bet * 30 : bet);
			}
			else {
				System.out.println("You lost");
				wallet.get(bet);
			}
		}
		System.out.println("Your balance: " + wallet.check());
	}

	public static void main(String[] args) {
		boolean quit = false;
		double initialBalance = 0;
		System.out.print("How much money do you have? ");
		Scanner input = new Scanner(System.in);

		if (input.hasNextDouble()) 
			initialBalance = input.nextDouble();
		else {
			quit = true;
			System.out.println("Invalid input");
		}
		Wallet playerWallet = new Wallet();
		playerWallet.put(initialBalance);

		while (!quit) {
			if (playerWallet.check() == 0)
				quit = true;
			else {
				System.out.print("Enter the type of bet you would like to place (or 'quit'): ");
				if (input.hasNext()) {
					String betType = input.next();
					if (betType.equalsIgnoreCase("Triple")
							|| betType.equalsIgnoreCase("Field")
							|| betType.equalsIgnoreCase("High")
							|| betType.equalsIgnoreCase("Low")) {
						ResolveBet(betType, playerWallet, input);
					}
					else if (betType.equalsIgnoreCase("quit")) {
						quit = true;
					}
					else {
						System.out.println("Invalid bet type");
					}
				}
				input.nextLine();
			}
		}
		System.out.println("You started with " + initialBalance + " and ended with " + playerWallet.check());
		input.close();
	}
}
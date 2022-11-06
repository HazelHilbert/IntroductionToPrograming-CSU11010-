/* SELF ASSESSMENT
Connect4Game class (35 marks)
My class creates references to the Connect 4 Grid and two Connect 4 Players. It asks the user whether he/she would like to play/quit inside a loop. If the user decides to play then: 1. Connect4Grid2DArray is created using the Connect4Grid interface, 2. the two players are initialised - must specify the type to be ConnectPlayer, and 3. the game starts. In the game, I ask the user where he/she would like to drop the piece. I perform checks by calling methods in the Connect4Grid interface. Finally a check is performed to determine a win. 
Comment: yes, I ask the user to choose 1, 2 or no human players and based off of that begin to simulate a connect 4 game

Connect4Grid interface (10 marks)
I define all 7 methods within this interface.
Comment: yes, all the methods are defined in the interface

Connect4Grid2DArray class (25 marks) 
My class implements the Connect4Grid interface. It creates a grid using a 2D array Implementation of the method to check whether the column to drop the piece is valid. It provides as implementation of the method to check whether the column to drop the piece is full. It provides as implementation of the method to drop the piece.  It provides as implementation of the method to check whether there is a win.
Comment: yes, the class implements the interface and all of its method signatures to be used in reference to a 2D array

ConnectPlayer abstract class (10 marks)
My class provides at lest one non-abstract method and at least one abstract method. 
Comment: yes there is a non-abstract method (getColor()) and an abstract method (dropDisk())

C4HumanPlayer class (10 marks)
My class extends the ConnectPlayer class and overrides the abstract method(s). It provides the Human player functionality.
Comment: yes it correctly extends the ConnectPlayer class and asks the human player where they want to drop the disk

C4RandomAIPlayer class (10 marks)
My class extends the ConnectPlayer class and overrides the abstract method(s). It provides AI player functionality. 
Comment: yes it overrides the abstract method with the AI functionality

Total Marks out of 100: 100
*/

import java.util.Scanner;

public class Connect4Game {
	
	public static void main(String[] args) {
		Connect4Grid board = new Connect4Grid2DArray(6, 7);
		board.emptyGrid();
		Scanner input = new Scanner(System.in);
		ConnectPlayer redPlayer = chooseType('R', input);
		ConnectPlayer yellowPlayer = chooseType('Y', input);
		ConnectPlayer currentPlayer = redPlayer;
		System.out.println("\n" + board.toString());

		boolean quit = false;
		while(!quit) {
			if (board.didLastPieceConnect4()) {
				quit = true;
				System.out.println("The " + ((currentPlayer.getColor() == 'R') ? "yellow" : "red") + " player won!");
			}
			else if (board.isGridFull()) {
				quit = true;
				System.out.println("Draw!");
			}
			else {
				currentPlayer.dropDisk(board, input);
				System.out.println(board.toString());
				currentPlayer = (currentPlayer == redPlayer) ? yellowPlayer : redPlayer;
			}
		}
		input.close();
	}
	
	public static ConnectPlayer chooseType(char color, Scanner input) {
		boolean quit = false;
		while(!quit) {
			System.out.print("Choose the type of the " + ((color == 'R') ? "red" : "yellow") + " player ('AI' or 'human'): ");
			if(input.hasNext()) {
				String type = input.next();
				if (type.equalsIgnoreCase("AI")) return (new C4RandomAIPlayer(color));
				else if (type.equalsIgnoreCase("human")) return (new C4HumanPlayer(color));
				else System.out.println("Error: invalid input");
			}
			else System.out.println("Error: invalid input");
			input.nextLine();
		}
		return null;
	}
}

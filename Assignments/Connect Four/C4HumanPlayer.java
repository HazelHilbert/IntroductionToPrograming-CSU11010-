import java.util.Scanner;

public class C4HumanPlayer extends ConnectPlayer {

	public C4HumanPlayer(char color) {
		super(color);
	}

	@Override
	void dropDisk(Connect4Grid grid, Scanner input) {
		boolean quit = false;
		while(!quit) {
			input.nextLine();
			System.out.print(((getColor() == 'R') ? "Red " : "Yellow ") + "player, choose the column to drop your disk: ");
			if(input.hasNextInt()) {
				int column = input.nextInt()-1;
				if (grid.isValidColumn(column)) {
					if(!grid.isColumnFull(column)) {
						System.out.println();
						grid.dropPiece(this, column);
						quit = true;
					}
					else System.out.println("Error: that column is full, please enter another column");
				}
				else System.out.println("Error: please enter a valid column");
			}
			else System.out.println("Error: please enter a valid column");
		}
	}
}

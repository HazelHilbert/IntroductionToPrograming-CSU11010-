import java.util.Scanner;

public class C4RandomAIPlayer extends ConnectPlayer  {

	public C4RandomAIPlayer(char color) {
		super(color);
	}

	@Override
	void dropDisk(Connect4Grid grid, Scanner input) {
		System.out.println("The " + ((getColor() == 'R') ? "red " : "yellow ") + "player is droping their disk...\n");
		try {
		    Thread.sleep(1000);
		}
		catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		int column = (int) (Math.random() * grid.getColumns());
		while (grid.isColumnFull(column))
			column = (int) (Math.random() * grid.getColumns());
		grid.dropPiece(this, column);
	}
}

import java.util.Scanner;

abstract class ConnectPlayer {
	private char color;
	
	public ConnectPlayer(char color) {
		this.color = color;
	}
	public ConnectPlayer() {
		color = '0';
	}
	
	public char getColor() {
		return color;
	}
	
	abstract void dropDisk(Connect4Grid grid, Scanner input);
}

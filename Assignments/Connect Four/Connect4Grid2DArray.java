
public class Connect4Grid2DArray implements Connect4Grid{
	public static final char EMPTY = '0';
	private char[][] grid;

	public Connect4Grid2DArray(int rows, int columns) {
		grid = new char[rows][columns];
	}

	@Override
	public void emptyGrid() {
		for(int row = 0; row < grid.length; row++) {
			for(int col = 0; col < grid[0].length; col++) {
				grid[row][col] = EMPTY;
			}
		}
	}

	@Override
	public String toString() {
		String board = "";
		for(int row = 0; row < grid.length; row++) {
			for(int col = 0; col < grid[0].length; col++)
				board += grid[row][col] + " ";
			board += "\n";
		}
		for(int col = 1; col < grid[0].length; col++) board += "--";
		board += "-\n";
		for(int col = 1; col <= grid[0].length; col++) board += col + " ";
		board += "\n";
		return board;
	}

	@Override
	public boolean isValidColumn(int column) {
		return (column >= 0 && column <= grid[0].length - 1);
	}

	@Override
	public boolean isColumnFull(int column) {
		for (int row = 0; row < grid.length; row++) {
			if (grid[row][column] == EMPTY) return false;
		}
		return true;
	}

	@Override
	public void dropPiece(ConnectPlayer player, int column) {
		if (!isColumnFull(column) && isValidColumn(column)) {
			for (int row = grid.length-1; row >= 0; row--) {
				if (grid[row][column] == EMPTY) {
					grid[row][column] = player.getColor();
					row = -1;
				}
			}
		}
	}

	@Override
	public boolean didLastPieceConnect4() {
		int maxRows = grid.length; int minRows = 0;
		int maxCols = grid[0].length; int minCols = 0;
		for (int row = 0; row < grid.length; row++) {
			for(int col = 0; col < grid[0].length; col++) {
				char lastPiece = grid[row][col];
				if (lastPiece != EMPTY) {
					int consecutiveHorizontal = 1; 
					int consecutiveVertical = 1;
					int consecutiveDiagonal = 1;
					boolean countHorizontal = true;
					boolean countVertical = true;
					boolean countDiagonal = true;
					for (int c = col-1, r = row-1; c > col-4 || r > row-4; c--, r--) {
						if (countVertical && r >= minRows && grid[r][col] == lastPiece) consecutiveVertical++;
						else countVertical = false;
						if (countHorizontal && c >= minCols && grid[row][c] == lastPiece) consecutiveHorizontal++;
						else countHorizontal = false;
						if (countDiagonal && c >= minCols && r >= minRows && grid[r][c] == lastPiece) consecutiveDiagonal++;
						else countDiagonal = false;
					}
					countHorizontal = countVertical = countDiagonal = true;
					for (int c = col+1, r = row+1; c < col+4 || r < row+4; c++, r++) {
						if (countVertical && r < maxRows && grid[r][col] == lastPiece) consecutiveVertical++;
						else countVertical = false;
						if (countHorizontal && c < maxCols && grid[row][c] == lastPiece) consecutiveHorizontal++;
						else countHorizontal = false;
						if (countDiagonal && c < maxCols && r < maxRows && grid[r][c] == lastPiece) consecutiveDiagonal++;
						else countDiagonal = false;
					}
					if (consecutiveDiagonal >= 4 || consecutiveHorizontal >= 4 || consecutiveVertical >= 4) return true;
				}
			}
		}
		return false;	
	}

	@Override
	public boolean isGridFull() {
		for (int row = 0; row < grid.length; row++) {
			for(int col = 0; col < grid[0].length; col++) {
				if (grid[row][col] == EMPTY) return false;
			}
		}
		return true;
	}

	@Override
	public int getColumns() {
		return grid[0].length;
	}
}
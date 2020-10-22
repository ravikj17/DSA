package Graph;

/*
 * Given a N*N board with the Knight placed on the first block of an empty board. 
 * Moving according to the rules of chess knight must visit each square exactly once.
 * Print the order of each the cell in which they are visited.
 */

public class knight_Tour {

	static int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
	static int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

	public static void main(String[] args) {

		int[][] visited = new int[8][8];
		visited[0][0] = 1;
		System.out.println("Solution is:");
		knightTour(visited, 0, 0, 1);
	}

	static boolean knightTour(int[][] visited, int row, int col, int move) {
		if (move == 64) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					System.out.print(visited[i][j] + "	");
				}
				System.out.println();
			}
			return true;
		} else {
			for (int i = 0; i < 8; i++) {
				int newRow = row + xMove[i];
				int newCol = col + yMove[i];
				if (isValid(visited, newRow, newCol)) {
					move++;
					visited[newRow][newCol] = move;
					if (knightTour(visited, newRow, newCol, move)) {
						return true;
					}
					move--;
					visited[newRow][newCol] = 0;
				}
			}
		}
		return false;
	}

	static boolean isValid(int[][] visited, int row, int col) {
		if (row >= 0 && row < 8 && col >= 0 && col < 8 && visited[row][col] == 0)
			return true;
		return false;
	}

}

package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Given a N*N board with the Knight placed on the first block of an empty board. 
 * Moving according to the rules of chess knight must visit each square exactly once.
 * Print the order of each the cell in which they are visited.
 */

public class knight_Tour {

	static int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
	static int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter value of n"); // n<=8
		int n = Integer.parseInt(br.readLine());
		int[][] visited = new int[n][n];
		visited[0][0] = 1;
		System.out.println("Solution is:");
		knightTour(visited, 0, 0, 1, n);
	}

	static boolean knightTour(int[][] visited, int row, int col, int move, int n) {
		if (move == n * n) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(visited[i][j] + "	");
				}
				System.out.println();
			}
			return true;
		} else {
			for (int i = 0; i < 8; i++) {
				int newRow = row + xMove[i];
				int newCol = col + yMove[i];
				if (isValid(visited, newRow, newCol, n)) {
					move++;
					visited[newRow][newCol] = move;
					if (knightTour(visited, newRow, newCol, move, n)) {
						return true;
					}
					move--;
					visited[newRow][newCol] = 0;
				}
			}
		}
		return false;
	}

	static boolean isValid(int[][] visited, int row, int col, int n) {
		if (row >= 0 && row < n && col >= 0 && col < n && visited[row][col] == 0)
			return true;
		return false;
	}

}

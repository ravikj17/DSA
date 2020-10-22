package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Rat_in_a_Maze {

	static int[] xMove = { 1, -1, 0, 0 };
	static int[] yMove = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter value of n");
		int n = Integer.parseInt(br.readLine());
		int[][] maze = new int[n][n];
		System.out.println("Enter n*n maze");
		for (int i = 0; i < n; i++) {
			String st[] = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				maze[i][j] = Integer.parseInt(st[j]);
			}
		}
		int visited[][] = new int[n][n];
		visited[0][0] = 1;
		findPath(maze, 0, 0, visited, 1, n);
	}

	static void findPath(int[][] maze, int row, int col, int[][] visited, int move, int n) {
		if (row == n - 1 && col == n - 1) {
			for (int i = 0; i <= n - 1; i++) {
				for (int j = 0; j <= n - 1; j++) {
					System.out.print(visited[i][j] + "	");
				}
				System.out.println();
			}
			System.out.println("#############################################################");
		} else {
			for (int i = 0; i < 4; i++) {
				int newRow = row + xMove[i];
				int newCol = col + yMove[i];
				if (isValid(maze, newRow, newCol, visited, n)) {
					move++;
					visited[newRow][newCol] = move;
					findPath(maze, newRow, newCol, visited, move, n);
					move--;
					visited[newRow][newCol] = 0;
				}
			}
		}
	}

	static boolean isValid(int[][] maze, int row, int col, int[][] visited, int n) {
		if (row >= 0 && col >= 0 && row < n && col < n && maze[row][col] == 1 && visited[row][col] == 0)
			return true;
		return false;
	}

}

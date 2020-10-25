package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Leetcode 695. Max Area of Island
Medium

Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

Example 1:

[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
Example 2:

[[0,0,0,0,0,0,0,0]]
Given the above grid, return 0.
 */

public class Max_Area_of_Island {

	static int[] xMove = { 0, 0, 1, -1 };
	static int[] yMove = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter value of m");
		int m = Integer.parseInt(br.readLine());
		System.out.println("Enter value of m");
		int n = Integer.parseInt(br.readLine());
		int[][] grid = new int[n][n];
		System.out.println("Enter m*n matrix");
		for (int i = 0; i < m; i++) {
			String st[] = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				grid[i][j] = Integer.parseInt(st[j]);
			}
		}
		System.out.println("Max area of island is: " + maxAreaOfIsland(grid));

	}

	static int maxAreaOfIsland(int[][] grid) {
		int r = grid.length;
		int c = grid[0].length;
		boolean[][] visited = new boolean[r][c];
		int max = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (!visited[i][j] && grid[i][j] == 1) {
					max = Math.max(max, DFS(grid, visited, i, j));
				}
			}
		}
		return max;
	}

	static int DFS(int[][] grid, boolean[][] visited, int r, int c) {
		if (r >= grid.length && c >= grid[0].length)
			return 0;
		if (visited[r][c])
			return 0;
		visited[r][c] = true;
		int count = 1;
		for (int i = 0; i < 4; i++) {
			int newRow = r + xMove[i];
			int newCol = c + yMove[i];
			if (isValid(grid, newRow, newCol)) {
				count += DFS(grid, visited, newRow, newCol);
			}
		}
		return count;
	}

	static boolean isValid(int[][] grid, int r, int c) {
		if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == 1)
			return true;
		return false;
	}

}

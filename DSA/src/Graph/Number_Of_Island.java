package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Leetcode 200. Number of Islands
Medium
Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.
Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 */

public class Number_Of_Island {

	static int[] xMove = { 0, 0, 1, -1 };
	static int[] yMove = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter value of m");
		int m = Integer.parseInt(br.readLine());
		System.out.println("Enter value of m");
		int n = Integer.parseInt(br.readLine());
		char[][] grid = new char[n][n];
		System.out.println("Enter m*n matrix");
		for (int i = 0; i < m; i++) {
			String st[] = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				grid[i][j] = st[j].charAt(0);
			}
		}
		System.out.println("Number of island is: " + numIslands(grid));

	}

	static int numIslands(char[][] grid) {
		int H = grid.length;
		int W = grid[0].length;
		if (H == 0 || W == 0)
			return 0;
		boolean visited[][] = new boolean[H][W];
		int count = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if ((!visited[i][j]) && grid[i][j] == '1') {
					DFS(grid, visited, i, j);
					count++;
				}
			}
		}
		return count;
	}

	static void DFS(char[][] grid, boolean visited[][], int r, int c) {

		if (r >= grid.length && c >= grid[0].length)
			return;
		if (visited[r][c])
			return;
		visited[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int newRow = r + xMove[i];
			int newCol = c + yMove[i];
			if (isValid(grid, newRow, newCol)) {
				DFS(grid, visited, newRow, newCol);
			}
		}

	}

	static boolean isValid(char[][] grid, int r, int c) {
		if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == '1')
			return true;
		return false;
	}

}

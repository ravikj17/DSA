package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Leetcode 1039. Minimum Score Triangulation of Polygon
Medium

Given N, consider a convex N-sided polygon with vertices labelled A[0], A[i], ..., A[N-1] in clockwise order.

Suppose you triangulate the polygon into N-2 triangles.  For each triangle, the value of that triangle is the product of the labels of the vertices, and the total score of the triangulation is the sum of these values over all N-2 triangles in the triangulation.

Return the smallest possible total score that you can achieve with some triangulation of the polygon.
 */

public class Minimum_Score_Triangulation_of_Polygon {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter vertices");
		String st[] = br.readLine().split(" ");
		int n = st.length;
		int arr[] = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st[i]);
		int dp[][] = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++)
				dp[i][j] = -1;
		}
		System.out.println("Answer = " + minScoreTriangulation(arr));

	}

	public static int minScoreTriangulation(int[] arr) {
		int n = arr.length;
		int dp[][] = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++)
				dp[i][j] = -1;
		}
		return MCM(arr, 1, n - 1, dp);

	}

	static int MCM(int arr[], int i, int j, int[][] dp) {
		if (i >= j)
			return 0;
		if (dp[i][j] != -1)
			return dp[i][j];
		int min = Integer.MAX_VALUE;
		for (int k = i; k <= j - 1; k++) {
			int cost = MCM(arr, i, k, dp) + MCM(arr, k + 1, j, dp) + arr[i - 1] * arr[k] * arr[j];
			min = Math.min(min, cost);
		}
		return dp[i][j] = min;
	}

}

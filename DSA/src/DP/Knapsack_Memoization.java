package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Knapsack_Memoization {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter number of item");
		int n = Integer.parseInt(br.readLine());
		System.out.println("Enter weights of items");
		String st1[] = br.readLine().split(" ");
		System.out.println("Enter values of items");
		String st2[] = br.readLine().split(" ");
		int wt[] = new int[n];
		int val[] = new int[n];
		for (int i = 0; i < n; i++) {
			wt[i] = Integer.parseInt(st1[i]);
			val[i] = Integer.parseInt(st2[i]);
		}
		System.out.println("Enter capacity of Knapsack");
		int W = Integer.parseInt(br.readLine());
		int[][] dp = new int[n + 1][W + 1];
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < W + 1; j++) {
				dp[i][j] = -1;
			}
		}
		int profit = knapsack(wt, val, W, n, dp);
		System.out.println("Profit = " + profit);
	}

	static int knapsack(int[] wt, int[] val, int W, int n, int[][] dp) {
		if (n == 0 || W == 0)
			return 0;
		if (dp[n][W] != -1)
			return dp[n][W];
		else if (wt[n - 1] <= W)
			return dp[n][W] = Math.max(val[n - 1] + knapsack(wt, val, W - wt[n - 1], n - 1, dp),
					knapsack(wt, val, W, n - 1, dp));
		else
			return dp[n][W] = knapsack(wt, val, W, n - 1, dp);
	}

}

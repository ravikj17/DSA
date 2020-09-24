package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Knapsack_TopDown {
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
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= W; j++) {
				if (wt[i - 1] <= j) {
					dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
				} else
					dp[i][j] = dp[i - 1][j];
			}
		}
		System.out.println("Profit = " + dp[n][W]);
	}
}

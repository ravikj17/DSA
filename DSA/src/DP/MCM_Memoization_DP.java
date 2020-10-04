package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MCM_Memoization_DP {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter size of array dimension");
		int n = Integer.parseInt(br.readLine());
		System.out.println("Enter dimensions");
		String st[] = br.readLine().split(" ");
		int arr[] = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st[i]);
		int dp[][] = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++)
				dp[i][j] = -1;
		}
		System.out.println("Minimum cost = " + MCM(arr, 1, n - 1, dp));

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

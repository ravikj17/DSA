package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Coin_Change_No_Of_Ways {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter number of coins");
		int m = Integer.parseInt(br.readLine());
		System.out.println("Enter value of coins");
		String st2[] = br.readLine().split(" ");
		int c[] = new int[m];
		for (int i = 0; i < m; i++) {
			c[i] = Integer.parseInt(st2[i]);
		}
		System.out.println("Enter change");
		int n = Integer.parseInt(br.readLine());
		long dp[][] = new long[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			dp[i][0] = 1;
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (c[i - 1] <= j) {
					dp[i][j] = dp[i][j - (c[i - 1])] + dp[i - 1][j];
				} else
					dp[i][j] = dp[i - 1][j];
			}
		}
		System.out.println("Number of ways = " + dp[m][n]);
	}
}
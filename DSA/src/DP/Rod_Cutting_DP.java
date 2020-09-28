package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Rod_Cutting_DP {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter length of rod");
		int n = Integer.parseInt(br.readLine());
		System.out.println("Enter prices of lengths");
		String st2[] = br.readLine().split(" ");
		int len[] = new int[n];
		int val[] = new int[n];
		for (int i = 0; i < n; i++) {
			len[i] = i + 1;
			val[i] = Integer.parseInt(st2[i]);
		}
		int[][] dp = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (len[i - 1] <= j) {
					dp[i][j] = Math.max(val[i - 1] + dp[i][j - len[i - 1]], dp[i - 1][j]);
				} else
					dp[i][j] = dp[i - 1][j];
			}
		}
		System.out.println("Maximum Profit = " + dp[n][n]);
	}
}
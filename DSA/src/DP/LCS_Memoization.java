package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS_Memoization {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter first string");
		String s1 = br.readLine();
		System.out.println("Enter second string");
		String s2 = br.readLine();
		int n = s1.length();
		int m = s2.length();
		int dp[][] = new int[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				dp[i][j] = -1;
			}
		}
		int result = LCS(s1, s2, n, m, dp);
		System.out.println("Length of longest common subsequence = " + result);
	}

	static int LCS(String s1, String s2, int n, int m, int[][] dp) {
		if (n == 0 || m == 0)
			return 0;
		else if (dp[n][m] != -1)
			return dp[n][m];
		else if (s1.charAt(n - 1) == s2.charAt(m - 1))
			return dp[n][m] = 1 + LCS(s1, s2, n - 1, m - 1, dp);
		else
			return dp[n][m] = Math.max(LCS(s1, s2, n, m - 1, dp), LCS(s1, s2, n - 1, m, dp));
	}

}
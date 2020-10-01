package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Shortest_Common_Supersequence {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter first string");
		String s1 = br.readLine();
		System.out.println("Enter second string");
		String s2 = br.readLine();
		int n = s1.length();
		int m = s2.length();
		int dp[][] = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
			}
		}
		String lcs = "";
		int i = n;
		int j = m;
		while (i > 0 && j > 0) {
			if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
				lcs = s1.charAt(i - 1) + lcs;
				i--;
				j--;
			} else {
				if (dp[i - 1][j] < dp[i][j - 1]) {
					lcs = s2.charAt(j - 1) + lcs;
					j--;
				} else {
					lcs = s1.charAt(i - 1) + lcs;
					i--;
				}
			}
		}
		while (i > 0) {
			lcs = s1.charAt(i - 1) + lcs;
			i--;
		}
		while (j > 0) {
			lcs = s2.charAt(j - 1) + lcs;
			j--;
		}
		System.out.println("Length of longest common subsequence = " + dp[n][m]);
		System.out.println("LCS = " + lcs);
	}

}

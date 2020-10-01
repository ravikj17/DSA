package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Leetcode 516. Longest Palindromic Subsequence
Medium

Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

Example 1:
Input:

"bbbab"
Output:
4
One possible longest palindromic subsequence is "bbbb".
 */

public class Longest_Palindromic_Subsequence {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter first string");
		String s1 = br.readLine();
		int n = s1.length();
		String s2 = "";
		for (int i = n - 1; i >= 0; i--) {
			s2 = s2 + s1.charAt(i);
		}
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
					j--;
				} else {
					i--;
				}
			}
		}
		System.out.println("Length of longest palindromic subsequence = " + dp[n][m]);
		System.out.println("longest palindromic subsequence = " + lcs);
	}

}

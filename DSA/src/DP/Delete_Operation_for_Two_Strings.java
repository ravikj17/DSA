package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
  Leetcode 583. Delete Operation for Two Strings
Medium
Given two words word1 and word2, find the minimum number of steps required 
to make word1 and word2 the same, where in each step you can delete one character in either string.

Example 1:
Input: "sea", "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 */

public class Delete_Operation_for_Two_Strings {

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

		System.out.println("Number of operations = " + ((n + m) - (2 * dp[n][m])));
	}

}

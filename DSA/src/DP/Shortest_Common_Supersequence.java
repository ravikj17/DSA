package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Leetcode 1092. Shortest Common Supersequence
Hard

Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences.  If multiple answers exist, you may return any of them.

(A string S is a subsequence of string T if deleting some number of characters from T (possibly 0, and the characters are chosen anywhere from T) results in the string S.)

 

Example 1:

Input: str1 = "abac", str2 = "cab"
Output: "cabac"
Explanation: 
str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
The answer provided is the shortest such string that satisfies these properties.

 */

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
		System.out.println("Length of Shortest_Common_Supersequence = " + (n + m - dp[n][m]));
		System.out.println("Shortest_Common_Supersequence = " + lcs);
	}

}

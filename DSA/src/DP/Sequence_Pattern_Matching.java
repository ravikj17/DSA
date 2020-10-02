package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Leetcode 392. Is Subsequence
Easy

Given a string s and a string t, check if s is subsequence of t.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

Follow up:
If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?

Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false
 */

public class Sequence_Pattern_Matching {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter first string");
		String s = br.readLine();
		System.out.println("Enter second string");
		String t = br.readLine();
		System.out.println("Result = " + isSubsequence(s, t));
	}

	public static boolean isSubsequence(String s1, String s2) {
		if (s1.length() > s2.length())
			return false;
		if (s1.length() == 0)
			return true;
		int n = s1.length();
		int m = s2.length();
		int max = 0;
		int dp[][] = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				max = Math.max(max, dp[i][j]);
			}
		}
		if (dp[n][m] == n)
			return true;
		return false;
	}

}

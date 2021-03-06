package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Leetcode 1312. Minimum Insertion Steps to Make a String Palindrome
Hard
Given a string s. In one step you can insert any character at any index of the string.

Return the minimum number of steps to make s palindrome.

A Palindrome String is one that reads the same backward as well as forward.

 

Example 1:

Input: s = "zzazz"
Output: 0
Explanation: The string "zzazz" is already palindrome we don't need any insertions.
Example 2:

Input: s = "mbadm"
Output: 2
Explanation: String can be "mbdadbm" or "mdbabdm".
 */

public class Minimum_Insertion_Steps_to_Make_a_String_Palindrome {

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter string");
		String S = br.readLine();
		System.out.println("Minimum_Insertion_Steps_to_Make_a_String_Palindrome = " + minInsertions(S));

	}

	public static int minInsertions(String s1) {
		int n = s1.length();
		String s2 = "";
		for (int i = n - 1; i >= 0; i--) {
			s2 = s2 + s1.charAt(i);
		}
		int dp[][] = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
			}
		}
		return n - dp[n][n];
	}
}

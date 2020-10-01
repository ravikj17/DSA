package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Leetcode 718. Maximum Length of Repeated Subarray
Medium
Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.

Example 1:

Input:
A: [1,2,3,2,1]
B: [3,2,1,4,7]
Output: 3
Explanation: 
The repeated subarray with maximum length is [3, 2, 1].
 */

public class Maximum_Length_of_Repeated_Subarray_DP {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter size of first array");
		int n = Integer.parseInt(br.readLine());
		System.out.println("Enter size of second array");
		int m = Integer.parseInt(br.readLine());
		System.out.println("Enter elements of first array");
		String s1[] = br.readLine().split(" ");
		System.out.println("Enter elements of s4econd array");
		String s2[] = br.readLine().split(" ");
		int[] A = new int[n];
		int[] B = new int[m];
		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(s1[i]);
		}
		for (int i = 0; i < m; i++) {
			B[i] = Integer.parseInt(s2[i]);
		}
		int max = 0;
		int dp[][] = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (A[i - 1] == B[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else
					dp[i][j] = 0;
				max = Math.max(max, dp[i][j]);
			}
		}
		System.out.println("Maximum Length of Repeated Subarray = " + max);
	}

}

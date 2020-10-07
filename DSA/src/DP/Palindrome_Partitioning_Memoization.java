package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome_Partitioning_Memoization {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter string");
		String s = br.readLine();
		int l = 0;
		int r = s.length() - 1;
		int dp[][] = new int[s.length() + 1][s.length() + 1];
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < s.length(); j++)
				if (i != j)
					dp[i][j] = -1;
		}
		System.out.println("Number of partiotions = " + partition(s, l, r, dp));
	}

	static int partition(String s, int i, int j, int dp[][]) {
		if (i == j)
			return 0;
		if (dp[i][j] != -1)
			return dp[i][j];
		if (isPalindrome(s, i, j))
			return dp[i][j] = 0;
		int ans = Integer.MAX_VALUE;
		for (int k = i; k <= j - 1; k++) {
			int left = 0;
			if (dp[i][k] != -1)
				left = dp[i][k];
			else
				left = partition(s, i, k, dp);
			int right = 0;
			if (dp[k + 1][j] != -1)
				right = dp[k + 1][j];
			else
				right = partition(s, k + 1, j, dp);
			int temp = left + right + 1;
			ans = Math.min(ans, temp);
		}
		return dp[i][j] = ans;
	}

	static boolean isPalindrome(String s, int i, int j) {
		while (i <= j) {
			if (s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

}

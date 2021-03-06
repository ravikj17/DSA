package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Equal_Sum_Partition_DP {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter size of array");
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		System.out.println("Enter elements in array");
		String st[] = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st[i]);
		}
		long s = 0;
		for (int i : arr) {
			s += i;
		}
		int sum = (int) (s / 2);
		if (s % 2 != 0)
			System.out.println("Result = " + false);
		else {
			boolean[][] dp = new boolean[n + 1][sum + 1];
			for (int i = 0; i <= n; i++) {
				dp[i][0] = true;
			}
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= sum; j++) {
					if (arr[i - 1] <= j)
						dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
					else
						dp[i][j] = dp[i - 1][j];
				}
			}
			System.out.println("Result = " + dp[n][sum]);
		}

	}

}

package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Coin_Change_Min_No_Coins {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter number of coins");
		int n = Integer.parseInt(br.readLine());
		System.out.println("Enter value of coins");
		String st2[] = br.readLine().split(" ");
		int coins[] = new int[n];
		for (int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(st2[i]);
		}
		System.out.println("Enter amount");
		int amount = Integer.parseInt(br.readLine());
		int dp[][] = new int[n + 1][amount + 1];
		int min = Integer.MAX_VALUE - 1;
		for (int i = 0; i <= amount; i++) {
			dp[0][i] = min;
		}
		for (int i = 1; i <= amount; i++) {
			if (i % coins[0] == 0) {
				dp[1][i] = i / coins[0];
			} else {
				dp[1][i] = min;
			}
		}
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= amount; j++) {
				if (coins[i - 1] <= j) {
					dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
				} else
					dp[i][j] = dp[i - 1][j];
			}
		}
		if (dp[n][amount] == min)
			System.out.println("Not Possible");
		else
			System.out.println("Minimum Number of Coins = " + dp[n][amount]);
	}
}
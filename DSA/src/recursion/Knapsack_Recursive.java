package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Knapsack_Recursive {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter number of item");
		int n = Integer.parseInt(br.readLine());
		System.out.println("Enter weights of items");
		String st1[] = br.readLine().split(" ");
		System.out.println("Enter values of items");
		String st2[] = br.readLine().split(" ");
		int wt[] = new int[n];
		int val[] = new int[n];
		for (int i = 0; i < n; i++) {
			wt[i] = Integer.parseInt(st1[i]);
			val[i] = Integer.parseInt(st2[i]);
		}
		System.out.println("Enter capacity of Knapsack");
		int W = Integer.parseInt(br.readLine());
		int profit = knapsack(wt, val, W, n);
		System.out.println("Profit = " + profit);
	}

	static int knapsack(int[] wt, int[] val, int W, int n) {
		if (n == 0 || W == 0)
			return 0;
		if (wt[n - 1] <= W)
			return Math.max(val[n - 1] + knapsack(wt, val, W - wt[n - 1], n - 1), knapsack(wt, val, W, n - 1));
		else
			return knapsack(wt, val, W, n - 1);
	}

}

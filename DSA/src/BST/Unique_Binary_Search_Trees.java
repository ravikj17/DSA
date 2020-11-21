package BST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Unique_Binary_Search_Trees {

	static private int catalan_Number(int n) {
		int dp[] = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			int result = 0;
			for (int j = 0; j < i; j++) {
				result += dp[j] * dp[i - j - 1];
			}
			dp[i] = result;
		}
		return dp[n];
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter number of nodes");
		int n = Integer.parseInt(br.readLine());
		System.out.println("answer = " + catalan_Number(n));
	}

}

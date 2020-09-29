package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS_Recursive {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter first string");
		String s1 = br.readLine();
		System.out.println("Enter second string");
		String s2 = br.readLine();
		int n = s1.length();
		int m = s2.length();
		int result = LCS(s1, s2, n, m);
		System.out.println("Length of longest common subsequence = " + result);
	}

	static int LCS(String s1, String s2, int n, int m) {
		if (n == 0 || m == 0)
			return 0;
		else if (s1.charAt(n - 1) == s2.charAt(m - 1))
			return 1 + LCS(s1, s2, n - 1, m - 1);
		else
			return Math.max(LCS(s1, s2, n, m - 1), LCS(s1, s2, n - 1, m));
	}

}

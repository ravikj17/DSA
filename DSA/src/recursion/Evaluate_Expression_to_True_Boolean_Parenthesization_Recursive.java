package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Evaluate_Expression_to_True_Boolean_Parenthesization_Recursive {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter string");
		String s = br.readLine();
		int ways = solve(s, 0, s.length() - 1, true);
		System.out.println(ways);

	}

	private static int solve(String str, int i, int j, boolean isTrue) {
		if (i > j) {
			return 0;
		}

		if (i == j) {
			if (isTrue == true) {
				if (str.charAt(i) == 'T')
					return 1;
				else
					return 0;
			} else {
				if (str.charAt(i) == 'F')
					return 1;
				else
					return 0;
			}
		}
		int ans = 0, lf, lt, rf, rt;

		for (int k = i + 1; k <= j - 1; k = k + 2) {

			lt = solve(str, i, k - 1, true);
			lf = solve(str, i, k - 1, false);
			rt = solve(str, k + 1, j, true);
			rf = solve(str, k + 1, j, false);

			if (str.charAt(k) == '&') {
				if (isTrue == true) {
					ans = ans + lt * rt;
				} else {
					ans = ans + (lt * rf) + (lf * rt) + (lf * rf);
				}
			}

			else if (str.charAt(k) == '|') {
				if (isTrue == true) {
					ans = ans + (lt * rt) + (lf * rt) + (lt * rf);
				} else {
					ans = ans + (lf * rf);
				}
			}

			else if (str.charAt(k) == '^') {
				if (isTrue == true) {
					ans = ans + (lt * rf) + (lf * rt);
				} else {
					ans = ans + (lf * rf) + (lt * rt);
				}
			}
		}

		return ans;
	}

}

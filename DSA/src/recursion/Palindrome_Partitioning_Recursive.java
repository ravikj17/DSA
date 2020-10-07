package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome_Partitioning_Recursive {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter string");
		String s = br.readLine();
		int i = 0;
		int j = s.length() - 1;
		System.out.println("Number of partiotions = " + partition(s, i, j));
	}

	static int partition(String s, int i, int j) {
		if (i >= j)
			return 0;
		if (isPalindrome(s, i, j))
			return 0;
		int ans = Integer.MAX_VALUE;
		for (int k = i; k <= j - 1; k++) {
			int temp = partition(s, i, k) + partition(s, k + 1, j) + 1;
			ans = Math.min(ans, temp);
		}
		return ans;
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

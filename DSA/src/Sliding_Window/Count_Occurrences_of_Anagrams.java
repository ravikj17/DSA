package Sliding_Window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Count_Occurrences_of_Anagrams {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter String");
		String s = br.readLine();
		System.out.println("Enter pattern");
		String ptr = br.readLine();
		System.out.println("Result = " + helper(s, ptr));

	}

	static int helper(String s, String ptr) {
		int arr1[] = new int[26];
		for (int i = 0; i < ptr.length(); i++) {
			arr1[ptr.charAt(i) - 'a']++;
		}
		int n = s.length();
		int k = ptr.length();
		int count = 0;
		int i = 0, j = 0;
		int arr2[] = new int[26];
		while (j < n) {
			if (j - i + 1 < k) {
				arr2[s.charAt(j) - 'a']++;
				j++;
			} else if (j - i + 1 == k) {
				arr2[s.charAt(j) - 'a']++;
				if (Arrays.equals(arr1, arr2)) {
					count++;
				}
				j++;
				arr2[s.charAt(i) - 'a']--;
				i++;
			}
		}
		return count;
	}

}

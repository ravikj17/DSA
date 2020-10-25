package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Permutaion_Of_Words {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter word");
		String s = br.readLine();
		char[] re = new char[s.length()];
		int count[] = new int[26];
		int level = 0;
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - 'a']++;
		}
		permute(s, re, count, level);
	}

	static void permute(String s, char[] re, int[] count, int level) {

		if (level == s.length()) {
			System.out.println(re);
			return;
		}
		for (int i = 0; i < s.length(); i++) {
			if (count[s.charAt(i) - 'a'] != 0) {
				re[level] = s.charAt(i);
				count[s.charAt(i) - 'a']--;
				permute(s, re, count, level + 1);
				count[s.charAt(i) - 'a']++;
			}
		}

	}

}

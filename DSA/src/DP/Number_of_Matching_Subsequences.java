package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/*
 * Lettcode 792. Number of Matching Subsequences
Medium

Given string S and a dictionary of words words, find the number of words[i] that is a subsequence of S.

Example :
Input: 
S = "abcde"
words = ["a", "bb", "acd", "ace"]
Output: 3
Explanation: There are three words in words that are a subsequence of S: "a", "acd", "ace".
 */

public class Number_of_Matching_Subsequences {

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter first string");
		String S = br.readLine();
		System.out.println("Enter dictionary");
		String words[] = br.readLine().split(" ");
		System.out.println("Number_of_Matching_Subsequences = " + numMatchingSubseq(S, words));

	}

	public static int numMatchingSubseq(String S, String[] words) {
		int res = 0;
		Set<String> set = new HashSet<>();
		Set<String> set2 = new HashSet<>();
		for (int i = 0; i < words.length; i++) {
			if (set.contains(words[i]))
				res++;
			else if (set2.contains(words[i]))
				continue;
			else {
				if (isSubsequence(words[i], S)) {
					set.add(words[i]);
					res++;
				} else
					set2.add(words[i]);
			}
		}
		return res;
	}

	public static boolean isSubsequence(String s, String t) {
		if (s.length() > t.length())
			return false;
		if (s.length() == 0)
			return true;
		int l = 0;
		for (int i = 0; i < t.length(); i++) {
			if (s.charAt(l) == t.charAt(i)) {
				l++;
			}
			if (l == s.length()) {
				break;
			}
		}
		if (l == s.length()) {
			return true;
		}
		return false;
	}

}

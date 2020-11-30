package Sliding_Window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class First_negative_integer_in_every_window_of_size_k {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter elements of array");
		String st[] = br.readLine().split(" ");
		System.out.println("Enter value of k");
		int k = Integer.parseInt(br.readLine());
		int Arr[] = new int[st.length];
		for (int i = 0; i < st.length; i++) {
			Arr[i] = Integer.parseInt(st[i]);
		}
		System.out.println("First negative number = " + helper(k, Arr, Arr.length));

	}

	static ArrayList<Integer> helper(int k, int[] arr, int n) {
		Queue<Integer> q = new LinkedList<>();
		ArrayList<Integer> result = new ArrayList<>();
		// 12 -1 -7 8 -15 30 16 28
		int i = 0, j = 0;
		while (j < n) {
			if (j - i + 1 < k) {
				if (arr[j] < 0)
					q.add(arr[j]);
				j++;
			} else if (j - i + 1 == k) {
				if (arr[j] < 0)
					q.add(arr[j]);
				if (q.size() == 0) {
					result.add(0);
				} else {
					result.add(q.peek());
				}
				j++;
				if (arr[i] < 0)
					q.remove();
				i++;
				;
			}
		}
		return result;
	}

}

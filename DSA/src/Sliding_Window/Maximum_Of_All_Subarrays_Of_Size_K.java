package Sliding_Window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Maximum_Of_All_Subarrays_Of_Size_K {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Array");
		String st[] = br.readLine().split(" ");
		System.out.println("Enter value of k");
		int k = Integer.parseInt(br.readLine());
		int n = st.length;
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st[i]);
		}
		helper(arr, n, k);

	}

	static void helper(int[] arr, int n, int k) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		LinkedList<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (!q.isEmpty() && q.peek() < i - k + 1) {
				q.poll();
			}
			while (!q.isEmpty() && arr[i] > arr[q.peekLast()]) {
				q.pollLast();
			}
			q.offer(i);
			if (i >= k - 1)
				result.add(arr[q.peek()]);

		}
		System.out.println(result);
	}

}

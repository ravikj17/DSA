package Sliding_Window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Max_Sum_Subarray_of_size_K {

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
		System.out.println("Maximum sum = " + maximumSumSubarray(k, Arr, Arr.length));

	}

	static int maximumSumSubarray(int K, int[] Arr, int N) {
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < K; i++) {
			sum += Arr[i];
		}
		max = sum;
		for (int i = K; i < N; i++) {
			sum = sum + Arr[i] - Arr[i - K];
			max = Math.max(sum, max);
		}
		return max;
	}

}

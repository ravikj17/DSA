package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Given an unsorted array A of size N of non-negative integers, 
 * find a continuous sub-array which adds to a given number S.
 */

public class Subarray_with_given_sum {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter size of array");
		int n = Integer.parseInt(br.readLine());
		System.out.println("Enter elements");
		String st[] = br.readLine().split(" ");
		System.out.println("Enter sum");
		int sum = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st[i]);
		}
		int curr_sum = 0;
		int start = 0, end = -1;
		for (int i = 0; i < n; i++) {
			curr_sum += arr[i];
			while (curr_sum > sum && start <= i) {
				curr_sum -= arr[start];
				start++;
			}
			if (curr_sum == sum) {
				end = i;
				break;
			}
		}
		if (end == -1)
			System.out.println("Not Possible");
		else
			System.out.println("Starting Index: " + (start + 1) + "\nEnding index: " + (end + 1));

	}

}

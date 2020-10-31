package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Given an array of distinct integers. The task is to count all the triplets such that sum of two elements equals the third element.
 */

public class Count_the_triplets {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter size of array");
		int n = Integer.parseInt(br.readLine());
		System.out.println("Enter elements");
		String st[] = br.readLine().split(" ");
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st[i]);
		}
		System.out.println("Number of triplets: " + countTriplet(arr, n));

	}

	static int countTriplet(int arr[], int n) {
		// code here
		int count = 0, max = 0;
		for (int num : arr) {
			max = Math.max(max, num);
		}
		int[] freq = new int[max + 1];
		for (int num : arr) {
			freq[num]++;
		}
		// case 1:(0,0,0)
		if (freq[0] >= 3) {
			count += (freq[0] * (freq[0] - 1) * (freq[0] - 2)) / 6;
		}
		// case 2:(0,x,x)
		if (freq[0] > 0) {
			for (int i = 1; i <= max; i++) {
				if (freq[i] > 1)
					count += (freq[0] * freq[i] * (freq[i] - 1)) / 2;
			}
		}
		// case 3:(x.x.2*x)
		for (int i = 1; 2 * i <= max; i++) {
			count += freq[2 * i] * freq[i] * (freq[i] - 1) / 2;
		}
		// case 4:(x,y,x+y)
		for (int i = 1; i < max; i++) {
			for (int j = i + 1; i + j <= max; j++) {
				count += freq[i] * freq[j] * freq[i + j];
			}
		}
		return count;
	}

}

package Arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 
Given an array arr of N integers. Find the contiguous sub-array with maximum sum.
 */

public class Kadane_Algorithm {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter size of array");
		int n = Integer.parseInt(br.readLine());
		System.out.println("Enter elements");
		String st[] = br.readLine().split(" ");
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st[i]);
		}
		int meh = 0;
		int msf = Integer.MIN_VALUE;
		for (int num : arr) {
			meh = Math.max(num, num + meh);
			msf = Math.max(meh, msf);
		}
		System.out.println("sub-array with maximum sum:" + msf);

	}

}

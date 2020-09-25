package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Equal_sum_partiton_Recursive {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter size of array");
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		System.out.println("Enter elements in array");
		String st[] = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st[i]);
		}
		long s = 0;
		for (int i : arr) {
			s += i;
		}
		int sum = (int) (s / 2);
		boolean result = false;
		if (s % 2 != 0)
			result = false;
		else
			result = checkSum(arr, n, sum);
		System.out.println("Result = " + result);

	}

	static boolean checkSum(int[] arr, int n, int sum) {
		if (sum == 0)
			return true;
		else if (n == 0)
			return false;
		else if (arr[n - 1] <= sum)
			return checkSum(arr, n - 1, sum - arr[n - 1]) || checkSum(arr, n - 1, sum);
		else
			return checkSum(arr, n - 1, sum);

	}

}
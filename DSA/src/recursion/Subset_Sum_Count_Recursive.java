package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Subset_Sum_Count_Recursive {

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
		System.out.println("Enter sum");
		int sum = Integer.parseInt(br.readLine());
		int result = checkSum(arr, n, sum);
		System.out.println("Result = " + result);

	}

	static int checkSum(int[] arr, int n, int sum) {
		if (sum == 0)
			return 1;
		else if (n == 0)
			return 0;
		else if (arr[n - 1] <= sum)
			return checkSum(arr, n - 1, sum - arr[n - 1]) + checkSum(arr, n - 1, sum);
		else
			return checkSum(arr, n - 1, sum);

	}

}

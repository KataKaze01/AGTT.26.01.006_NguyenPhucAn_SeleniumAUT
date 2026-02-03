package ArrayList;

import java.util.Scanner;

public class missingNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter n: ");
		int n = sc.nextInt();

		int[] arr = new int[n - 1];

		System.out.println("Enter array elements:");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		int sumExpected = n * (n + 1) / 2;
		int sumArray = 0;

		for (int num : arr) {
			sumArray += num;
	}

		System.out.println("Missing number is: " + (sumExpected - sumArray));
	}
}
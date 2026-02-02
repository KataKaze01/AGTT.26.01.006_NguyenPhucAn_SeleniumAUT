package ErrorHandling;

import java.util.Scanner;

public class sumOfTwoPrimes {
	static boolean isPrime(int n) {
		if (n < 2) return false;   // 0,1 không phải số nguyên tố
		if (n == 2) return true;   // 2 là số nguyên tố duy nhất chẵn

		if (n % 2 == 0) return false; // loại tất cả số chẵn > 2 (4,6,8...)

		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	static boolean findSumOfTwoPrimes(int n) {
		for (int i = 2; i <= n / 2; i++) {
			if (isPrime(i) && isPrime(n - i)) {
				System.out.println(n + " = " + i + " + " + (n - i));
				return true;
			}
		}
		System.out.println(n + " cannot be expressed as sum of two prime numbers");
		return false;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Input N: ");
		int n = scanner.nextInt();

		findSumOfTwoPrimes(n);
	}
}

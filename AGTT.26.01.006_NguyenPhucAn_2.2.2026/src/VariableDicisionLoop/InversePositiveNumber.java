package VariableDicisionLoop;

import java.util.Scanner;

public class InversePositiveNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the negative number N: ");
        int n = sc.nextInt();

        n = Math.abs(n);

        int result = 0;

        while (n > 0) {
            int digit = n % 10;
            result = result * 10 + digit;
            n /= 10;
        }

        System.out.println("Result: " + result);
    }
}
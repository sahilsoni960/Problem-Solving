// Problem: Find the Factorial of a Number
// Difficulty: Easy
// Description: Write a program to find the factorial of a given non-negative integer n.
// The factorial of n (denoted as n!) is the product of all positive integers less than or equal to n.
// Example: 5! = 5 * 4 * 3 * 2 * 1 = 120

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");
        int n = scanner.nextInt();
        if (n < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
        } else {
            System.out.println("Factorial of " + n + " is: " + factorial(n));
        }
        scanner.close();
    }

    public static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
} 
// Problem: Print Fibonacci Series up to N terms
// Difficulty: Easy
// Description: Write a program to print the Fibonacci series up to n terms.
// The Fibonacci series is a sequence where each number is the sum of the two preceding ones, starting from 0 and 1.
// Example: For n = 5, output should be: 0 1 1 2 3

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of terms: ");
        int n = scanner.nextInt();
        if (n <= 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            System.out.print("Fibonacci Series up to " + n + " terms: ");
            printFibonacci(n);
        }
        scanner.close();
    }

    public static void printFibonacci(int n) {
        int a = 0, b = 1;
        for (int i = 1; i <= n; i++) {
            System.out.print(a + (i < n ? " " : "\n"));
            int next = a + b;
            a = b;
            b = next;
        }
    }
} 
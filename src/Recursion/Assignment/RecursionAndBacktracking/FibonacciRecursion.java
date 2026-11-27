package src.Recursion.Assignment.RecursionAndBacktracking;

import java.util.Scanner;

public class FibonacciRecursion {
    // Direct recursive version, as shown in the lecture notes.
    public static long fibonacci(int n) {
        if (n < 0 || n > 45) {
            throw new IllegalArgumentException("Enter n from 0 to 45.");
        }
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n (0-45): ");
        int n = sc.nextInt();
        try {
            System.out.println("Fibonacci number = " + fibonacci(n));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

package src.Recursion.Assignment.RecursionAndBacktracking;

import java.util.Scanner;

public class FactorialRecursion {
    public static long factorial(int n) {
        if (n < 0 || n > 20) {
            throw new IllegalArgumentException("Enter a number from 0 to 20.");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number (0-20): ");
        int n = sc.nextInt();
        try {
            System.out.println("Factorial = " + factorial(n));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

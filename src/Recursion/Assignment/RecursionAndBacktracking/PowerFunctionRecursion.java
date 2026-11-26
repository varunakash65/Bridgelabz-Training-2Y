package src.Recursion.Assignment.RecursionAndBacktracking;

import java.util.Scanner;

public class PowerFunctionRecursion {
    // Divide-and-conquer power function: O(log n) recursive calls.
    public static double power(double x, int n) {
        long exponent = Math.abs((long) n);
        double result = powerPositive(x, exponent);
        return n < 0 ? 1.0 / result : result;
    }

    private static double powerPositive(double x, long n) {
        if (n == 0) {
            return 1;
        }
        double half = powerPositive(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        }
        return x * half * half;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter base: ");
        double x = sc.nextDouble();
        System.out.print("Enter integer exponent: ");
        int n = sc.nextInt();
        if (x == 0 && n < 0) {
            System.out.println("Zero cannot have a negative exponent.");
        } else {
            System.out.println("Result = " + power(x, n));
        }
    }
}

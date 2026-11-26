package src.Arrays.Assignment.Level_1;

import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        if (number < 0) {
            System.err.println("Invalid Number.");
            System.exit(0);
        }

        int count = 0;
        int temp = number;

        if (temp == 0) {
            count = 1;
        } else {
            while (temp > 0) {
                count++;
                temp /= 10;
            }
        }

        int[] digits = new int[count];

        if (number == 0) {
            digits[0] = 0;
        } else {
            for (int i = 0; i < digits.length; i++) {
                digits[i] = number % 10;
                number /= 10;
            }
        }

        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            sum += digits[i];
        }

        System.out.println("Sum of Digits: " + sum);
        input.close();
    }
}

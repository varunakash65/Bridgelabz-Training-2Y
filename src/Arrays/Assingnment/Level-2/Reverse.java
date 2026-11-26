package src.Arrays.Assignment.Level_2;

import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        if (number < 0) {
            System.out.println("Invalid number.");
            sc.close();
            return;
        }

        int temp = number;
        int count = 0;

        if (temp == 0) {
            count = 1;
        }

        while (temp > 0) {
            count++;
            temp /= 10;
        }

        int[] digits = new int[count];
        temp = number;

        for (int i = 0; i < digits.length; i++) {
            digits[i] = temp % 10;
            temp /= 10;
        }

        int[] reverse = new int[count];

        for (int i = 0; i < digits.length; i++) {
            reverse[i] = digits[digits.length - 1 - i];
        }

        System.out.print("Reversed number: ");
        for (int i = 0; i < reverse.length; i++) {
            System.out.print(reverse[i]);
        }
        System.out.println();

        sc.close();
    }
}

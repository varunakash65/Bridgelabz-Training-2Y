package src.Arrays.Assignment.Level_2;

import java.util.Scanner;

public class Frequency {
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

        int[] frequency = new int[10];

        for (int i = 0; i < digits.length; i++) {
            frequency[digits[i]]++;
        }

        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > 0) {
                System.out.println(i + " occurs " + frequency[i] + " times");
            }
        }

        sc.close();
    }
}

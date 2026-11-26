package src.Arrays.Assignment.Level_2;

import java.util.Scanner;
import java.util.Arrays;

public class LargestSecondAll {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        if (number < 0) {
            System.out.println("Invalid number.");
            sc.close();
            return;
        }

        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;

        while (number > 0) {
            if (index == maxDigit) {
                maxDigit += 10;
                digits = Arrays.copyOf(digits, maxDigit);
            }

            digits[index] = number % 10;
            number /= 10;
            index++;
        }

        int largest = -1;
        int second = -1;

        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                second = largest;
                largest = digits[i];
            } else if (digits[i] > second && digits[i] != largest) {
                second = digits[i];
            }
        }

        if (second == -1) {
            System.out.println("Second largest distinct digit does not exist.");
        } else {
            System.out.println("Largest digit: " + largest);
            System.out.println("Second largest digit: " + second);
        }

        sc.close();
    }
}

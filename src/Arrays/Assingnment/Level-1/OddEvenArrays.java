package src.Arrays.Assignment.Level_1;

import java.util.Arrays;
import java.util.Scanner;

public class OddEvenArrays {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int number = input.nextInt();

        if (number <= 0) {
            System.out.println("Invalid Number.");
            input.close();
            return;
        }

        int[] odd = new int[number / 2 + 1];
        int[] even = new int[number / 2 + 1];

        int oddIndex = 0;
        int evenIndex = 0;

        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                even[evenIndex++] = i;
            } else {
                odd[oddIndex++] = i;
            }
        }

        System.out.println("Odd numbers: " + Arrays.toString(Arrays.copyOf(odd, oddIndex)));
        System.out.println("Even numbers: " + Arrays.toString(Arrays.copyOf(even, evenIndex)));

        input.close();
    }
}

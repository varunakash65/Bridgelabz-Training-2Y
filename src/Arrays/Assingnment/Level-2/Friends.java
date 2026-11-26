package src.Arrays.Assignment.Level_2;

import java.util.Scanner;

public class Friends {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] age = new int[3];
        double[] height = new double[3];

        for (int i = 0; i < names.length; i++) {
            System.out.print("Enter age of " + names[i] + ": ");
            age[i] = sc.nextInt();

            System.out.print("Enter height of " + names[i] + ": ");
            height[i] = sc.nextDouble();

            if (age[i] <= 0 || height[i] <= 0) {
                System.out.println("Enter positive values.");
                i--;
            }
        }

        int youngest = 0;
        int tallest = 0;

        for (int i = 1; i < names.length; i++) {
            if (age[i] < age[youngest]) {
                youngest = i;
            }

            if (height[i] > height[tallest]) {
                tallest = i;
            }
        }

        System.out.println("Youngest: " + names[youngest]);
        System.out.println("Tallest: " + names[tallest]);

        sc.close();
    }
}

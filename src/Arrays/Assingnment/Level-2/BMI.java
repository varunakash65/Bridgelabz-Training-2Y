package src.Arrays.Assignment.Level_2;

import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Invalid number of persons.");
            sc.close();
            return;
        }

        double[] weight = new double[n];
        double[] height = new double[n];
        double[] bmi = new double[n];
        String[] status = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight in kg: ");
            weight[i] = sc.nextDouble();

            System.out.print("Enter height in metres: ");
            height[i] = sc.nextDouble();

            if (weight[i] <= 0 || height[i] <= 0) {
                System.out.println("Enter positive values again.");
                i--;
            }
        }

        for (int i = 0; i < n; i++) {
            bmi[i] = weight[i] / (height[i] * height[i]);

            if (bmi[i] < 18.5) {
                status[i] = "Underweight";
            } else if (bmi[i] < 25) {
                status[i] = "Normal";
            } else if (bmi[i] < 30) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Height: " + height[i]);
            System.out.println("Weight: " + weight[i]);
            System.out.println("BMI: " + bmi[i]);
            System.out.println("Status: " + status[i]);
        }

        sc.close();
    }
}

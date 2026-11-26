package src.Arrays.Assignment.Level_2;

import java.util.Scanner;

public class BMIMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Invalid number of persons.");
            sc.close();
            return;
        }

        double[][] personData = new double[n][3];
        String[] status = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight in kg: ");
            personData[i][0] = sc.nextDouble();

            System.out.print("Enter height in metres: ");
            personData[i][1] = sc.nextDouble();

            if (personData[i][0] <= 0 || personData[i][1] <= 0) {
                System.out.println("Enter positive values again.");
                i--;
            }
        }

        for (int i = 0; i < n; i++) {
            personData[i][2] = personData[i][0] /
                    (personData[i][1] * personData[i][1]);

            double bmi = personData[i][2];

            if (bmi < 18.5) {
                status[i] = "Underweight";
            } else if (bmi < 25) {
                status[i] = "Normal";
            } else if (bmi < 30) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Weight: " + personData[i][0]);
            System.out.println("Height: " + personData[i][1]);
            System.out.println("BMI: " + personData[i][2]);
            System.out.println("Status: " + status[i]);
        }

        sc.close();
    }
}

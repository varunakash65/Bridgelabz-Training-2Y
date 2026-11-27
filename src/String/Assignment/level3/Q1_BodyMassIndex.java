package src.String.Assignment.level3;

import java.util.Scanner;

public class Q1_BodyMassIndex {
    public static String[] calculateBMI(double weightKg, double heightCm) {
        double heightM = heightCm / 100.0;
        double bmi = weightKg / (heightM * heightM);
        // Standard BMI ranges are used because the PDF does not specify status ranges.
        String status;
        if (bmi < 18.5) status = "Underweight";
        else if (bmi < 25.0) status = "Normal";
        else if (bmi < 30.0) status = "Overweight";
        else status = "Obese";
        return new String[] {String.format("%.2f", bmi), status};
    }

    public static String[][] processPeople(double[][] people) {
        String[][] result = new String[people.length][4];
        for (int i = 0; i < people.length; i++) {
            String[] bmiInfo = calculateBMI(people[i][0], people[i][1]);
            result[i][0] = String.format("%.2f", people[i][1]);
            result[i][1] = String.format("%.2f", people[i][0]);
            result[i][2] = bmiInfo[0];
            result[i][3] = bmiInfo[1];
        }
        return result;
    }

    public static void displayTable(String[][] data) {
        System.out.printf("%-10s %-12s %-10s %s%n", "Height(cm)", "Weight(kg)", "BMI", "Status");
        for (String[] row : data)
            System.out.printf("%-10s %-12s %-10s %s%n", row[0], row[1], row[2], row[3]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] people = new double[10][2];
        for (int i = 0; i < 10; i++) {
            System.out.println("Person " + (i + 1) + ":");
            do {
                System.out.print("Weight in kg: ");
                people[i][0] = sc.nextDouble();
            } while (people[i][0] <= 0);
            do {
                System.out.print("Height in cm: ");
                people[i][1] = sc.nextDouble();
            } while (people[i][1] <= 0);
        }
        displayTable(processPeople(people));
        sc.close();
    }
}

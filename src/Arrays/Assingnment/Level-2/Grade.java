package src.Arrays.Assignment.Level_2;

import java.util.Scanner;

public class Grade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Invalid number of students.");
            sc.close();
            return;
        }

        int[][] marks = new int[n][3];
        double[] percentage = new double[n];
        String[] grade = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1));

            for (int j = 0; j < marks[i].length; j++) {
                System.out.print("Enter marks (0-100): ");
                marks[i][j] = sc.nextInt();

                if (marks[i][j] < 0 || marks[i][j] > 100) {
                    System.out.println("Invalid marks. Enter again.");
                    j--;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int total = 0;

            for (int j = 0; j < marks[i].length; j++) {
                total += marks[i][j];
            }

            percentage[i] = total / 3.0;

            if (percentage[i] >= 80) {
                grade[i] = "A";
            } else if (percentage[i] >= 70) {
                grade[i] = "B";
            } else if (percentage[i] >= 60) {
                grade[i] = "C";
            } else if (percentage[i] >= 50) {
                grade[i] = "D";
            } else if (percentage[i] >= 40) {
                grade[i] = "E";
            } else {
                grade[i] = "R";
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1));
            System.out.println("Physics: " + marks[i][0]);
            System.out.println("Chemistry: " + marks[i][1]);
            System.out.println("Maths: " + marks[i][2]);
            System.out.println("Percentage: " + percentage[i]);
            System.out.println("Grade: " + grade[i]);
        }

        sc.close();
    }
}

package src.String.Assignment.level2;

import java.util.Scanner;

public class Q8_StudentVotingEligibility {
    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);
            result[i][1] = ages[i] >= 18 ? "true" : "false";
            if (ages[i] < 0) result[i][1] = "false";
        }
        return result;
    }

    public static void displayTable(String[][] data) {
        System.out.printf("%-10s %s%n", "Age", "Can Vote?");
        for (String[] row : data) System.out.printf("%-10s %s%n", row[0], row[1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ages = new int[10];
        for (int i = 0; i < ages.length; i++) {
            System.out.print("Enter age of student " + (i + 1) + ": ");
            ages[i] = sc.nextInt();
        }
        displayTable(checkVotingEligibility(ages));
        sc.close();
    }
}

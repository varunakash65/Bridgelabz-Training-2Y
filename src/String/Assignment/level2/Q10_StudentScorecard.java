package src.String.Assignment.level2;

import java.util.Scanner;

public class Q10_StudentScorecard {
    public static int[][] generateRandomScores(int students) {
        int[][] scores = new int[students][3];
        for (int i = 0; i < students; i++) {
            for (int j = 0; j < 3; j++) scores[i][j] = (int) (Math.random() * 100);
        }
        return scores;
    }

    public static int[][] readScores(Scanner sc, int students) {
        int[][] scores = new int[students][3];
        String[] subjects = {"Physics", "Chemistry", "Maths"};
        for (int i = 0; i < students; i++) {
            System.out.println("Student " + (i + 1) + ":");
            for (int j = 0; j < 3; j++) {
                do {
                    System.out.print(subjects[j] + " marks (0-100): ");
                    scores[i][j] = sc.nextInt();
                } while (scores[i][j] < 0 || scores[i][j] > 100);
            }
        }
        return scores;
    }

    public static double[][] calculateResults(int[][] scores) {
        double[][] result = new double[scores.length][4];
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = total / 3.0;
            result[i][0] = total;
            result[i][1] = Math.round(average * 100.0) / 100.0;
            result[i][2] = Math.round(percentage * 100.0) / 100.0;
            result[i][3] = total; // Retained for clarity in the scorecard data.
        }
        return result;
    }

    public static String getGrade(double percentage) {
        if (percentage >= 80) return "A";
        if (percentage >= 70) return "B";
        if (percentage >= 60) return "C";
        if (percentage >= 50) return "D";
        if (percentage >= 40) return "E";
        return "R";
    }

    public static void displayScorecard(int[][] scores, double[][] results) {
        System.out.printf("%-8s %8s %8s %8s %8s %8s %8s %8s%n",
                "Student", "Physics", "Chemistry", "Maths", "Total", "Average", "Percent", "Grade");
        for (int i = 0; i < scores.length; i++) {
            String grade = getGrade(results[i][2]);
            System.out.printf("%-8d %8d %8d %8d %8.0f %8.2f %7.2f%% %8s%n",
                    (i + 1), scores[i][0], scores[i][1], scores[i][2], results[i][0],
                    results[i][1], results[i][2], grade);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int students = sc.nextInt();
        if (students <= 0) {
            System.out.println("Number of students must be positive.");
            sc.close();
            return;
        }
        System.out.print("Enter 1 for manual marks or 2 for random marks (PDF hint): ");
        int choice = sc.nextInt();
        int[][] scores = choice == 2 ? generateRandomScores(students) : readScores(sc, students);
        double[][] results = calculateResults(scores);
        displayScorecard(scores, results);
        sc.close();
    }
}

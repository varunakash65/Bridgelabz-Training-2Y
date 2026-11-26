package src.Recursion.Assignment.RecursionAndBacktracking;

import java.util.Scanner;

public class NQueensBacktracking {
    private int n;
    private int[] queenColumn;
    private boolean[] columns;
    private boolean[] diagDown;
    private boolean[] diagUp;
    private boolean[][] forbidden;
    private boolean findAll;
    private int solutionCount;
    private long positionsChecked;

    private NQueensBacktracking(int n, boolean findAll, boolean[][] forbidden) {
        this.n = n;
        this.findAll = findAll;
        this.forbidden = forbidden;
        queenColumn = new int[n];
        columns = new boolean[n];
        diagDown = new boolean[2 * n - 1]; // row - col + n - 1
        diagUp = new boolean[2 * n - 1];   // row + col
    }

    private boolean solve(int row) {
        if (row == n) {
            solutionCount++;
            printBoard();
            return !findAll; // Stop early when only one solution is requested.
        }

        for (int col = 0; col < n; col++) {
            positionsChecked++;
            int d1 = row - col + n - 1;
            int d2 = row + col;
            if (forbidden[row][col] || columns[col] || diagDown[d1] || diagUp[d2]) {
                continue;
            }

            queenColumn[row] = col; // Make a choice.
            columns[col] = true;
            diagDown[d1] = true;
            diagUp[d2] = true;

            boolean stop = solve(row + 1);

            // Undo the choice before returning or trying another column.
            columns[col] = false;
            diagDown[d1] = false;
            diagUp[d2] = false;
            queenColumn[row] = -1;
            if (stop) {
                return true;
            }
        }
        return false;
    }

    private void printBoard() {
        System.out.println("Solution " + solutionCount + ":");
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(queenColumn[row] == col ? "Q " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter board size N: ");
        int n = sc.nextInt();
        if (n < 1) {
            System.out.println("N must be at least 1.");
            return;
        }

        boolean[][] forbidden = new boolean[n][n];
        System.out.print("Enter number of forbidden squares (0 if none): ");
        int blocked = sc.nextInt();
        for (int i = 0; i < blocked; i++) {
            System.out.print("Enter forbidden row and column (0-based): ");
            int row = sc.nextInt();
            int col = sc.nextInt();
            if (row >= 0 && row < n && col >= 0 && col < n) {
                forbidden[row][col] = true;
            }
        }

        System.out.print("Find all solutions? (true/false): ");
        boolean findAll = sc.nextBoolean();
        NQueensBacktracking solver = new NQueensBacktracking(n, findAll, forbidden);
        solver.solve(0);
        System.out.println("Total solutions found: " + solver.solutionCount);
        System.out.println("Candidate positions checked: " + solver.positionsChecked);
    }
}

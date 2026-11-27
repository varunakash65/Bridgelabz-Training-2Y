package src.Recursion.Assignment.RecursionAndBacktracking;

import java.util.Scanner;

public class RatInMazeBacktracking {
    private static int rows;
    private static int cols;
    private static int[][] maze;
    private static boolean[][] visited;
    private static int pathCount;
    private static final int[] DR = {1, 0, -1, 0};
    private static final int[] DC = {0, 1, 0, -1};
    private static final char[] MOVE = {'D', 'R', 'U', 'L'};

    private static void findPaths(int row, int col, StringBuilder path) {
        if (row == rows - 1 && col == cols - 1) {
            pathCount++;
            System.out.println("Path " + pathCount + ": " + path);
            return;
        }

        visited[row][col] = true;
        for (int k = 0; k < 4; k++) {
            int nextRow = row + DR[k];
            int nextCol = col + DC[k];
            if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols
                    && maze[nextRow][nextCol] == 0 && !visited[nextRow][nextCol]) {
                path.append(MOVE[k]);
                findPaths(nextRow, nextCol, path);
                path.deleteCharAt(path.length() - 1); // Undo the move.
            }
        }
        visited[row][col] = false; // Backtrack so another path can use this cell.
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rows and columns: ");
        rows = sc.nextInt();
        cols = sc.nextInt();
        if (rows <= 0 || cols <= 0) {
            System.out.println("Invalid maze size.");
            return;
        }
        maze = new int[rows][cols];
        visited = new boolean[rows][cols];
        System.out.println("Enter maze (0 = open, 1 = blocked):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
        if (maze[0][0] == 1 || maze[rows - 1][cols - 1] == 1) {
            System.out.println("No path exists.");
            return;
        }
        findPaths(0, 0, new StringBuilder());
        if (pathCount == 0) {
            System.out.println("No path exists.");
        }
    }
}

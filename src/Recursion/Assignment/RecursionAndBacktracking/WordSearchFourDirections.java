package src.Recursion.Assignment.RecursionAndBacktracking;

import java.util.Scanner;

public class WordSearchFourDirections {
    private static final int[] DR = {-1, 1, 0, 0};
    private static final int[] DC = {0, 0, -1, 1};
    private static boolean[][] visited;

    private static boolean search(char[][] grid, String word, int row, int col, int index) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length
                || visited[row][col] || grid[row][col] != word.charAt(index)) {
            return false;
        }

        visited[row][col] = true;
        for (int k = 0; k < 4; k++) {
            if (search(grid, word, row + DR[k], col + DC[k], index + 1)) {
                visited[row][col] = false;
                return true;
            }
        }
        visited[row][col] = false;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rows and columns: ");
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        char[][] grid = new char[rows][cols];
        System.out.println("Enter grid letters:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = sc.next().charAt(0);
            }
        }
        System.out.print("Enter word to search: ");
        String word = sc.next();
        visited = new boolean[rows][cols];
        boolean found = false;
        for (int i = 0; i < rows && !found; i++) {
            for (int j = 0; j < cols && !found; j++) {
                found = search(grid, word, i, j, 0);
            }
        }
        System.out.println(found ? "Word found." : "Word not found.");
    }
}

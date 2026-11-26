package src.Recursion.Assignment.RecursionAndBacktracking;

public class WordSearchEightDirections {
    private static final char[][] GRID = {
        {'C', 'A', 'T', 'S'},
        {'O', 'R', 'E', 'A'},
        {'D', 'E', 'A', 'M'},
        {'E', 'L', 'L', 'S'}
    };
    private static final int[] DR = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] DC = {-1, 0, 1, -1, 1, -1, 0, 1};
    private static boolean[][] visited;
    private static int pathsFound;

    private static void search(String word, int row, int col, int index, String path) {
        if (row < 0 || row >= GRID.length || col < 0 || col >= GRID[0].length
                || visited[row][col] || GRID[row][col] != word.charAt(index)) {
            return;
        }
        if (index == word.length() - 1) {
            pathsFound++;
            System.out.println("Path " + pathsFound + ": " + path);
            return;
        }

        visited[row][col] = true;
        for (int k = 0; k < 8; k++) {
            int nextRow = row + DR[k];
            int nextCol = col + DC[k];
            search(word, nextRow, nextCol, index + 1,
                    path + " -> (" + nextRow + "," + nextCol + ")");
        }
        visited[row][col] = false; // Backtrack.
    }

    public static void main(String[] args) {
        String word = "DREAM";
        visited = new boolean[GRID.length][GRID[0].length];
        System.out.println("Grid:");
        for (char[] row : GRID) {
            for (char ch : row) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
        System.out.println("Searching for: " + word);
        for (int i = 0; i < GRID.length; i++) {
            for (int j = 0; j < GRID[0].length; j++) {
                if (GRID[i][j] == word.charAt(0)) {
                    search(word, i, j, 0, "(" + i + "," + j + ")");
                }
            }
        }
        if (pathsFound == 0) {
            System.out.println("Word not found.");
        }
    }
}

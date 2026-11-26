package src.Recursion.Assignment.RecursionAndBacktracking;

import java.util.Scanner;

public class GraphColoringBacktracking {
    private static boolean isSafe(int vertex, int color, int[][] graph, int[] colors) {
        for (int i = 0; i < graph.length; i++) {
            if (graph[vertex][i] == 1 && colors[i] == color) {
                return false;
            }
        }
        return true;
    }

    private static boolean colorGraph(int vertex, int colorCount, int[][] graph, int[] colors) {
        if (vertex == graph.length) {
            return true;
        }
        for (int color = 1; color <= colorCount; color++) {
            if (isSafe(vertex, color, graph, colors)) {
                colors[vertex] = color; // Assign a color.
                if (colorGraph(vertex + 1, colorCount, graph, colors)) {
                    return true;
                }
                colors[vertex] = 0; // Backtrack.
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();
        int[][] graph = new int[n][n];
        System.out.println("Enter adjacency matrix (0 or 1):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        System.out.print("Enter number of colors: ");
        int m = sc.nextInt();
        int[] colors = new int[n];
        if (colorGraph(0, m, graph, colors)) {
            for (int i = 0; i < n; i++) {
                System.out.println("Vertex " + i + " -> Color " + colors[i]);
            }
        } else {
            System.out.println("No valid coloring exists with " + m + " colors.");
        }
    }
}

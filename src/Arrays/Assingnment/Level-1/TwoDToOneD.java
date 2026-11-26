package src.Arrays.Assignment.Level_1;

import java.util.Arrays;
import java.util.Scanner;

public class TwoDToOneD {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = input.nextInt();

        System.out.print("Enter number of columns: ");
        int columns = input.nextInt();

        if (rows <= 0 || columns <= 0) {
            System.out.println("Invalid rows or columns.");
            input.close();
            return;
        }

        int[][] matrix = new int[rows][columns];

        System.out.println("Enter the elements of the 2D array:");

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = input.nextInt();
            }
        }

        int[] array = new int[rows * columns];
        int index = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                array[index++] = matrix[i][j];
            }
        }

        System.out.println("2D Array:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("1D Array: " + Arrays.toString(array));

        input.close();
    }
}

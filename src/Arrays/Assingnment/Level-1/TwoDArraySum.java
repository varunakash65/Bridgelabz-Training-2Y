package src.Arrays.Assignment.Level_1;

import java.util.Scanner;

public class TwoDArraySum {
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

        int[][] arr = new int[rows][columns];
        int sum = 0;

        System.out.println("Enter the elements of the 2D Array:");

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = input.nextInt();
                sum += arr[i][j];
            }
        }

        System.out.println("The elements of the 2D Array are:");

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("The sum of the elements of the 2D Array is: " + sum);
        input.close();
    }
}

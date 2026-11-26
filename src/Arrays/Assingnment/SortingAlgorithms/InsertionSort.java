package Arrays.Assignment.SortingAlgorithms;

import java.util.Scanner;

public class InsertionSort {
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            // Shift larger elements one position to the right.
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        int[] employeeIds = new int[n];

        System.out.println("Enter employee IDs:");
        for (int i = 0; i < n; i++) {
            employeeIds[i] = sc.nextInt();
        }

        insertionSort(employeeIds);

        System.out.println("Employee IDs in ascending order:");
        for (int id : employeeIds) {
            System.out.print(id + " ");
        }
        System.out.println();
        sc.close();
    }
}

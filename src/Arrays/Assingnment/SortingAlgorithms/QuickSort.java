package Arrays.Assignment.SortingAlgorithms;

import java.util.Scanner;

public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Uses the last element as the pivot.
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        int[] prices = new int[n];

        System.out.println("Enter product prices (whole numbers):");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        quickSort(prices, 0, prices.length - 1);

        System.out.println("Product prices in ascending order:");
        for (int price : prices) {
            System.out.print(price + " ");
        }
        System.out.println();
        sc.close();
    }
}

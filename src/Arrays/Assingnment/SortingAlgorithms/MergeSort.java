package Arrays.Assignment.SortingAlgorithms;

import java.util.Scanner;

public class MergeSort {
    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of books: ");
        int n = sc.nextInt();
        int[] prices = new int[n];

        System.out.println("Enter book prices (whole numbers):");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        mergeSort(prices, 0, prices.length - 1);

        System.out.println("Book prices in ascending order:");
        for (int price : prices) {
            System.out.print(price + " ");
        }
        System.out.println();
        sc.close();
    }
}

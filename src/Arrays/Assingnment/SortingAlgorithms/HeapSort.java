package Arrays.Assignment.SortingAlgorithms;

import java.util.Scanner;

public class HeapSort {
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build a max heap.
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Move the largest element to the end one by one.
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int heapSize, int root) {
        int largest = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        if (left < heapSize && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != root) {
            int temp = arr[root];
            arr[root] = arr[largest];
            arr[largest] = temp;
            heapify(arr, heapSize, largest);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of job applicants: ");
        int n = sc.nextInt();
        int[] salaries = new int[n];

        System.out.println("Enter expected salary demands (whole numbers):");
        for (int i = 0; i < n; i++) {
            salaries[i] = sc.nextInt();
        }

        heapSort(salaries);

        System.out.println("Salary demands in ascending order:");
        for (int salary : salaries) {
            System.out.print(salary + " ");
        }
        System.out.println();
        sc.close();
    }
}

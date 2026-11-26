package src.Arrays.Assignment.LinearBinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class LinearAndBinarySearchChallenge {
    // Finds the first missing positive integer using a marker array.
    public static int firstMissingPositive(int[] arr) {
        boolean[] present = new boolean[arr.length + 2];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0 && arr[i] <= arr.length + 1) {
                present[arr[i]] = true;
            }
        }

        for (int number = 1; number <= arr.length + 1; number++) {
            if (!present[number]) {
                return number;
            }
        }

        return arr.length + 1;
    }

    // Iterative binary search. The array must be sorted first.
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int missing = firstMissingPositive(arr);
        System.out.println("First missing positive integer: " + missing);

        System.out.print("Enter target for binary search: ");
        int target = sc.nextInt();

        Arrays.sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));

        int index = binarySearch(arr, target);
        System.out.println("Target index in sorted array: " + index);

        sc.close();
    }
}

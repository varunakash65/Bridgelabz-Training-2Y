package src.Arrays.Assignment.LinearBinarySearch;

import java.util.Scanner;

public class RotationPoint {
    // Returns the index of the smallest element in a rotated sorted array.
    public static int findRotationPoint(int[] arr) {
        if (arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else if (arr[mid] < arr[right]) {
                right = mid;
            } else {
                // Handles duplicate values safely.
                right--;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter rotated sorted array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int index = findRotationPoint(arr);
        if (index == -1) {
            System.out.println("Array is empty.");
        } else {
            System.out.println("Rotation point index: " + index);
            System.out.println("Smallest element: " + arr[index]);
        }

        sc.close();
    }
}

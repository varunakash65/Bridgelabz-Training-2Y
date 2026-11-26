package src.Arrays.Assignment.LinearBinarySearch;

import java.util.Scanner;

public class PeakElement {
    // Returns the index of any peak element.
    public static int findPeakElement(int[] arr) {
        if (arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            boolean greaterThanLeft = (mid == 0) || (arr[mid] > arr[mid - 1]);
            boolean greaterThanRight = (mid == arr.length - 1) || (arr[mid] > arr[mid + 1]);

            if (greaterThanLeft && greaterThanRight) {
                return mid;
            }

            if (mid > 0 && arr[mid] < arr[mid - 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
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

        int index = findPeakElement(arr);
        if (index == -1) {
            System.out.println("Peak element not found.");
        } else {
            System.out.println("Peak element: " + arr[index]);
            System.out.println("Index: " + index);
        }

        sc.close();
    }
}

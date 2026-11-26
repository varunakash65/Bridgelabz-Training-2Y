package src.Arrays.Assignment.LinearBinarySearch;

import java.util.Scanner;

public class FirstAndLastOccurrence {
    public static int firstOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int answer = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                answer = mid;
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    public static int lastOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int answer = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                answer = mid;
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter sorted array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        int first = firstOccurrence(arr, target);
        int last = lastOccurrence(arr, target);

        if (first == -1) {
            System.out.println("Target not found. First and last occurrence: -1");
        } else {
            System.out.println("First occurrence index: " + first);
            System.out.println("Last occurrence index: " + last);
        }

        sc.close();
    }
}

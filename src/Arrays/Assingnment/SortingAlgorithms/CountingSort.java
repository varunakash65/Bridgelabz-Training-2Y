package Arrays.Assignment.SortingAlgorithms;

import java.util.Scanner;

public class CountingSort {
    // The assignment specifies student ages from 10 to 18.
    public static void countingSort(int[] ages) {
        int[] count = new int[9]; // Index 0 represents age 10; index 8 represents age 18.

        for (int age : ages) {
            if (age < 10 || age > 18) {
                throw new IllegalArgumentException("Age must be between 10 and 18: " + age);
            }
            count[age - 10]++;
        }

        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                ages[index++] = i + 10;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        int[] ages = new int[n];

        System.out.println("Enter student ages (10 to 18):");
        for (int i = 0; i < n; i++) {
            ages[i] = sc.nextInt();
        }

        try {
            countingSort(ages);
            System.out.println("Student ages in ascending order:");
            for (int age : ages) {
                System.out.print(age + " ");
            }
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}

package src.String.Assignment.LinearBinarySearch;

import java.util.Scanner;

public class ConcatenateStringsUsingStringBuffer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of strings: ");
        int n = sc.nextInt();
        sc.nextLine();

        StringBuffer result = new StringBuffer();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter string " + (i + 1) + ": ");
            result.append(sc.nextLine());
        }

        System.out.println("Concatenated string: " + result);
        sc.close();
    }
}

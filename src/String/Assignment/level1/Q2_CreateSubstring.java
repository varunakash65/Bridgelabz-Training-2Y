package src.String.Assignment.level1;

import java.util.Scanner;

public class Q2_CreateSubstring {
    public static String createSubstring(String text, int start, int end) {
        if (start < 0 || end > text.length() || start > end) {
            throw new IndexOutOfBoundsException("Invalid substring indexes.");
        }
        StringBuilder result = new StringBuilder();
        for (int i = start; i < end; i++) result.append(text.charAt(i));
        return result.toString();
    }

    public static boolean compareUsingCharAt(String first, String second) {
        if (first.length() != second.length()) return false;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text (one word): ");
        String text = sc.next();
        System.out.print("Enter start index (inclusive): ");
        int start = sc.nextInt();
        System.out.print("Enter end index (exclusive): ");
        int end = sc.nextInt();

        try {
            String userSubstring = createSubstring(text, start, end);
            String builtInSubstring = text.substring(start, end);
            System.out.println("User-defined substring: " + userSubstring);
            System.out.println("Built-in substring(): " + builtInSubstring);
            System.out.println("Both results are same: " + compareUsingCharAt(userSubstring, builtInSubstring));
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Invalid indexes: " + ex.getMessage());
        }
        sc.close();
    }
}

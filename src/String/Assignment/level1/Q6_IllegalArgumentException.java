package src.String.Assignment.level1;

import java.util.Scanner;

public class Q6_IllegalArgumentException {
    // The PDF asks for IllegalArgumentException. Validate explicitly because
    // String.substring(start, end) itself throws StringIndexOutOfBoundsException
    // when start is greater than end in Java.
    public static String getSubstring(String text, int start, int end) {
        if (start > end) throw new IllegalArgumentException("Start index must not be greater than end index.");
        return text.substring(start, end);
    }

    public static void generateException(String text) {
        getSubstring(text, 4, 1);
    }

    public static void handleException(String text) {
        try {
            System.out.println(getSubstring(text, 4, 1));
        } catch (IllegalArgumentException ex) {
            System.out.println("IllegalArgumentException handled: " + ex.getMessage());
        } catch (RuntimeException ex) {
            System.out.println("RuntimeException handled: " + ex);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string having at least 5 characters: ");
        String text = sc.nextLine();
        if (text.length() < 5) {
            System.out.println("Please run again and enter at least 5 characters.");
        } else {
            try {
                generateException(text);
            } catch (IllegalArgumentException ex) {
                System.out.println("Generated exception caught in main: " + ex.getClass().getSimpleName());
            }
            handleException(text);
        }
        sc.close();
    }
}

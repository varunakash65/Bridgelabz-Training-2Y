package src.String.Assignment.level1;

import java.util.Scanner;

public class Q5_StringIndexOutOfBoundsException {
    public static void generateException(String text) {
        System.out.println(text.charAt(text.length())); // Last valid index is length - 1.
    }

    public static void handleException(String text) {
        try {
            System.out.println(text.charAt(text.length()));
        } catch (StringIndexOutOfBoundsException ex) {
            System.out.println("StringIndexOutOfBoundsException handled: index is outside the string.");
        } catch (RuntimeException ex) {
            System.out.println("RuntimeException handled: " + ex);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();
        try {
            generateException(text);
        } catch (StringIndexOutOfBoundsException ex) {
            System.out.println("Generated exception caught in main: " + ex.getClass().getSimpleName());
        }
        handleException(text);
        sc.close();
    }
}

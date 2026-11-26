package src.String.Assignment.level1;

import java.util.Scanner;

public class Q7_NumberFormatException {
    public static int generateException(String text) {
        return Integer.parseInt(text);
    }

    public static void handleException(String text) {
        try {
            int number = Integer.parseInt(text);
            System.out.println("Converted number: " + number);
        } catch (NumberFormatException ex) {
            System.out.println("NumberFormatException handled: input is not a valid integer.");
        } catch (RuntimeException ex) {
            System.out.println("RuntimeException handled: " + ex);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text (enter letters to demonstrate the exception): ");
        String text = sc.nextLine();
        try {
            System.out.println("Parsed number: " + generateException(text));
        } catch (NumberFormatException ex) {
            System.out.println("Generated exception caught in main: " + ex.getClass().getSimpleName());
        }
        handleException(text);
        sc.close();
    }
}

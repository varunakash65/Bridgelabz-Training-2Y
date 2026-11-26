package src.String.Assignment.level1;

import java.util.Scanner;

public class Q8_ArrayIndexOutOfBoundsException {
    public static void generateException(String[] names) {
        System.out.println(names[names.length]); // Deliberately accesses one index beyond the array.
    }

    public static void handleException(String[] names) {
        try {
            System.out.println(names[names.length]);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("ArrayIndexOutOfBoundsException handled: invalid array index.");
        } catch (RuntimeException ex) {
            System.out.println("RuntimeException handled: " + ex);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many names do you want to enter? ");
        int count = sc.nextInt();
        if (count <= 0) {
            System.out.println("Enter a positive number of names.");
            sc.close();
            return;
        }
        String[] names = new String[count];
        for (int i = 0; i < count; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = sc.next();
        }
        try {
            generateException(names);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Generated exception caught in main: " + ex.getClass().getSimpleName());
        }
        handleException(names);
        sc.close();
    }
}

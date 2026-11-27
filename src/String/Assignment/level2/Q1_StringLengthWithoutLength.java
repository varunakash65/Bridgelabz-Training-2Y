package src.String.Assignment.level2;

import java.util.Scanner;

public class Q1_StringLengthWithoutLength {
    public static int findLength(String text) {
        int count = 0;
        while (true) {
            try {
                text.charAt(count);
                count++;
            } catch (StringIndexOutOfBoundsException ex) {
                return count;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String text = sc.next();
        System.out.println("Length without length(): " + findLength(text));
        System.out.println("Built-in length(): " + text.length());
        sc.close();
    }
}

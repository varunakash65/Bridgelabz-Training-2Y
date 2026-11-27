package src.String.Assignment.level3;

import java.util.Scanner;

public class Q7_CheckPalindromeThreeWays {
    public static boolean isPalindromeTwoPointers(String text) {
        int start = 0, end = text.length() - 1;
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) return true;
        if (text.charAt(start) != text.charAt(end)) return false;
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    public static char[] reverseUsingCharAt(String text) {
        char[] reversed = new char[text.length()];
        for (int i = 0; i < text.length(); i++) reversed[i] = text.charAt(text.length() - 1 - i);
        return reversed;
    }

    public static boolean isPalindromeUsingArrays(String text) {
        char[] original = text.toCharArray();
        char[] reversed = reverseUsingCharAt(text);
        if (original.length != reversed.length) return false;
        for (int i = 0; i < original.length; i++) if (original[i] != reversed[i]) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        System.out.println("Two-pointer method: " + isPalindromeTwoPointers(text));
        System.out.println("Recursive method: " + isPalindromeRecursive(text, 0, text.length() - 1));
        System.out.println("Character-array method: " + isPalindromeUsingArrays(text));
        sc.close();
    }
}

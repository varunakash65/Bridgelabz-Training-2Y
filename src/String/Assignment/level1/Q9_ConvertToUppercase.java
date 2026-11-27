package src.String.Assignment.level1;

import java.util.Scanner;

public class Q9_ConvertToUppercase {
    public static String convertToUppercase(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'z') ch = (char) (ch - 32);
            result.append(ch);
        }
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
        System.out.print("Enter complete text: ");
        String text = sc.nextLine();
        String userResult = convertToUppercase(text);
        String builtInResult = text.toUpperCase();
        System.out.println("User-defined uppercase: " + userResult);
        System.out.println("Built-in toUpperCase(): " + builtInResult);
        System.out.println("Both results are same: " + compareUsingCharAt(userResult, builtInResult));
        sc.close();
    }
}

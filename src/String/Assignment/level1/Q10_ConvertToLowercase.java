package src.String.Assignment.level1;

import java.util.Scanner;

public class Q10_ConvertToLowercase {
    public static String convertToLowercase(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') ch = (char) (ch + 32);
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
        String userResult = convertToLowercase(text);
        String builtInResult = text.toLowerCase();
        System.out.println("User-defined lowercase: " + userResult);
        System.out.println("Built-in toLowerCase(): " + builtInResult);
        System.out.println("Both results are same: " + compareUsingCharAt(userResult, builtInResult));
        sc.close();
    }
}

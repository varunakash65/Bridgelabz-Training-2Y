package src.String.Assignment.level2;

import java.util.Scanner;

public class Q7_TrimSpacesUsingCharAt {
    public static int[] findTrimIndexes(String text) {
        int start = 0;
        int end = text.length() - 1;
        while (start < text.length() && text.charAt(start) == ' ') start++;
        while (end >= start && text.charAt(end) == ' ') end--;
        return new int[] {start, end + 1}; // End index is exclusive.
    }

    public static String createSubstring(String text, int start, int end) {
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
        System.out.print("Enter text with leading/trailing spaces: ");
        String text = sc.nextLine();
        int[] indexes = findTrimIndexes(text);
        String userTrimmed = createSubstring(text, indexes[0], indexes[1]);
        String builtInTrimmed = text.trim();
        System.out.println("User-defined trim: [" + userTrimmed + "]");
        System.out.println("Built-in trim(): [" + builtInTrimmed + "]");
        System.out.println("Both results are same: " + compareUsingCharAt(userTrimmed, builtInTrimmed));
        sc.close();
    }
}

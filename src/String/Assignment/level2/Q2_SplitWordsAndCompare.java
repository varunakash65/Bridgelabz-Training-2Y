package src.String.Assignment.level2;

import java.util.Arrays;
import java.util.Scanner;

public class Q2_SplitWordsAndCompare {
    public static int findLength(String text) {
        int count = 0;
        while (true) {
            try { text.charAt(count); count++; }
            catch (StringIndexOutOfBoundsException ex) { return count; }
        }
    }

    public static String[] splitManually(String text) {
        int n = findLength(text);
        int wordCount = 0;
        boolean insideWord = false;
        for (int i = 0; i < n; i++) {
            if (!Character.isWhitespace(text.charAt(i)) && !insideWord) {
                wordCount++;
                insideWord = true;
            } else if (Character.isWhitespace(text.charAt(i))) {
                insideWord = false;
            }
        }

        String[] words = new String[wordCount];
        int wordIndex = 0;
        int start = -1;
        for (int i = 0; i <= n; i++) {
            boolean atEnd = (i == n);
            boolean isSpace = !atEnd && Character.isWhitespace(text.charAt(i));
            if (!atEnd && !isSpace && start == -1) start = i;
            if ((atEnd || isSpace) && start != -1) {
                StringBuilder word = new StringBuilder();
                for (int j = start; j < i; j++) word.append(text.charAt(j));
                words[wordIndex++] = word.toString();
                start = -1;
            }
        }
        return words;
    }

    public static boolean compareArrays(String[] first, String[] second) {
        if (first.length != second.length) return false;
        for (int i = 0; i < first.length; i++) {
            if (!first[i].equals(second[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();
        String[] userWords = splitManually(text);
        String trimmed = text.trim();
        String[] builtInWords = trimmed.isEmpty() ? new String[0] : trimmed.split("\\s+");
        System.out.println("User-defined words: " + Arrays.toString(userWords));
        System.out.println("Built-in split() words: " + Arrays.toString(builtInWords));
        System.out.println("Both results are same: " + compareArrays(userWords, builtInWords));
        sc.close();
    }
}

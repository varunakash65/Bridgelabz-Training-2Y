package src.String.Assignment.level2;

import java.util.Scanner;

public class Q4_ShortestAndLongestWord {
    public static int findLength(String text) {
        int count = 0;
        while (true) {
            try { text.charAt(count); count++; }
            catch (StringIndexOutOfBoundsException ex) { return count; }
        }
    }

    public static String[] splitManually(String text) {
        int n = findLength(text), count = 0;
        boolean inWord = false;
        for (int i = 0; i < n; i++) {
            if (!Character.isWhitespace(text.charAt(i)) && !inWord) { count++; inWord = true; }
            else if (Character.isWhitespace(text.charAt(i))) inWord = false;
        }
        String[] words = new String[count];
        int index = 0, start = -1;
        for (int i = 0; i <= n; i++) {
            boolean end = i == n;
            boolean space = !end && Character.isWhitespace(text.charAt(i));
            if (!end && !space && start == -1) start = i;
            if ((end || space) && start != -1) {
                StringBuilder word = new StringBuilder();
                for (int j = start; j < i; j++) word.append(text.charAt(j));
                words[index++] = word.toString();
                start = -1;
            }
        }
        return words;
    }

    public static String[][] getWordsAndLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }
        return result;
    }

    public static int[] findShortestAndLongest(String[][] wordsAndLengths) {
        if (wordsAndLengths.length == 0) return new int[] {-1, -1};
        int shortest = 0, longest = 0;
        for (int i = 1; i < wordsAndLengths.length; i++) {
            int current = Integer.parseInt(wordsAndLengths[i][1]);
            if (current < Integer.parseInt(wordsAndLengths[shortest][1])) shortest = i;
            if (current > Integer.parseInt(wordsAndLengths[longest][1])) longest = i;
        }
        return new int[] {shortest, longest};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();
        String[][] data = getWordsAndLengths(splitManually(text));
        int[] indexes = findShortestAndLongest(data);
        if (indexes[0] == -1) {
            System.out.println("No words were entered.");
        } else {
            System.out.println("Shortest word: " + data[indexes[0]][0] + " (" + data[indexes[0]][1] + ")");
            System.out.println("Longest word: " + data[indexes[1]][0] + " (" + data[indexes[1]][1] + ")");
        }
        sc.close();
    }
}

package src.String.Assignment.level3;

import java.util.Scanner;

public class Q5_CharacterFrequencyUsingUniqueCharacters {
    public static char[] uniqueCharacters(String text) {
        char[] temporary = new char[text.length()];
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            boolean exists = false;
            for (int j = 0; j < count; j++) {
                if (temporary[j] == current) { exists = true; break; }
            }
            if (!exists) temporary[count++] = current;
        }
        char[] result = new char[count];
        for (int i = 0; i < count; i++) result[i] = temporary[i];
        return result;
    }

    public static String[][] findFrequency(String text) {
        int[] frequency = new int[256];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch < 256) frequency[ch]++;
        }
        char[] unique = uniqueCharacters(text);
        String[][] result = new String[unique.length][2];
        for (int i = 0; i < unique.length; i++) {
            char ch = unique[i];
            result[i][0] = ch == ' ' ? "[space]" : String.valueOf(ch);
            result[i][1] = ch < 256 ? String.valueOf(frequency[ch]) : "0 (non-ASCII)";
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        String[][] data = findFrequency(text);
        System.out.printf("%-15s %s%n", "Character", "Frequency");
        for (String[] row : data) System.out.printf("%-15s %s%n", row[0], row[1]);
        sc.close();
    }
}

package src.String.Assignment.level3;

import java.util.Scanner;

public class Q4_CharacterFrequencyUsingASCII {
    public static String[][] findCharacterFrequency(String text) {
        int[] frequency = new int[256];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch < 256) frequency[ch]++;
        }
        int uniqueCount = 0;
        for (int value : frequency) if (value > 0) uniqueCount++;
        String[][] result = new String[uniqueCount][2];
        int row = 0;
        for (int ch = 0; ch < 256; ch++) {
            if (frequency[ch] > 0) {
                result[row][0] = ch == ' ' ? "[space]" : String.valueOf((char) ch);
                result[row][1] = String.valueOf(frequency[ch]);
                row++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        String[][] data = findCharacterFrequency(text);
        System.out.printf("%-15s %s%n", "Character", "Frequency");
        for (String[] row : data) System.out.printf("%-15s %s%n", row[0], row[1]);
        sc.close();
    }
}

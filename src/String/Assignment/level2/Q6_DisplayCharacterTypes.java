package src.String.Assignment.level2;

import java.util.Scanner;

public class Q6_DisplayCharacterTypes {
    public static String getCharacterType(char ch) {
        if (ch >= 'A' && ch <= 'Z') ch = (char) (ch + 32);
        if (ch < 'a' || ch > 'z') return "Not a Letter";
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return "Vowel";
        return "Consonant";
    }

    public static String[][] getCharacterDetails(String text) {
        String[][] result = new String[text.length()][2];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            result[i][0] = ch == ' ' ? "[space]" : String.valueOf(ch);
            result[i][1] = getCharacterType(ch);
        }
        return result;
    }

    public static void displayTable(String[][] data) {
        System.out.printf("%-15s %s%n", "Character", "Type");
        for (String[] row : data) System.out.printf("%-15s %s%n", row[0], row[1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter complete text: ");
        String text = sc.nextLine();
        displayTable(getCharacterDetails(text));
        sc.close();
    }
}

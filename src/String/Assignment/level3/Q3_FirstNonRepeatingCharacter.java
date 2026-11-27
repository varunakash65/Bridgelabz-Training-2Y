package src.String.Assignment.level3;

import java.util.Scanner;

public class Q3_FirstNonRepeatingCharacter {
    public static char findFirstNonRepeating(String text) {
        int[] frequency = new int[256];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch < 256) frequency[ch]++;
        }
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch < 256 && frequency[ch] == 1) return ch;
        }
        return '\0';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        char result = findFirstNonRepeating(text);
        if (result == '\0') System.out.println("No non-repeating ASCII character found.");
        else System.out.println("First non-repeating character: " + result);
        sc.close();
    }
}

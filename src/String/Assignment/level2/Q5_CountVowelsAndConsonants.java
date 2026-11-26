package src.String.Assignment.level2;

import java.util.Scanner;

public class Q5_CountVowelsAndConsonants {
    public static String getCharacterType(char ch) {
        if (ch >= 'A' && ch <= 'Z') ch = (char) (ch + 32);
        if (ch < 'a' || ch > 'z') return "Not a Letter";
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return "Vowel";
        return "Consonant";
    }

    public static int[] countVowelsAndConsonants(String text) {
        int vowels = 0, consonants = 0;
        for (int i = 0; i < text.length(); i++) {
            String type = getCharacterType(text.charAt(i));
            if (type.equals("Vowel")) vowels++;
            else if (type.equals("Consonant")) consonants++;
        }
        return new int[] {vowels, consonants};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter complete text: ");
        String text = sc.nextLine();
        int[] count = countVowelsAndConsonants(text);
        System.out.println("Vowels: " + count[0]);
        System.out.println("Consonants: " + count[1]);
        sc.close();
    }
}

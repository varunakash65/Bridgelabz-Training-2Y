package src.String.Assignment.level3;

import java.util.Scanner;

public class Q2_UniqueCharacters {
    public static int findLength(String text) {
        int count = 0;
        while (true) {
            try { text.charAt(count); count++; }
            catch (StringIndexOutOfBoundsException ex) { return count; }
        }
    }

    public static char[] findUniqueCharacters(String text) {
        int n = findLength(text);
        char[] temporary = new char[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            char current = text.charAt(i);
            boolean foundEarlier = false;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == current) { foundEarlier = true; break; }
            }
            if (!foundEarlier) temporary[count++] = current;
        }
        char[] result = new char[count];
        for (int i = 0; i < count; i++) result[i] = temporary[i];
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter complete text: ");
        String text = sc.nextLine();
        char[] unique = findUniqueCharacters(text);
        System.out.print("Unique characters: ");
        for (char ch : unique) System.out.print(ch + " ");
        System.out.println();
        sc.close();
    }
}

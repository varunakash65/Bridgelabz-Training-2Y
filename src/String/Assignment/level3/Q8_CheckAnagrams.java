package src.String.Assignment.level3;

import java.util.Scanner;

public class Q8_CheckAnagrams {
    public static boolean areAnagrams(String first, String second) {
        if (first.length() != second.length()) return false;
        int[] frequency = new int[256];
        for (int i = 0; i < first.length(); i++) {
            char a = first.charAt(i), b = second.charAt(i);
            if (a >= 256 || b >= 256) return false; // PDF's method uses the 256 ASCII character set.
            frequency[a]++;
            frequency[b]--;
        }
        for (int value : frequency) if (value != 0) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first text: ");
        String first = sc.nextLine();
        System.out.print("Enter second text: ");
        String second = sc.nextLine();
        System.out.println("Are the texts anagrams? " + areAnagrams(first, second));
        sc.close();
    }
}

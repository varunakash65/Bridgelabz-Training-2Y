package src.String.Assignment.level1;

import java.util.Arrays;
import java.util.Scanner;

public class Q3_ReturnCharactersArray {
    public static char[] getCharacters(String text) {
        char[] result = new char[text.length()];
        for (int i = 0; i < text.length(); i++) result[i] = text.charAt(i);
        return result;
    }

    public static boolean compareArrays(char[] first, char[] second) {
        if (first.length != second.length) return false;
        for (int i = 0; i < first.length; i++) {
            if (first[i] != second[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string (one word): ");
        String text = sc.next();

        char[] userArray = getCharacters(text);
        char[] builtInArray = text.toCharArray();
        System.out.println("User-defined character array: " + Arrays.toString(userArray));
        System.out.println("toCharArray() result: " + Arrays.toString(builtInArray));
        System.out.println("Both arrays are same: " + compareArrays(userArray, builtInArray));
        sc.close();
    }
}

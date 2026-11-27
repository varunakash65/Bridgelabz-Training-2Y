package src.String.Assignment.level3;

import java.util.Scanner;

public class Q6_CharacterFrequencyUsingNestedLoops {
    public static String[] findFrequency(String text) {
        char[] characters = text.toCharArray();
        int[] frequency = new int[characters.length];
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] != '\0') {
                frequency[i] = 1;
                for (int j = i + 1; j < characters.length; j++) {
                    if (characters[i] == characters[j]) {
                        frequency[i]++;
                        characters[j] = '\0'; // Mark duplicate so it is not counted again.
                    }
                }
            }
        }
        String[] result = new String[characters.length];
        int count = 0;
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] != '\0') {
                String label = characters[i] == ' ' ? "[space]" : String.valueOf(characters[i]);
                result[count++] = label + " : " + frequency[i];
            }
        }
        String[] finalResult = new String[count];
        for (int i = 0; i < count; i++) finalResult[i] = result[i];
        return finalResult;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        for (String row : findFrequency(text)) System.out.println(row);
        sc.close();
    }
}

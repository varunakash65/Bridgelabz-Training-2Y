package src.String.Assignment.level1;

import java.util.Scanner;

public class Sample_FindAllCharacterOccurrences {
    public static int[] findAllIndexes(String text, char target) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == target) count++;
        }
        int[] indexes = new int[count];
        int position = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == target) indexes[position++] = i;
        }
        return indexes;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        System.out.print("Enter character to find: ");
        char target = sc.nextLine().charAt(0);
        int[] indexes = findAllIndexes(text, target);
        System.out.print("Indexes of '" + target + "': ");
        if (indexes.length == 0) System.out.print("No occurrence found.");
        else for (int index : indexes) System.out.print(index + " ");
        System.out.println();
        sc.close();
    }
}

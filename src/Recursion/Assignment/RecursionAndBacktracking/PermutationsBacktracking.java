package src.Recursion.Assignment.RecursionAndBacktracking;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationsBacktracking {
    private static void generate(char[] chars, boolean[] used, StringBuilder current) {
        if (current.length() == chars.length) {
            System.out.println(current);
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (used[i]) {
                continue;
            }
            // Skip duplicate choices at the same recursion level.
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;                 // Make a choice
            current.append(chars[i]);
            generate(chars, used, current); // Recurse
            current.deleteCharAt(current.length() - 1); // Undo choice
            used[i] = false;                // Backtrack
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        char[] chars = sc.nextLine().toCharArray();
        Arrays.sort(chars);
        System.out.println("Permutations:");
        generate(chars, new boolean[chars.length], new StringBuilder());
    }
}

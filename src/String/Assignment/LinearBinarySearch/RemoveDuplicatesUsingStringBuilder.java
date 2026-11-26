package src.String.Assignment.LinearBinarySearch;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RemoveDuplicatesUsingStringBuilder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        StringBuilder result = new StringBuilder();
        Set<Character> seen = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (!seen.contains(ch)) {
                result.append(ch);
                seen.add(ch);
            }
        }

        System.out.println("String without duplicate characters: " + result);
        sc.close();
    }
}

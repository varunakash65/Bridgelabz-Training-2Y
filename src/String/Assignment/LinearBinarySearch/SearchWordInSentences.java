package src.String.Assignment.LinearBinarySearch;

import java.util.Scanner;

public class SearchWordInSentences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of sentences: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] sentences = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter sentence " + (i + 1) + ": ");
            sentences[i] = sc.nextLine();
        }

        System.out.print("Enter the word to search: ");
        String target = sc.nextLine();

        boolean found = false;
        for (int i = 0; i < sentences.length; i++) {
            if (sentences[i].contains(target)) {
                System.out.println("Word found in sentence " + (i + 1) + ":");
                System.out.println(sentences[i]);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Not Found");
        }

        sc.close();
    }
}

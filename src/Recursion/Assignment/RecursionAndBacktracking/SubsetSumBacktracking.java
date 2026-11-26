package src.Recursion.Assignment.RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubsetSumBacktracking {
    private static void findSubsets(int[] numbers, int index, int currentSum,
                                    int target, List<Integer> chosen, boolean[] found) {
        if (index == numbers.length) {
            if (currentSum == target) {
                System.out.println(chosen);
                found[0] = true;
            }
            return;
        }

        // Choice 1: include the current number.
        chosen.add(numbers[index]);
        findSubsets(numbers, index + 1, currentSum + numbers[index], target, chosen, found);
        chosen.remove(chosen.size() - 1); // Undo the choice.

        // Choice 2: exclude the current number.
        findSubsets(numbers, index + 1, currentSum, target, chosen, found);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] numbers = new int[n];
        System.out.println("Enter the numbers:");
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        System.out.print("Enter target sum: ");
        int target = sc.nextInt();

        System.out.println("Subsets with sum " + target + ":");
        boolean[] found = {false};
        findSubsets(numbers, 0, 0, target, new ArrayList<>(), found);
        if (!found[0]) {
            System.out.println("No subset found.");
        }
    }
}

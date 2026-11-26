package src.String.Assignment.level2;

import java.util.Scanner;

public class Q9_RockPaperScissors {
    public static String getComputerChoice() {
        String[] choices = {"rock", "paper", "scissors"};
        int index = (int) (Math.random() * choices.length);
        return choices[index];
    }

    public static String findWinner(String player, String computer) {
        if (player.equals(computer)) return "Draw";
        if ((player.equals("rock") && computer.equals("scissors")) ||
            (player.equals("paper") && computer.equals("rock")) ||
            (player.equals("scissors") && computer.equals("paper"))) return "Player";
        return "Computer";
    }

    public static String[][] createStats(int playerWins, int computerWins, int draws, int totalGames) {
        double playerPercent = totalGames == 0 ? 0 : playerWins * 100.0 / totalGames;
        double computerPercent = totalGames == 0 ? 0 : computerWins * 100.0 / totalGames;
        return new String[][] {
            {"Player", String.valueOf(playerWins), String.format("%.2f%%", playerPercent)},
            {"Computer", String.valueOf(computerWins), String.format("%.2f%%", computerPercent)},
            {"Draws", String.valueOf(draws), "-"}
        };
    }

    public static void displayStats(String[][] stats) {
        System.out.printf("%-12s %-12s %s%n", "Participant", "Wins/Draws", "Percentage");
        for (String[] row : stats) System.out.printf("%-12s %-12s %s%n", row[0], row[1], row[2]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of games: ");
        int games = sc.nextInt();
        if (games <= 0) {
            System.out.println("Number of games must be positive.");
            sc.close();
            return;
        }
        int playerWins = 0, computerWins = 0, draws = 0;
        System.out.println("Choose rock, paper, or scissors.");
        for (int i = 1; i <= games; i++) {
            String player;
            while (true) {
                System.out.print("Game " + i + " - Your choice: ");
                player = sc.next().toLowerCase();
                if (player.equals("rock") || player.equals("paper") || player.equals("scissors")) break;
                System.out.println("Invalid choice. Try again.");
            }
            String computer = getComputerChoice();
            String winner = findWinner(player, computer);
            if (winner.equals("Player")) playerWins++;
            else if (winner.equals("Computer")) computerWins++;
            else draws++;
            System.out.println("You: " + player + " | Computer: " + computer + " | Result: " + winner);
        }
        System.out.println("\nFinal statistics:");
        displayStats(createStats(playerWins, computerWins, draws, games));
        sc.close();
    }
}

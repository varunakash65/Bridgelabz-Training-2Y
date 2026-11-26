package src.String.Assignment.level3;

import java.util.Scanner;

public class Q10_ShuffleAndDistributeCards {
    public static String[] initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] deck = new String[suits.length * ranks.length];
        int index = 0;
        for (String suit : suits) {
            for (String rank : ranks) deck[index++] = rank + " of " + suit;
        }
        return deck;
    }

    public static String[] shuffleDeck(String[] deck) {
        for (int i = 0; i < deck.length; i++) {
            int randomCardNumber = i + (int) (Math.random() * (deck.length - i));
            String temporary = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temporary;
        }
        return deck;
    }

    public static String[][] distributeCards(String[] deck, int numberOfCards, int numberOfPlayers) {
        if (numberOfPlayers <= 0 || numberOfCards < 0 || numberOfCards > deck.length ||
                numberOfCards % numberOfPlayers != 0) {
            throw new IllegalArgumentException("Cards must be 0-52 and evenly divisible among positive players.");
        }
        int cardsPerPlayer = numberOfCards / numberOfPlayers;
        String[][] players = new String[numberOfPlayers][cardsPerPlayer];
        int cardIndex = 0;
        for (int card = 0; card < cardsPerPlayer; card++) {
            for (int player = 0; player < numberOfPlayers; player++) {
                players[player][card] = deck[cardIndex++];
            }
        }
        return players;
    }

    public static void printPlayers(String[][] players) {
        for (int i = 0; i < players.length; i++) {
            System.out.println("Player " + (i + 1) + ":");
            for (String card : players[i]) System.out.println("  " + card);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] deck = initializeDeck();
        shuffleDeck(deck);
        System.out.print("Enter number of cards to distribute (0-52): ");
        int numberOfCards = sc.nextInt();
        System.out.print("Enter number of players: ");
        int numberOfPlayers = sc.nextInt();
        try {
            String[][] players = distributeCards(deck, numberOfCards, numberOfPlayers);
            printPlayers(players);
        } catch (IllegalArgumentException ex) {
            System.out.println("Cannot distribute cards: " + ex.getMessage());
        }
        sc.close();
    }
}

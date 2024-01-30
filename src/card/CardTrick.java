package card;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * Modifier: [Your Name] [Your Student Number]
 * @author srinivsi
 */
public class CardTrick {

    public static void main(String[] args) {
        Card[] magicHand = new Card[7];
        Random random = new Random();

        // Map to keep track of the count of each suit
        Map<String, Integer> suitCount = new HashMap<>();

        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(random.nextInt(13) + 1); // Card values range from 1 to 13
            String suit = Card.SUITS[random.nextInt(4)]; // There are 4 suits
            c.setSuit(suit);
            magicHand[i] = c;

            // Update the suit count
            suitCount.put(suit, suitCount.getOrDefault(suit, 0) + 1);
        }

        // Display the count of each suit
        System.out.println("Count of each suit in the magic hand:");
        for (String suit : Card.SUITS) {
            System.out.println(suit + ": " + suitCount.getOrDefault(suit, 0));
        }

        // Ask the user for a card value and suit
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a card value (1-13): ");
        int value = scanner.nextInt();
        scanner.nextLine(); // consume the newline left-over
        System.out.println("Enter a suit (0-3 where 0=Hearts, 1=Diamonds, 2=Clubs, 3=Spades): ");
        int suitChoice = scanner.nextInt();
        String userSuit = Card.SUITS[suitChoice];

        // Create the user's card
        Card userCard = new Card();
        userCard.setValue(value);
        userCard.setSuit(userSuit);

        // Check if the user's card is in the magic hand
        boolean found = false;
        for (Card card : magicHand) {
            if (card.getValue() == userCard.getValue() && card.getSuit().equalsIgnoreCase(userCard.getSuit())) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Congratulations! Your card was in the magic hand.");
        } else {
            System.out.println("Sorry, your card was not in the magic hand.");
        }
    }
}

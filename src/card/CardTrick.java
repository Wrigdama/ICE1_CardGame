package card;

import java.util.Random;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then searches the array of cards for a hard-coded lucky card.
 * To be used as starting code in ICE 1
* Modifier: [Damani] [991683962]
 * @author srinivsi
 */
public class CardTrick {
    
    public static void main(String[] args) {
        Card[] magicHand = new Card[7];
        Random random = new Random();

        // Generate random cards for the magic hand
        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(random.nextInt(13) + 1); // Values 1-13
            c.setSuit(Card.SUITS[random.nextInt(Card.SUITS.length)]); // Random suit
            magicHand[i] = c;
        }

        // Hard-coded lucky card
        Card luckyCard = new Card();
        luckyCard.setValue(2); // Example: Value 2
        luckyCard.setSuit("Clubs"); // Example: Suit Clubs

        // Check if the lucky card is in the magic hand
        boolean found = false;
        for (Card card : magicHand) {
            if (card.getValue() == luckyCard.getValue() && card.getSuit().equalsIgnoreCase(luckyCard.getSuit())) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Congratulations! The lucky card was in the magic hand.");
        } else {
            System.out.println("Sorry, the lucky card was not in the magic hand.");
        }
    }
}

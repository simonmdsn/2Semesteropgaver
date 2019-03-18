package opg3_playingcards;

import static java.lang.Math.random;
import java.util.Arrays;

/**
 * VOP eksamen F2014
 * Kodeskelet til opgave 3c og 3d
 * @author erso
 */
public class DeckOfCards implements CardInterface {

    private Card[] deck;

    public DeckOfCards() {
        // Opg 3c. Initialiser deck, dan de 52 lovlige kort og saet dem i deck-arrayet
        deck = new Card[NUMBER_OF_CARDS];
        
        for (int suit = CLUBS; suit <= SPADES; suit++) {
            for (int face = ACE; face <= KING; face++) {
                deck[((suit - 1) * 13 + face) - 1] = new Card(face, suit);
            }
        }
    }
    

    // Faerdiskrevet metode til "paen" udskrift af kortbunken
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < deck.length; i++) {
            if (i != 0 && i % 4 == 0) {
                sb.append("\n");
            }
            sb.append(deck[i]);
            if (i != deck.length-1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public void shuffle(int swaps) {
        for(int i= 0; i<swaps;i++) {
            int card1 = (int)(Math.random()*NUMBER_OF_CARDS);
            int card2 = (int)(Math.random()*NUMBER_OF_CARDS);
            Card temp = deck[card1];
            deck[card1] = deck[card2];
            deck[card2] = temp;
        }
    }

   
    public static void main(String[] args) {
        
            // Til test af opg 3 c
            DeckOfCards deckOfCards = new DeckOfCards();
            System.out.println("Opg 3c:\n" + deckOfCards);
            
            // Til test af opg 3 d
            deckOfCards.shuffle(10000000);
            System.out.println("Opg 3d:\n" + deckOfCards);
        

    }

}

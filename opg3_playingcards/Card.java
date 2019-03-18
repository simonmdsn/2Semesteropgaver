package opg3_playingcards;

import java.util.HashSet;
import java.util.Set;

/**
 * VOP eksamen F2014
 * Tom klasse til opgave 3
 * @author erso
 */
public class Card implements CardInterface {
    
    private int face;
    private int suit;
    
    public Card(int face, int suit) {
        if (face >= ACE && face <= KING) {
            if (suit >= CLUBS && suit <= SPADES) {
                this.face = face;
                this.suit = suit;
            }
        } else {
            System.out.println("Ulovlgit kort: " + face + " " + suit);
        }
    }

    @Override
    public String toString() {
        String suitName = null;
        String faceName = Integer.toString(face);
            
        switch(suit) {
            case 1:
                suitName = CLUBS_NAME;
                break;
            case 2:
                suitName = DIAMONDS_NAME;
                break;
            case 3:
                suitName = HEARTS_NAME;
                break;
            case 4:
                suitName = SPADES_NAME;
                break;
        }
        switch(face) {
            case 1:
                faceName = ACE_NAME;
                break;
            case 11:
                faceName = JACK_NAME;
                break;
            case 12:
                faceName = QUEEN_NAME;
                break;
            case 13:
                faceName = KING_NAME;
                break;
        }

        if(faceName != null && suitName !=null) {
        return suitName+faceName;
        }
        return "";
    }
    
    
    public static void main(String[] args) {
        System.out.println(new Card(1, 3));
        System.out.println(new Card(3, 1));
        System.out.println(new Card(13, 4));
        System.out.println(new Card(12, 3));
        System.out.println(new Card(17, 5));
    }
}
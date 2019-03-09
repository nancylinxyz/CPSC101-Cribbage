/* Deck Class Behavoirs:
 * 
 * 
 * Mar 9, 2019 update: change Deck into CardCollection object
 *                     - createNewDeck() instead of using 2 for loops
 * 
 * @author dumonchel
 */
package cribproject;

import java.util.ArrayList;
import CribbageDeck.Cards.Suit;
import CribbageDeck.Cards.Value;
import java.util.Random;

public class Deck {

    //ArrayList<Cards> Deck = new ArrayList<Cards>();
    private int cardCounter = 51;
    private CardCollection deck;

    public Deck() {
        deck = new CardCollection();
        creatNewDeck();

    }
    
    //needs to become shuffle and take 1 card from the deck and put it into another player's card
    public void Deal(Player p)
    {
        p.addCard(deck.get(0));
        deck.removeCard(deck.get(0));
        /*Random card = new Random();
        if(cardCounter >= 0)
        {
            int nextCard = card.nextInt(cardCounter);
            cardCounter--;
            Cards newCard = Deck.get(nextCard);
            Deck.remove(nextCard);
            return newCard;
        }
        return null;*/
    }
    
    public void ResetDeck()
    {
        deck.clearCollection();
        creatNewDeck();
    }

    private void creatNewDeck(){
        for (Suit s : Suit.values()) {
            for (Value v : Value.values()) {
                deck.setHand(makeCard(s, v));
            }
        }
    }

    private Cards makeCard(Suit s, Value v) {
        Cards card = new Cards(s, v);
        return card;
    }
}

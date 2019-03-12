/* Deck Class Behavoirs:
 * 1.1 deal(Players): move 1 card from deck to to player's hand
 * 1.2 deal(Board): move 1 card from deck to the Board
 * 2. resetDeck(): 
 * 
 * Mar 9, 2019 update: change Deck into CardCollection object
 *                     - createNewDeck() instead of using 2 for loops
 * 
 * @author dumonchel
 */

import java.util.ArrayList;
import Cards.Suit;
import Cards.Value;
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
    public void deal(Players p)
    {
        p.setHand(deck.getCard(0));
        deck.removeCard(deck.getCard(0));
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

    //more a card from deck to the Board
    public void deal(Board b){
        b.setCutCard(deck.getCard(0));
    }
    
    public void ResetDeck()
    {
        deck.clearCollection();
        creatNewDeck();
    }

    
    private void creatNewDeck(){
        for (Suit s : Suit.values()) {
            for (Value v : Value.values()) {
                deck.addCard(makeCard(s, v));
            }
        }
        CardCollection.shuffleCards();
    }

    private Cards makeCard(Suit s, Value v) {
        Cards card = new Cards(s, v);
        return card;
    }


}

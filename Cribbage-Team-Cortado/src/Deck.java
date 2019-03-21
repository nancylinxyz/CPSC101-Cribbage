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



public class Deck {

    //ArrayList<Cards> Deck = new ArrayList<Cards>();
    //private int cardCounter = 51;
    private CardCollection deck;

    public Deck() {
        deck = new CardCollection();
        createNewDeck();

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
    
    public void resetDeck()
    {
        deck.clearCollection();
        createNewDeck();
    }

    
    private void createNewDeck(){
        for (Suit s : Suit.values()) {
            for (Value v : Value.values()) {
                Cards tempCard = new Cards(s, v);//why??
                deck.addCard(tempCard);
            }

        }
        deck.shuffleCards();
    }


}

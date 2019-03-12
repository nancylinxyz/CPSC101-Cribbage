/* Behaviors:
 * 1. getCut(): returns cut Card
 * 2. setCutCard(Card): add to CutCard
 * 3. removeCard(): clear all cards
 * 4. setScore(): add to currentPeggingScore
 * 5. resetScore(): 0 to the peggingScore
 * 6. setCurrentCards(Card): add a Card to
 *
 */

public class Board {
    
    private final int TOTAL_PEGS= 123;
    private Score currentPeggingScore;

    private CardCollection cutCard;
    private CardCollection currentCards;

    public Board(){
        currentPeggingScore = new Score();
        currentPeggingScore.addScore(0);

        cutCard = new CardCollection();
        currentCards = new CardCollection();
    }
    
    public Cards getCut(){
        return cutCard.getCard(0);
    }

    public void setCutCard(Cards a) {
        cutCard.addCard(a);

    }

    public void removeCards(){
        cutCard.clearCollection();
    }

    
     public void setScore(int s){

        currentPeggingScore.addScore(s);
     }

     public void resetScore(){
        currentPeggingScore.resetScore();
     }
     


     public void setCurrentCards(Cards c){
         currentCards.addCard(c);
     }
    
}
 
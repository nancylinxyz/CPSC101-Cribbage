/* Behaviors:
 * 1. getCut(): returns cut Card
 * 2. removeCut(): clear cutCard
 * 3. setScore(): add to currentPeggingScore
 * 4. resetScore(): 0 
 *
 * @author 
 */
import java.util.ArrayList;
public class Board {

    //remember that when play the card down, we need to add to currentCard!!!!
    
    private final int TOTAL_PEGS= 123;
    private Score currentPeggingScore;

    private CardCollection cutCard;
    private CardCollection currentCards;
     
    
    public Cards getCut(){
        return cutCard.getCard(0);
    }

    public void removeCut(){
        cutCard.clearCollection();
    }
    
   
     public Board(){
        currentPeggingScore = new Score();
        currentPeggingScore.addScore(0);

        cutCard = new CardCollection();
        currentCards = new CardCollection();
     }

     
    
     public void setScore(int s){

        currentPeggingScore.addScore(s);
     }

     public void resetScore(){
        currentPeggingScore.resetScore();
     }
     
     public void setCutCard(Cards a){
         cutCard.addCard(a);
         
     }

     public void setCurrentCards(Cards c){
         currentCards.addCard(c);
     }

     // remove all the cards from currentCard??
     public void resetCurrentCards(){

         currentCards.clearCollection();
         
      }
    
}
 
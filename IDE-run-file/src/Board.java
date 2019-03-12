/* Behaviors:
 * 
 * 
 *
 * @author 
 */
import java.util.ArrayList;
public class Board {

    //remember that when play the card down, we need to add to currentCard!!!!
    
    private final int totalPegs= 121;
    private Score curretPeggingScore;

    private CardCollection cutCard;
    private CardCollection currentCards;
     
    
    public Cards getCut(){
        return cutCard.getCard(0);
    }
    
   
     public Board(){
        currentPeggingScore = 0;

        cutCard = new CardCollection();
        currentCards = new CardCollection();
     }
     
     //set score to display only
     public int getP1Score(){
         return score;
     }
     
    
     public void setScore(int s){
         score = s+ score;
     }
     
     public void setCutCard(Cards a){
         cutCard.addCard(a);
         
     }

     public void setCurrentCards(Cards c){
         currentCards.addCard(c);
     }
     // remove all the cards from currentCard??
         public void resetCurrentCards(){
         for(Cards card: currentCards)
         currentCards.remove(card);
         
         }   
    
}
 
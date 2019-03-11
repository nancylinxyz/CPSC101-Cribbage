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
    private int player1Score;
    private int player2Score;
    private int curretPeggingScore;

    private CardCollection cutCard;
    private CardCollection currentCards;
    
    
    public Cards getCut(){
        return cutCard.getCard(0);
    }
    
   
     public Board(){
        player1Score = 0;
        player2Score = 0;
        currentPeggingScore = 0;

        cutCard = new CardCollection;
        currentCards = new CardCollection;
     }
     
     //set score to display only
     public int getP1Score(){
         return score;
     }
     
    
     public void setScore(int s){
         score = s+ score;
     }
     
     public void setCutCard(Card a){
   
         currentCards.addCard(a);
         
     }
     // remove all the cards from currentCard??
         public void resetCurrentCards(){
         for(Card card: currentCards)
         currentCards.remove(card);
         
         }   
    
}
 
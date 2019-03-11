/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 *
 * @author mac
 */
import java.util.ArrayList;
public class Board {

    //remember that when play the card down, we need to add to currentCard!!!!
    
    private final int totalPegs= 121;
    private int score;
    //need player1 score, player2 score, CardCollecion for currentcards
    private static ArrayList<Card>currentCards;//need a Card class
    
    private static Card cutCard;// need a card class
    
    //what is this method for>??
    public Card getCut(){
    }
    
   
     public Board(){
         score=0;
         currentCards= new ArrayList<Card>();
     }
     
     public int getScore(){
         return score;
     }
     
     public void setScore(int s){
         score = s+ score;
     }
     
     public void setCutCard(Card a){
         cutCard= a;
         currentCards.add(a);
         
     }
     // remove all the cards from currentCard??
         public void resetCurrentCards(){
         for(Card card: currentCards)
         currentCards.remove(card);
         
         }   
    
}
 
/* Each players have 4 behavoirs:
 * 1. setHand(Card): add 1 card to the player's hand
 * 2. playHand(Card): remove 1 card from the player's hand and add it to the player's PlayedHand & onto the Board
 * 3. discardToCrib(Card): moves 1 card from the player's hand to crib
 * 4. return Card decidedCard(); returns a card
 * 
 * @co-authors: Shen & Nancy Lin
 */
package cribproject;

import java.util.ArrayList;
import java.util.Random;

abstract class Player {
	
	public Player(){
		CardCollection hand = new CardCollection();
		CardCollection playedHand = new CardCollection();
		CardCollection crib = new CardCollection();
	}
	
	public void setHand(Card c){
		hand.add(c);		//To add the cards to hand arraylist
	}

	public void playHand(Card c){
		hand.remove(c);
		playedHand.add(c);
		Board.playedCards.add(c);
	}

	public void discardToCrib(Card c){
		hand.remove(c);
		crib.add(c);
	}

	abstract Card decideCard(){

	}
	
	
}
/* Each players have 4 behavoirs:
 * 1. setHand(Card): add 1 card to the player's hand
 * 2.1 playHand(Card): remove 1 card from the player's hand and add it to the player's PlayedHand & onto the Board
 * 2.2 Cards playHand(int): return the value of the card for drawing
 * 3. discardToCrib(Card): moves 1 card from the player's hand to crib
 * 4. return Card decidedCard(); returns a card
 * 5. setScore(int)
 * 6. getScore(int)
 * 7. emptyHand(): clear player hand => for drawing
 * 
 * @co-authors: Shen & Nancy Lin
 */

import java.util.Random;

abstract class Players {
	private CardCollection hand;
	private CardCollection playedHand;
	private CardCollection crib;
	private int score;

	public Players(){
		hand = new CardCollection();
		playedHand = new CardCollection();
		crib = new CardCollection();
	}
	
	public void setHand(Card c){
		hand.addCard(c);	
	}

	public void playHand(Card c){
		hand.remove(c);
		playedHand.add(c);
		Board.playedCards.add(c);
	}

	public Cards playHand(int i){
		return hand.getCard(i);
	}

	public void discardToCrib(Card c){
		hand.remove(c);
		crib.add(c);
	}

	abstract Card decideCard(){
	}
	
	public void setScore(int i){
		score = i;
	}

	public int getScore(){
		return score;
	}

	public void emptyHand(){
		hand.clearCollection();
	}
	
}
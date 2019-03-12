/* Each players have 4 behavoirs:
 * 1. setHand(Card): add 1 card to the player's hand
 * 2.1 playHand(Card, Board): remove 1 card from the player's hand and add it to the player's PlayedHand & onto the Board
 * 2.2 Cards playHand(int): return the value of the card for drawing
 * 3. discardToCrib(Card): moves 1 card from the player's hand to crib, add to board also
 * 4. return Card decidedCard(); returns a card
 * 5. setScore(int)
 * 6. getScore(int)
 * 7. emptyHand(): clear player hand => for drawing
 * 8. getCardNumber(): get the number of cards left in a player's hand
 * 
 * @co-authors: Shen & Nancy Lin
 */

import java.util.Random;

abstract class Players {
	private CardCollection hand;
	private CardCollection playedHand;
	private CardCollection crib;
	private Score myScore;

	public Players(){
		hand = new CardCollection();
		playedHand = new CardCollection();
		crib = new CardCollection();
		myScore = new Score();
	}
	
	public void setHand(Cards c){
		hand.addCard(c);	
	}

	public void playHand(Cards c, Board b){
		hand.removeCard(c);
		playedHand.addCard(c);
		b.setCurrentCards(c);
	}

	/*public Cards playHand(int i){
		return hand.getCard(i);
	}*/

	public void discardToCrib(Cards c){
		crib.addCard(c);
		//b.setCurrentCards(c);
		hand.removeCard(c);
	}

	abstract Cards decideCard();
	
	//add ontop of old score
	public void setScore(int i){
		myScore.addScore(i);
		//TO-DO: check winner
	}

	public int getScore(){
		return myScore.getScore();
	}

	//use in GameSquence.drawing()
	public void emptyHand(){
		hand.clearCollection();
	}

	public int getCardNumber(){
		return hand.collectionSize();
	}
	
}
/* Each players have 4 behavoirs:
 * 1. setHand(Card): add 1 card to the player's hand
 * 2.1 playHand(Card): remove 1 card from the player's hand and add it to the player's PlayedHand & onto the Board
 * 2.2 Cards playHand(int): return the value of the card for drawing
 * 3. discardToCrib(Card, Board): moves 1 card from the player's hand to crib, add to board also
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
	private Score myScore;

	public Players(){
		hand = new CardCollection();
		playedHand = new CardCollection();
		crib = new CardCollection();
		myScore = new Score();
	}
	
	public void setHand(Card c){
		hand.addCard(c);	
	}

	public void playHand(Card c){
		hand.remove(c);
		playedHand.add(c);
		Board.playedCards.add(c);
	}

	/*public Cards playHand(int i){
		return hand.getCard(i);
	}*/

	public void discardToCrib(Card c, Board b){
		crib.add(c);
		b.setCurrentCards(c);
		hand.remove(c);
	}

	abstract Card decideCard(){
	}
	
	public void setScore(int i){
		myscore.addScore(i);
		//TO-DO: check winner
	}

	public int getScore(){
		return myscore.getScore();
	}

	//use in GameSquence.drawing()
	public void emptyHand(){
		hand.clearCollection();
	}

	public int getCardNumber(){
		return hand.collectionSize();
	}
	
}
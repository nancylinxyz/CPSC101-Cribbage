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
	private Board board;
	private int[] yPosition = new int[2];

	public Players(Board board){
		hand = new CardCollection();
		playedHand = new CardCollection();
		crib = new CardCollection();
		myScore = new Score();
		this.board = board;
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

		yPosition[0] = yPosition[1];
		yPosition[1]= myScore.getScore() + 1; //only add 1 instead of 2 b/c index start with 0


	}

	public int getScore(){
		return myScore.getScore();
	}

	//use in GameSquence.drawing()
	public void emptyHand(){
		hand.clearCollection();
	}

	public int getCardNumber(){
		return hand.size();
	}

	public CardCollection getHand(){
		return hand;
	}

	public CardCollection getPlayedHand(){
		return playedHand;
	}

	public CardCollection getCrib(){
		return crib;
	}

	public Board getBoard(){
		return board;
	}

	//for graphics
	public int getPosition(int i){
		return yPosition[i];
	}
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cribproject;

/**
 *
 * @author mac
 */
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
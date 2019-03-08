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

public class Players {
	private static boolean isDealer;
	private ArrayList<Cards> hand;
	
	private ArrayList<Cards> crib;
	
	private ArrayList<Cards> playedHand;
	
	public void setHand(){
		ArrayList<Cards> hand = new ArrayList<Cards>();
		hand.add(Cards);		//To add the cards to hand arraylist
	}

	public void playHand(){
		ArrayList<Cards> playedHand = new ArrayList<Cards>();
		Random i = new Random();
		int n = 1 + i.nextInt(5);
		String Card = playedHand.get(i);		// To get an element
	}

	public void discardToCrib(){
		ArrayList<Cards> crib = new ArrayList<Cards>();
	
	}

	public void setDealer(){
		 isDealer = true;
		
	}
	public void emptyHand(){
		int i = 0;
		for (String Cards : hand){
		}	
			hand.set(i, 0);
			i++;
	}
	
	
}
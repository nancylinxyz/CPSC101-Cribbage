/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CribbageDeck;

import java.util.ArrayList;
import CribbageDeck.Cards.Suit;
import CribbageDeck.Cards.Value;
import java.util.Random;

/**
 *
 * @author dumonchel
 */
public class Deck {

    ArrayList<Cards> Deck = new ArrayList<Cards>();
    private int cardCounter = 51;

    public Deck() {

        for (Suit s : Suit.values()) {
            for (Value v : Value.values()) {
                Deck.add(makeCard(s, v));
            }
        }
    }

    public Cards makeCard(Suit s, Value v) {
        Cards card = new Cards(s, v);
        return card;
    }
    
    public Cards Deal()
    {
        Random card = new Random();
        if(cardCounter >= 0)
        {
            int nextCard = card.nextInt(cardCounter);
            cardCounter--;
            Cards newCard = Deck.get(nextCard);
            Deck.remove(nextCard);
            return newCard;
        }
        return null;
    }
    
    public void ResetDeck()
    {
        Deck.clear();
        for (Suit s : Suit.values()) {
            for (Value v : Value.values()) {
                Deck.add(makeCard(s, v));
            }
        }
    }
}

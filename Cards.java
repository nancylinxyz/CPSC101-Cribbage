/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CribbageDeck;
import java.util.Scanner;
/**
 *
 * @author dumonchel
 */
public class Cards {

    enum Suit {
        Spades, Hearts, Diamonds, Clubs
    }

    enum Value {
        Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King
    }
    private Suit suit;
    private Value value;

    public Cards(Suit s, Value v) {
        suit = s;
        value = v;
    }

    public Suit getSuit() {
        return suit;
    }

    public Value getValue() {
        return value;
    }
    
    public int cardCompare(Cards compCard)
    {
        if(this.valueFinder() < compCard.valueFinder())
            return 1;
        else if(this.valueFinder() > compCard.valueFinder())
            return 2;
        return 3;
    }
    
    public int valueFinder()
    {
        if(value == Value.Ace)
        {
            Scanner aceFinder = new Scanner(System.in);
            System.out.println("Will this equal 1 or 11?");
            int aceValue = aceFinder.nextInt();
            if(aceValue == 11)
                aceValue = 14;
            return aceValue;
        }
        else if(value == Value.Two)
            return 2;
        else if(value == Value.Three)
            return 3;
        else if(value == Value.Four)
            return 4;
        else if(value == Value.Five)
            return 5;
        else if(value == Value.Six)
            return 6;
        else if(value == Value.Seven)
            return 7;
        else if(value == Value.Eight)
            return 8;
        else if(value == Value.Nine)
            return 9;
        else if(value == Value.Ten)
            return 10;
        else if(value == Value.Jack)
            return 11;
        else if(value == Value.Queen)
            return 12;
        else if(value == Value.King)
            return 13;
        return 0;
    }
    
    public int cardValue()
    {
        if(value == Value.Ace)
        {
            Scanner aceFinder = new Scanner(System.in);
            System.out.println("Will this equal 1 or 11?");
            int aceValue = aceFinder.nextInt();
            if(aceValue == 11)
                aceValue = 14;
            return aceValue;
        }
        else if(value == Value.Two)
            return 2;
        else if(value == Value.Three)
            return 3;
        else if(value == Value.Four)
            return 4;
        else if(value == Value.Five)
            return 5;
        else if(value == Value.Six)
            return 6;
        else if(value == Value.Seven)
            return 7;
        else if(value == Value.Eight)
            return 8;
        else if(value == Value.Nine)
            return 9;
        else if(value == Value.Ten)
            return 10;
        else if(value == Value.Jack)
            return 10;
        else if(value == Value.Queen)
            return 10;
        else if(value == Value.King)
            return 10;
        return 0;
    }
    
    public String toString()
    {
        String cardName = getValue() + " of " + getSuit();
        return cardName;
    }
}

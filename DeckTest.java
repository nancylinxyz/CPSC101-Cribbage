/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cribproject;

/**
 *
 * @author dumonchel
 */
public class DeckTest {
    public static void main(String[] args)
    {
        Deck ndeck = new Deck();
        Cards card = ndeck.Deal();
        System.out.println(card.toString());
        Cards alsoCard = ndeck.Deal();
        System.out.println(alsoCard.toString());
        System.out.println(card.cardCompare(alsoCard));
    }
}

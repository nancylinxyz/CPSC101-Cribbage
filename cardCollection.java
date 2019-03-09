package cribproject;

import java.util.ArrayList;
import cribproject.Cards;

/* All of the list of cards are CardCollection objects.
 * 3 behavoirs:
 * 1. addCard(Cards)
 * 2. removeCard(Cards)
 * 3. clearCollection()
 *
 * @author Nancy Lin
 */
public class cardCollection {
    private ArrayList<Cards> collection;
        
    public cardCollection(){    
    }
    
    public void addCard(Cards c){
        collection.add(c);
    }
    
    public void removeCard(Cards c){
        collection.remove(c);
        
    }

    public void removeNextCard(){
        collection.remove(0);
    }
    
    public void clearCollection(){
        
        for(Cards card : collection){
        collection.remove(card);
        }
}
}

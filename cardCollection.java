package cribproject;

import java.util.ArrayList;
import cribproject.Cards;

/**
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
    
    public void clearCollection(){
        
        for(Cards card : collection){
        collection.remove(card);
        }
}
}

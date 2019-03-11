import java.util.ArrayList;

/* All of the list of cards are CardCollection objects.
 * 3 behavoirs:
 * 1. addCard(Cards)
 * 2. removeCard(Cards)
 * 3. getCard(int): returns i-th card of the collection
 * 4. clearCollection()
 * 5. shuffleCards();
 *
 * @author Nancy Lin
 */
public class CardCollection {
    private ArrayList<Cards> collection;
        
    public CardCollection(){    
    }
    
    public void addCard(Cards c){
        collection.add(c);
    }
    
    public void removeCard(Cards c){
        collection.remove(c);
        
    }

    public Cards getCard(int i){

        if (i <= collection.size()){
            return collection.get(i);
        }
        //error message
    }
    
    public void clearCollection(){
        
        for(Cards card : collection){
        collection.remove(card);
        }

    public void shuffleCards(){
        Collections.shuffle(collection);
    }

    public int collectionSize(){
        return collection.size();
    }
}

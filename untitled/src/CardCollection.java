import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* All of the list of cards are CardCollection objects.
 * 3 behavoirs:
 * 1. addCard(Cards)
 * 2. removeCard(Cards)
 * 3. getCard(int): returns i-th card of the collection
 * 4. clearCollection()
 * 5. shuffleCards();
 * 6. int collectionSize(): return the size of the ArrayList
 *
 * @author Nancy Lin
 */
public class CardCollection {
    private ArrayList<Cards> collection;
        
    public CardCollection(){
        collection = new ArrayList<>();
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
        return null;
    }
    
    public void clearCollection() {

        for (Cards card : collection) {
            collection.remove(card);
        }
    }

    public void shuffleCards(){
        Collections.shuffle(collection);
    }

    public int size(){

        return collection.size();
    }

    public void mergeCollection(CardCollection a){

        collection.add(a.getCard(0));
        collection.add(a.getCard(1));

    }

}
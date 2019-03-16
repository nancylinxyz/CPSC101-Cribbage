import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
//
//    public void sortCollection(){
//        Collections.sort(collection, new Comparator<Cards>(){
//            public int compare(Cards c1, Cards c2){
//                return c1.valueFinder().compareTo(c2.valueFinder());
//            }
//
//        });
//    }

    public void sortArray() {
        int i, j;
        Cards tempCard;
        for ( i = 0; i < collection.size(); i++)
        {
            for (j = i; j > 0; j--)
            {
                if (collection.get(j).valueFinder() < collection.get(j -1).valueFinder())
                {
                    tempCard = collection.get(j);

                    collection.set(j, this.getCard(j-1));
                    collection.set(j-1,tempCard);
                }
            }
        }

    }
}

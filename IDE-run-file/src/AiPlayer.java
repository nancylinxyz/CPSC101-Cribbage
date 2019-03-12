/* need fixes: canPlay(), onePlayableCard()
 *
 */

public class AiPlayer extends Players{
    //constructor
    public AiPlayer(){
        super();
    }

    @Override
    public Cards decideCard(){
        if (canPlay()){
            return onePlayableCard();
        } else{
            //say Go (method)
            return null;
        }
    }

    private boolean canPlay(){
        //compares Board.peggingScore with all of the cards on the player's hand 
        //to see if there is at least 1 card that is playable
        for (Cards i: hand){
            if (Board.peggingScore()+ Cards.valueFinder(i) <= 31){
                return true;
            }
        }
        return false;
    }

    private Cards onePlayableCard(){
        //compare against all of the cards in hand and pick 1 that is playable
        for (Cards i: hand){
            if (Board.peggingScore()+ Cards.valueFinder(i) <= 31){
                return i;
            }
        }
    }

    




    
}
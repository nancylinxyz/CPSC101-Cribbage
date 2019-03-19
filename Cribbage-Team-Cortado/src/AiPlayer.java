/* need fixes: canPlay(), onePlayableCard()
 *
 */

public class AiPlayer extends Players{
    //constructor

    public AiPlayer(Board board){
        super(board);

    }

    @Override
    public Cards decideCard(){

        return onePlayableCard();
    }

    private boolean canPlay(){
        //compares Board.peggingScore with all of the cards on the player's hand 
        //to see if there is at least 1 card that is playable
        for (int i = 0; i < super.getHand().size(); i++){
            if (super.getHand().getCard(i).cardValue() + getBoard().getScore() <= 31 ){
                //System.out.println("Can't play this card, choose another card");
                return true;
            }
        }
        return false;
//
    }

    private Cards onePlayableCard(){
        //compare against all of the cards in hand and pick 1 that is playable

        for (int i = 0; i <super.getHand().size(); i++){
            if (super.getHand().getCard(i).valueFinder() +super.getBoard().getScore() <= 31){
                return super.getHand().getCard(i);
            }
        }
        return null;
    }

    




    
}
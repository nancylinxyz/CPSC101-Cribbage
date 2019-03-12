/* TO-DO: Declare winner in isWinner()
 * TO-DO: display GO in canPeg()
 * @author Son
 */



public class Referee {
    Players playerHuman;
    Players playerAi;
    GameSquence game;


    public Referee(){
        playerHuman = new HumanPlayer();
        playerAi = new  AiPlayer();
        game = new GameSquence(playerHuman, playerAi);
    }

    public void start(){
        game.setRef(this);
        game.round();
    }


    //pegging can they play?
    public boolean canPeg(Cards a, Board b){
        if ((a.valueFinder() + b.getScore()) <= 31) {
            return true;
        } else{
            //display Go
            return false;
        }
    }

    public boolean isWinner(Players p){

        if (p.getScore()<121){
            return false;
        } else{
            //display winner
            return true;
        }

    }
    
    

   
    
}

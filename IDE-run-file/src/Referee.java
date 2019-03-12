/*
 *
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
        game.round();
    }


    //pegging can they play?
    public boolean canPlay(Cards a, Board b){
        if ((a.valueFinder() + b.getScore()) <= 31) {
            return true;
        } else return false;
    }

    public boolean isWinner(Score s){
        //TO-DO: whether game ended or not
        return true;
    }
    
    

   
    
}

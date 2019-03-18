/* TO-DO: need to add player.resetScore() when reset game. or just create new game when hit reset.
 *
 */

import java.util.ArrayList;

public class GameSquence{
    
    //change pointer assignment when order changes
    private Players dealer;
    private Players prone;
    private ArrayList<Players> playerList = new ArrayList<>();
    private Deck deck;
    private Board board;
    private boolean isDealer0; //isHamanPlayer dealer?
    private Referee ref;
    private Scorer scorer;
    //private TrackComponent track;

    //constructor with 2 players as input
    public GameSquence(Players player1, Players player2, Board board){
        playerList.add(player1);
        playerList.add(player2);
        deck = new Deck();
        this.board = board;
        scorer = new Scorer(board);
        //this.track = ref.getTrack();
        GameFrame.outPutToGameLog("Welcome to a new game!");
    }

    public void round(){
        drawing();

        while (dealer.getScore() < 121 && prone.getScore() <121){
            dealHands();
            toCrib();
            drawCutCard();
            pegging();
            countHand();
            changeDealer();
        }
    }

    public void setRef(Referee r){
        ref = r;
    }

    //each player draw 1 card each, compare and set dealer
    private void drawing(){

        GameFrame.outPutToGameLog("We will draw to determine who will be the dealer first.");
        eachDraw();
        playerList.get(0).getHand().clearCollection();
        playerList.get(1).getHand().clearCollection();
        deck.resetDeck();
        updateAllTextDisplay();
    }

    //goes through 1 round of drawing and comparison
    private void eachDraw(){
        deck.deal(playerList.get(0));
        GameFrame.outPutToGameLog("You drew: " + playerList.get(0).getHand().getCard(0).getValue() + " of " +playerList.get(0).getHand().getCard(0).getSuit() );
        deck.deal(playerList.get(1));
        GameFrame.outPutToGameLog("Player 2 drew: " + playerList.get(1).getHand().getCard(0).getValue() + " of " +playerList.get(0).getHand().getCard(0).getSuit() );
    
        if (playerList.get(0).getHand().getCard(0).valueFinder() < playerList.get(1).getHand().getCard(0).valueFinder()){
            dealer = playerList.get(0);
            prone = playerList.get(1);
            //pass on player status
            isDealer0 = true;
            GameFrame.outPutToGameLog("You are the dealer" );
        } else if(playerList.get(0).getHand().getCard(0).valueFinder() > playerList.get(1).getHand().getCard(0).valueFinder() ) {
            dealer = playerList.get(1);
            prone = playerList.get(0);
            isDealer0 = false;
            GameFrame.outPutToGameLog("Player 2 is the dealer" );
        } else {

            GameFrame.outPutToGameLog("There is a tie, we will draw again.");
            eachDraw();
        }
    }

    //deal 6 cards to each players
    private void dealHands() {
        for (int i = 0; i < 6; i++) {
            GameFrame.outPutToGameLog("Deal card "+ (i+1) + " to Prone" );
            deck.deal(prone);
            GameFrame.outPutToGameLog("Deal card "+ (i+1) + " to Dealer" );
            deck.deal(dealer);
        }
        GameFrame.setPlayer1Hand(playerList.get(0).getHand());
        updateAllTextDisplay();
        GameFrame.setPlayer2Hand(playerList.get(1).getHand());
    }

    //allow each player to discard 2 cards to crib
    private void toCrib(){
        GameFrame.outPutToGameLog("Each player discard 2 cards to Crib." );
        for (int i = 0; i < 2; i++){
            GameFrame.outPutToGameLog("Prone's turn to discard 1 card to Crib." );
            prone.discardToCrib(prone.decideCard());
            GameFrame.outPutToGameLog("Prone's has discard 1 card to Crib." );
            GameFrame.outPutToGameLog("Dealer's turn to discard 1 card to Crib." );
            dealer.discardToCrib(dealer.decideCard());
            GameFrame.outPutToGameLog("Dealer's has discard 1 card to Crib." );
            updateAllTextDisplay();
        }
    }

    //draw and set Cut Card
    private void drawCutCard(){
        GameFrame.outPutToGameLog("Draw the Cut Card." );
        deck.deal(board);
        GameFrame.outPutToGameLog("Cut Card is: " + board.getCut());
        if (board.getCut().valueFinder() == 11){
            prone.setScore(2);
            updateAllTextDisplay();
            ref.isWinner(prone);
        }

    }
    

    private void pegging(){
        while (dealer.getCardNumber()>0 || prone.getCardNumber()>0){
            //whether prone can play

            while (board.getScore()<31) {
                if (ref.canPeg(prone)) {
                    Cards tempCard1 = prone.decideCard();
                    if (ref.canPlayCard(tempCard1)) {
                        prone.playHand(tempCard1, board);

                        //pegging score
                        prone.setScore(scorer.peggingScore(tempCard1));
                        updateAllTextDisplay();
                        ref.isWinner(prone);
                    }
                }

                //whether dealer can play
                if (ref.canPeg(dealer)) {
                    Cards tempCard2 = dealer.decideCard();
                    if (ref.canPlayCard(tempCard2)) {
                        dealer.playHand(tempCard2, board);

                        //TO-Do: pegging score
                        prone.setScore(scorer.peggingScore(tempCard2));
                        updateAllTextDisplay();
                        ref.isWinner(dealer);
                    }
                }
            }
            scorer.resetPeggingScore();
            board.resetScore();
            board.removeCards();
        }

    }

    private void countHand(){
        //count hand for prone.hand, dealer.hand (need a return CardCollection)
        
        prone.setScore(scorer.countHand(prone.getHand(), board.getCut(), false));
        updateAllTextDisplay();
        ref.isWinner(prone);
        dealer.setScore(scorer.countHand(dealer.getHand(), board.getCut(), false));
        updateAllTextDisplay();
        ref.isWinner(dealer);

        //count crib
        dealer.getCrib().mergeCollection(prone.getCrib());
        dealer.setScore(scorer.countHand(dealer.getCrib(),board.getCut(), true));
        updateAllTextDisplay();
        ref.isWinner(dealer);
    }




    //changeDealer only works for 2 players
    private void changeDealer(){
        if (isDealer0){
            dealer = playerList.get(1);
            prone = playerList.get(0);
            isDealer0 = false;
        } else {
            dealer = playerList.get(0);
            prone = playerList.get(1);
            isDealer0 = true;
        }
        updateAllTextDisplay();
    }

    //update the display
    private void updateAllTextDisplay(){
        GameFrame.setPlayer1isDealer(isDealer0);
        GameFrame.setPlayer2isDealer(isDealer0);
        GameFrame.setPlayer1ScoreDisplay(playerList.get(0).getScore());
        GameFrame.setPlayer2ScoreDisplay(playerList.get(1).getScore());
        GameFrame.setPlayer2HandSize(playerList.get(1).getCardNumber());
    }

}
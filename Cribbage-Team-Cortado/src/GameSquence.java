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
//    private TrackComponent track;
    private GameFrame gameFrame;
    private boolean isCountHand = false;

    //constructor with 2 players as input
    public GameSquence(Players player1, Players player2, Board board){
        playerList.add(player1);
        playerList.add(player2);
        deck = new Deck();
        this.board = board;
        scorer = new Scorer(board);
//        this.track = ref.getTrack();

        GameFrame.outPutToGameLog("Welcome to a new game!");
    }

    public void round(){
        this.gameFrame = ref.getGameFrame();
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
            GameFrame.outPutToGameLog("You are the Dealer" );
        } else if(playerList.get(0).getHand().getCard(0).valueFinder() > playerList.get(1).getHand().getCard(0).valueFinder() ) {
            dealer = playerList.get(1);
            prone = playerList.get(0);
            isDealer0 = false;
            GameFrame.outPutToGameLog("Player 2 is the Dealer" );
        } else {

            GameFrame.outPutToGameLog("There is a tie, we will draw again.");
            playerList.get(0).getHand().clearCollection();
            playerList.get(1).getHand().clearCollection();
            deck.resetDeck();
            eachDraw();
        }
    }

    //deal 6 cards to each players
    private void dealHands() {
        GameFrame.outPutToGameLog("Dealing" );
        deck.resetDeck();
        for (int i = 0; i < 6; i++) {
            GameFrame.outPutToGameLog("Deal card "+ (i+1) + " to Pone" );
            deck.deal(prone);
            GameFrame.outPutToGameLog("Deal card "+ (i+1) + " to Dealer" );
            deck.deal(dealer);
        }
        updateAllTextDisplay();
        GameFrame.setPlayer2Hand(playerList.get(1).getHand(), playerList.get(1));
        updateAllTextDisplay();
    }

    //allow each player to discard 2 cards to crib
    private void toCrib(){
        GameFrame.outPutToGameLog("Instruction: Each player discard 2 cards to Crib." );
        for (int i = 0; i < 2; i++){
            GameFrame.outPutToGameLog("Pone's turn to discard 1 card to Crib." );
            prone.discardToCrib(prone.decideCard());
            GameFrame.outPutToGameLog("Pone's has discard 1 card to Crib." );
            updateAllTextDisplay();
            GameFrame.outPutToGameLog("Dealer's turn to discard 1 card to Crib." );
            dealer.discardToCrib(dealer.decideCard());
            GameFrame.outPutToGameLog("Dealer's has discard 1 card to Crib." );

            updateAllTextDisplay();
        }
        //merge crib into player1's hand for count and display
        playerList.get(0).getCrib().mergeCollection(playerList.get(1).getCrib());
        playerList.get(1).getCrib().clearCollection();
        updateAllTextDisplay();
    }

    //draw and set Cut Card
    private void drawCutCard(){
        GameFrame.outPutToGameLog("Draw the Cut Card." );
        deck.deal(board);
        GameFrame.outPutToGameLog("Cut Card is: " + board.getCut());
        if (board.getCut().valueFinder() == 11){
            prone.setScore(2);
            GameFrame.outPutToGameLog("Pone scores 2 points." );
            updateAllTextDisplay();
            ref.isWinner(prone);
        }
        updateAllTextDisplay();
    }
    

    private void pegging(){
        GameFrame.outPutToGameLog("Start pegging: play 1 card at a time." );
        boolean isDealerPegScore = false;//for last card score
        while (dealer.getCardNumber()>0 || prone.getCardNumber()>0){
            dealer.setGo(false);
            prone.setGo(false);

            //whether prone can play
            while (board.getScore()<31) {
                if (ref.canPeg(prone)) {
                    GameFrame.outPutToGameLog("Pone's turn to play 1 card." );
                    Cards tempCard1 = prone.decideCard();
                    if (ref.canPlayCard(tempCard1)) {
                        prone.playHand(tempCard1, board);
                        GameFrame.outPutToGameLog("Pone has played a card." );
                        updateAllTextDisplay();
                        //pegging score
                        prone.setScore(scorer.peggingScore(tempCard1));
                        if (board.getScore()== 15 || board.getScore() ==31){
                            prone.setScore(2);
                        }
                        updateAllTextDisplay();
                        ref.isWinner(prone);
                    } else GameFrame.outPutToGameLog("You can't play that card." );
                } else {
                    if (dealer.getGo()){
                        isDealerPegScore = true;
                        prone.setGo(true);
                        GameFrame.outPutToGameLog("Pone has said 'Go'" );
                    }
                    isDealerPegScore = false;
                    prone.setGo(true);
                    GameFrame.outPutToGameLog("Pone has said 'Go'" );
                }

                //whether dealer can play
                if (ref.canPeg(dealer)) {
                    GameFrame.outPutToGameLog("Dealer's turn to play 1 card." );
                    updateAllTextDisplay();
                    Cards tempCard2 = dealer.decideCard();
                    if (ref.canPlayCard(tempCard2)) {
                        dealer.playHand(tempCard2, board);
                        GameFrame.outPutToGameLog("Dealer has played a card." );
                        //TO-Do: pegging score
                        prone.setScore(scorer.peggingScore(tempCard2));
                        if (board.getScore()== 15 || board.getScore() ==31){
                            dealer.setScore(2);
                        }
                        updateAllTextDisplay();
                        ref.isWinner(dealer);
                    } else GameFrame.outPutToGameLog("You can't play that card." );
                } else {
                    dealer.setGo(true);
                    GameFrame.outPutToGameLog("Dealer has said 'Go'" );
                }

                if (dealer.getGo() && prone.getGo()){
                    if (isDealerPegScore){
                        dealer.setScore(1);
                        GameFrame.outPutToGameLog("Dealer scored last card point." );
                    } else {
                        prone.setScore(1);
                        GameFrame.outPutToGameLog("Dealer scored last card point." );
                    }
                    scorer.resetPeggingScore();
                    board.resetScore();
                    board.removeCards();
                    updateAllTextDisplay();
                    isDealerPegScore = false;
                    //System.out.println("stuck here 6");
                    break;
                }
            }
//            System.out.println("stuck here 2");
            scorer.resetPeggingScore();
            board.resetScore();
            board.removeCards();
            updateAllTextDisplay();
        }

    }

    private void countHand(){
        //count hand for prone.hand, dealer.hand (need a return CardCollection)
        isCountHand = true;
        GameFrame.outPutToGameLog("Count Pone's hand." );
       // System.out.println(prone.getPlayedHand().getCard(3));
        //System.out.println(board.getCut());
        prone.setScore(scorer.countHand(prone.getPlayedHand(), board.getCut(), false));
        updateAllTextDisplay();
        ref.isWinner(prone);
        GameFrame.outPutToGameLog("Count Dealer's hand." );
        dealer.setScore(scorer.countHand(dealer.getPlayedHand(), board.getCut(), false));
        updateAllTextDisplay();
        ref.isWinner(dealer);

        //count crib
        GameFrame.outPutToGameLog("Count Crib." );
        //System.out.println(dealer.getCrib().getCard(1));
        updateAllTextDisplay();

        dealer.setScore(scorer.countHand(playerList.get(0).getCrib(),board.getCut(), true));
        isCountHand = false;
        updateAllTextDisplay();
        ref.isWinner(dealer);
        board.removeCutCard();
        playerList.get(0).emptyCrib();
        playerList.get(1).emptyCrib();
        updateAllTextDisplay();
        //System.out.println(playerList.get(0).getCrib().size() +playerList.get(1).getCrib().size());
    }




    //changeDealer only works for 2 players
    private void changeDealer(){

        GameFrame.outPutToGameLog("Change dealer." );
        if (isDealer0){
            dealer = playerList.get(1);
            prone = playerList.get(0);
            isDealer0 = false;
            GameFrame.outPutToGameLog("You are now the pone." );
        } else {
            dealer = playerList.get(0);
            prone = playerList.get(1);
            isDealer0 = true;
            GameFrame.outPutToGameLog("You are now the dealer." );
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

        //update cut card display
        if (board.getCutCard().size()>0){
            GameFrame.updateCutDisplay(board.getCut());
        }

        //update player1's hand
        if (playerList.get(0).getHand().size()>0){
            GameFrame.updatePlayer1HandDisplay(playerList.get(0));
        }

        //pegging related updates
        GameFrame.updatePeggingScore(board.getScore());
        GameFrame.updatePeggingCards(board);


        //update Crib Display
        if ((playerList.get(0).getCrib().size() + playerList.get(1).getCrib().size())>0){
            GameFrame.updateCribDisplay(playerList.get(0), playerList.get(1), isCountHand);
        }

        //update 2 tracks
        if (playerList.get(0).getScore()> 0) {
            gameFrame.getTracks().track1Update(playerList.get(0).getScore());
        }
        if(playerList.get(1).getScore()>0){
            gameFrame.getTracks().track2Update(playerList.get(1).getScore());
        }
    }

}
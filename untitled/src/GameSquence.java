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
    private boolean isDealer0;
    private Referee ref;
    private Scorer scorer;

    //constructor with 2 players as input
    public GameSquence(Players player1, Players player2, Board board){
        playerList.add(player1);
        playerList.add(player2);
        deck = new Deck();
        board = new Board();
        this.board = board;
        scorer = new Scorer();
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


        eachDraw();
        while (playerList.get(0).getHand().getCard(0).valueFinder() == playerList.get(1).getHand().getCard(0).valueFinder()){
            
            playerList.get(0).emptyHand();
            playerList.get(1).emptyHand();
            eachDraw();
        }

        deck.resetDeck();
    }

    //goes through 1 round of drawing and comparison
    private void eachDraw(){
        deck.deal(playerList.get(0));
        deck.deal(playerList.get(1));
    
        if (playerList.get(0).getHand().getCard(0).valueFinder() < playerList.get(1).getHand().getCard(0).valueFinder()){
            dealer = playerList.get(0);
            prone = playerList.get(1);
            //pass on player status
            isDealer0 = true;
        } else {
            dealer = playerList.get(1);
            prone = playerList.get(0);
            isDealer0 = false;
        }
    }

    //deal 6 cards to each players
    private void dealHands() {
        for (int i = 0; i < 6; i++) {
            deck.deal(prone);
            deck.deal(dealer);
        }
    }

    //allow each player to discard 2 cards to crib
    private void toCrib(){
        for (int i = 0; i < 2; i++){
            prone.discardToCrib(prone.decideCard());
            dealer.discardToCrib(dealer.decideCard());
        }
    }

    //draw and set Cut Card
    private void drawCutCard(){
        deck.deal(board);
        if (board.getCut().valueFinder() == 11){
            prone.setScore(2); //????? 2 points for getting jack?
            ref.isWinner(prone);
        }

    }
    

    private void pegging(){
        while (dealer.getCardNumber()>0 || prone.getCardNumber()>0){
            //whether prone can play
            if (ref.canPeg(prone)) {
                Cards tempCard1 = prone.decideCard();
                if (ref.canPlayCard(tempCard1)) {
                    prone.playHand(tempCard1, board);

                    //pegging score
                    prone.setScore(scorer.peggingScore(tempCard1));
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
                    ref.isWinner(dealer);
                }
            }

        }
        board.resetScore();
        board.removeCards();
        scorer.resetPeggingScore();

    }

    private void countHand(){
        //count hand for prone.hand, dealer.hand (need a return CardCollection)
        
        prone.setScore(scorer.countHand(prone.getHand(), board.getCut()));
        ref.isWinner(prone);
        dealer.setScore(scorer.countHand(dealer.getHand(), board.getCut()));
        ref.isWinner(dealer);

        //count crib
        dealer.setScore(scorer.countCrib(dealer.getHand(), board.getCut()));
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
    }

}
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

    //constructor with 2 players as input
    public GameSquence(Players player1, Players player2){
        playerList.add(player1);
        playerList.add(player2);
        deck = new Deck();
        board = new Board();
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
        while (Scroer(player1Card) == Scroer(player2Card)){
            
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
    
        if (Scorer.score(playerList.get(0).playHand(0)) < Scorer.score(playerList.get(1).playHand(0))){
            dealer = playerList.get(0);
            prone = playerList.get(1);
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
        //TO-DO: add cutCardScorer
        prone.setScore(/*score*/);
        ref.isWinner(prone);

    }
    

    private void pegging(){
        while (dealer.getCardNumber()>0 || prone.getCardNumber()>0){
            Cards tempCard1 = prone.decideCard();
            if (ref.canPeg(tempCard1, board)) {
                prone.playHand(tempCard1, board);
                //TO-Do: pegging score - pass card per card
                //TO-DO: Go
                prone.setScore(/*score*/);
                ref.isWinner(prone);
            }


            Cards tempCard2 = dealer.decideCard();
            if (ref.canPeg(tempCard2, board)){
                dealer.playHand(tempCard2, board);

                //TO-Do: pegging score
                //TO-DO: Go
                dealer.setScore(/*score*/);
                ref.isWinner(dealer);
            }

        }

    }

    private void countHand(){
        //count hand for prone.hand, dealer.hand (need a return CardCollection)
        
        prone.setScore(/*score*/);
        ref.isWinner(prone);
        dealer.setScore(/*score*/);
        ref.isWinner(dealer);
        //count crib
       
        dealer.setScore(/*score*/);
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
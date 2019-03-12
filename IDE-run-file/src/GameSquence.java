import java.util.ArrayList;

public class GameSquence{
    
    //change pointer assignment when order changes
    private Players dealer;
    private Players prone;
    private ArrayList<Players> playerList = new ArrayList<>();
    private Deck deck;
    private Board board;
    private boolean isDealer0;

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

    //each player draw 1 card each, compare and set dealer
    private void drawing(){
        //creat deck

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
        Deck.deal(playerList.get(0)); 
        Deck.deal(playerList.get(1));
    
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
            Deck.deal(prone);
            Deck.deal(dealer);
        }
    }

    //allow each player to discard 2 cards to crib
    private void toCrib(){
        for (int i = 0; i < 2; i++){
            prone.discardToCrib(prone.decideCard(), board);
            dealer.discardToCrib(dealer.decideCard(), board);
        }
    }

    //draw and set Cut Card
    private void drawCutCard(){
        Deck.deal(board);
        //TO-DO: add cutCardScorer
        prone.setScore(/*score*/);
    }
    

    private void pegging(){
        while (dealer.getCardNumber()>0 || prone.getCardNumber()>0){
            prone.playHand(prone.decideCard());
            //TO-Do: pegging score - pass card per card
            //TO-DO: Go
            prone.setScore(/*score*/);

            dealer.playHand(dealer.decideCard());
            //TO-Do: pegging score
            //TO-DO: Go
            dealer.setScore(/*score*/);
        }

    }

    private void countHand(){
        //count hand for prone.hand, dealer.hand (need a return CardCollection)
        
        prone.setScore(/*score*/);
        dealer.setScore(/*score*/);
        //count crib
       
        dealer.setScore(/*score*/);
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
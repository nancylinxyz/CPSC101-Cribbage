import java.util.ArrayList;

public class GameSquence{
    
    //change pointer assignment when order changes
    private Players dealer;
    private Players prone;
    private ArrayList<Players> playerList = new ArrayList<>();
    private Deck deck;

    //constructor with 2 players as input
    public GameSquence(Players player1, Players player2){
        playerList.add(player1);
        playerList.add(player2);
        deck = new Deck();
    }

    public void round(){
        drawing();

        while (.getScore1() < 121 && Board.getScore2() <121){
            dealHands();
            toCrib();
            drawCutCard();
            pegging();
            countHand();
        }
    }

    //each player draw 1 card each, compare and set dealer
    private static void drawing(){
        //creat deck

        eachDraw();
        while (Scroer(player1Card) == Scroer(player2Card)){
            
            playerList.get(0).emptyHand();
            playerList.get(1).emptyHand();
            eachDraw();
        }

        deck.resetDeck();
    }

    private static void pegging(){
        while ()

    }

    private static void countHand(){

    }

    //goes through 1 round of drawing and comparison
    private static void eachDraw(){
        Deck.deal(playerList.get(0)); 
        Deck.deal(playerList.get(1));

        if (Scorer.score(playerList.get(0).playHand(0)) < Scorer.score(playerList.get(1).playHand(0))){
            dealer = playerList.get(0);
            prone = playerList.get(1);
        } else {
            dealer = playerList.get(1);
            prone = playerList.get(0);
        }
    }

    //make 1 player a dealer and the other the non-dealer, works for n-players
    private static void setDealer(Player player1){
        player1.setDealer(true);
        //loop through all players and set all other players as false (use enhanced for loop)
        for (Player aPlayer : playerList/*this is an arrayList of Players*/){
            if (aPlayer.isDealer == null){
                aPlayer.setDelaer(false);
            }

        }
    }

    //changeDealer only works for 2 players
    private static void changeDealer(){
        for (Player aPlayer : playerList/*this is an arrayList of Players*/){
            if (aPlayer.isDealer()){
                aPlayer.setDealer(false);
            } else aPlayer.setDealer(true);
        }
    }

    //deal 6 cards to each players
    private static void dealHands() {
        for (int i = 0; i < 6; i++) {
            Deck.deal(prone);
            Deck.deal(dealer);
        }
    }

    //allow each player to discard 2 cards to crib
    private static void toCrib(){
        for (int i = 0; i < 2; i++){
            discardToCrib(player1.crib()); /*I assume I'm writing discarding to crib?*/
            discardToCrib(player2.crib());
        }
    }

    //draw and set Cut Card
    private static void drawCutCard(){
        Card tempCard = Deck.deal();
        Board.setCutCard(tempCard);
    }

    //takes the dealed card and give to the player
    private void dealToPlayer(){
        Card tempCard = Deck.deal();
        Player.addHand(tempCard);
    }






}
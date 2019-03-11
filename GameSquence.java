
public class GameSquence{
    
    //change pointer assignment when order changes
    private Player dealer;
    private Player prone;

    public void round(){
        drawing();
        while (Board.getScore1() < 121 && Board.getScore2() <121){
            dealHands();
            toCrib();
            drawCutCard();
            pegging();
            countHand();
        }
    }

    //each player draw 1 card each, compare and set dealer
    private static void drawing(){
        eachDraw();
        while (Scroer(player1Card) == Scroer(player2Card)){
            Deck.reset();
            eachDraw();
        }

        Deck.reset();
    }

    private static void pegging(){
        while ()

    }

    private static void countHand(){

    }

    //goes through 1 round of drawing and comparison
    private static void eachDraw(){
        player1Card = player1.setHand(); //!!need to update with proper pointer from Referee
        player2Card = player2.setHand();

        if (Scorer.score(player1Card) < Scorer.score(player2Card)){
            setDealer(HumanPlayer);
        } else {
            setDealer(AiPlayer);
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
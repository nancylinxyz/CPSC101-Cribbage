import javax.swing.*;

class Main{
    public static void main(String[] agrs){
//        Test code to print out Suit
//        Deck deck = new Deck();
//        Board board = new Board();
//        Players player1 = new AiPlayer(board);
//        deck.deal(player1);
//        System.out.println(player1.getHand().getCard(0).getSuit());


        JFrame frame = new GameFrame();

        frame.setSize(1100,700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Cribbage");
        Referee ref = new Referee();

        ref.start();



        //frame
    }
}


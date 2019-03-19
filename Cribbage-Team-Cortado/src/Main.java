import javax.swing.*;
import java.awt.*;

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
//        TrackComponent track = new TrackComponent();
//        frame.add(track, BorderLayout.NORTH);
        Referee ref = new Referee(/*track*/);

        ref.start();



        //frame
    }
}


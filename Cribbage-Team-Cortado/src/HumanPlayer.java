//might still be easier to go with int input
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class HumanPlayer extends Players {

    //private  Suit suite;
    //private Value value;
    private static int cardIndex = -1;


    //constructor
    public HumanPlayer(Board board){
        super(board);
    }


    //to-do: be able to enter a Go decision
    @Override
    public Cards decideCard(){

//        String x = JOptionPane.showInputDialog("Input card Card index (first card from left is 0):");
//        int j = Integer.parseInt(x);
//        if (j >= 0 && (j < super.getHand().size())) {
//            return super.getHand().getCard(j);
//        } else {
//            String y = JOptionPane.showInputDialog("Invalid input, enter a number between 0 and " + (super.getHand().size()-1);
//            int k = Integer.parseInt(y);
//            return super.getHand().getCard(k);
//        }
        System.out.println("Input card Card index (example: first card from left is 0):");
        Scanner in = new Scanner(System.in);


        while (in.hasNextLine()){
            String input = in.nextLine();
            int i = Integer.parseInt(input);

            if (i >= 0 && i < super.getHand().size()){
                return super.getHand().getCard(i);
            }
            System.out.println("Invalid input, enter a number between 0 and " + (super.getHand().size()-1));
        }

        return null;
    }

//    private int splitSuiteValues(String parameters){
//        int paramHolder = Integer.parseInt(parameters);
//
//        while (paramHolder < 0 && paramHolder >= super.getHand().size()) {
//
//        }
//        return paramHolder;
//
//    }



}
import javax.swing.*;
import java.util.Scanner;

class Main{
    public static void main(String[] agrs){


        JFrame frame = new Buttons();

        frame.setSize(1100,700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Cribbage");
        Referee ref = new Referee();
        ref.start();



        //frame
    }
}


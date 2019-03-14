/* player1 is always the human player
 *
 */

import javax.swing.*;
import java.util.ArrayList;

public class DisplayComponent extends JComponent {
    JLabel player1Score, player1PlayedCards, player1Status;
    JLabel player2Score, player2PlayedCards, player2CardNumber, player2Status;

    JButton /*okButton,*/ quitButton, resetButton;

    private ArrayList<JButton> buttonsList = new ArrayList<>();
    private void createPlayer1Labels(){

        player1Score = new JLabel("Your Score is: 0");
        player1Status = new JLabel("You are the dealer");//who is the dealer and prone
        player1PlayedCards = new JLabel("You have played: ");//get cards from the player

        player2Score = new JLabel("Computer Score is: 0");
        player2CardNumber = new JLabel("Number of cards left: ");
        player2Status = new JLabel("Prone");
        player2PlayedCards = new JLabel("You have played: ");

    }

    private void createButtons(){
        //okButton = new JButton("Ok");
        quitButton = new JButton("Quit");
        resetButton = new JButton("Reset");

        for (int i = 0; i <6; i++){
            JButton tempButton = new JButton("***");
            buttonsList.add(tempButton);
        }

    }

    public DisplayComponent(){
        createPlayer1Labels();
        createButtons();
    }
    //player1Score.setText("Your Score Is: " +)

    public void updateCardDisplay(int i, String input){
        buttonsList.get(i).setText(input);
    }

}

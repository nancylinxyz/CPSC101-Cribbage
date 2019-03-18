import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Click implements ActionListener {

    public void actionPerformed(ActionEvent event) {


        for (int i = 0; i < GameFrame.buttonsList.size(); i++) {
            if (event.getSource() == GameFrame.buttonsList.get(i))// in this if we check the event of the card first and then OK button
            {
                GameFrame.index = GameFrame.player1Hand.indexOf(GameFrame.buttonsList.get(i).getText());
                GameFrame.buttonsList.get(i).setVisible(false);
                // String tempCard ="" + buttonsList.get(i).getText();/// check this for the string of cards
                GameFrame.PlayedCards.setText(GameFrame.PlayedCards.getText() + GameFrame.buttonsList.get(i).getText());
                GameFrame.PlayedCards.setText(GameFrame.PlayedCards.getText() + GameFrame.player2Hand.get(i));//this one just check
                GameFrame.player2Hand.remove(i);

                GameFrame.player2NumCards.setText("cards left: " + (GameFrame.player2Hand.size()) );//checking fro the cards left

                GameFrame.PlayedCards.setFont(new Font("Arial", Font.PLAIN, 60));
                GameFrame.PlayedCards.setLocation(300, 150);

                HumanPlayer.setDecision(GameFrame.index);
            }
        }
        //panelSouth.remove(buttonsList.get(i));

        if (event.getSource() == GameFrame.quit) {
            System.exit(1);
        }

    }}
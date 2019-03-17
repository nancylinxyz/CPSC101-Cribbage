/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mac
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameFrame extends JFrame {
    
    private JButton button1, button2, button3, button4, button5, button6/*this one for the cut card*/, quit, OK, Reset;//I'm not sure that we want to keep separately the buttons or not 
    private JPanel panelNorth, panelEast, panelWest, panelSouth, mainPanel, panelCenter;
    private static JLabel status1, status2,player1Score, player2Score, player2NumCards;
    private ArrayList<JButton> buttonsList = new ArrayList<JButton>();
    private static int player1ScoreDisplay, player2ScoreDisplay, player2HandSize;
    private static String player1isDealer, player2IsDealer;
    private static JTextArea gameLog;

    private static int logLength = 1;

    private String[] cardsDimond= {"🃁","🃂","🃃","🃄","🃅","🃆","🃇","🃈","🃉","🃊","🃋","🃍","🃎"};//cards of dimand
    private String[] cardsSpade ={"🂡","🂢","🂣","🂤","🂥","🂦","🂧","🂨","🂩","🂪","🂫","🂭","🂮"};//cards of spade
    private String[] cardsClub ={"🃑","🃒","🃓","🃔","🃕","🃖","🃗","🃘","🃙","🃚","🃛","🃝","🃞"};// cards of club
    private String[] cardsHeart ={"🂱","🂲","🂳","🂴","🂵","🂶","🂷","🂸","🂹","🂺","🂻","🂽", "🂾"};// cards of heart
    private String backCard = "🂠";

    private ArrayList<String> player1Hand = new ArrayList<String>();
    private ArrayList<String> player2Hand = new ArrayList<String>();


    public GameFrame(/*passing an arraylist cardsCollection from hand*/){

        
        //player2 is the Aiplayer
        status1 = new JLabel("status: undecided");//give a status
        status2 = new JLabel("status: undecided");
        
        player1Score= new JLabel("Your Score: " + player1ScoreDisplay);//add a score
        player2Score = new JLabel("Player 2 Score: " + player2ScoreDisplay);
        
        player2NumCards = new JLabel("Cards left: "+ player2HandSize);
        
        createButtons();
        createNorthPanel();
        createEast();
        createSouthPanel();
        createWest();
        createCenter();
        createMainPanel();

      }
    
    public void createMainPanel(){
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        //mainPanel.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));
        
        mainPanel.add(panelNorth, BorderLayout.NORTH);
        mainPanel.add(panelSouth, BorderLayout.SOUTH);
        mainPanel.add(panelEast, BorderLayout.EAST);
        mainPanel.add(panelWest, BorderLayout.WEST);
        mainPanel.add(panelCenter, BorderLayout.CENTER);
        
        add(mainPanel);
        
    }
    
    
    //this panel will show up all the played cards
    public void createNorthPanel(){
    
        panelNorth = new JPanel();
        //panelNorth.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
        panelNorth.setPreferredSize(new Dimension(1100,100));
        panelNorth.setLocation(0,0);
        panelNorth.setLayout(new GridLayout(1,1,3,3));
        panelNorth.setBorder(BorderFactory.createTitledBorder("Pegging Track"));
        TrackComponent tracks = new TrackComponent();
        panelNorth.add(tracks);
        
    }
    //this panel contains player2 information: cards and button to action
    public void createSouthPanel(){
        panelSouth = new JPanel();
        panelSouth.setPreferredSize(new Dimension(1100,100));
        panelSouth.setLocation(0,600);
        
        //panelSouth.setLayout(new GridLayout(1,9,3,3));
        for(int i=0; i< buttonsList.size(); i++){
            buttonsList.get(i).setLocation(10*(i+1)+5 ,605);
            buttonsList.get(i).setPreferredSize(new Dimension(80,90));
            panelSouth.add(buttonsList.get(i));
            
        }
        quit.setLocation(1030,610);
        quit.setPreferredSize(new Dimension(50,40));
        
        Reset.setLocation(1030,670);
        Reset.setPreferredSize(new Dimension(50,40));
        
        //OK.setLocation(1030,670);
        //OK.setPreferredSize(new Dimension(50,40));
        
        panelSouth.add(quit);
        panelSouth.add(Reset);
       // panelSouth.add(OK);
            
        
    }
    
    public void createEast(){
    
        panelEast = new JPanel();
        panelEast.setPreferredSize(new Dimension(200,500));
        panelEast.setLocation(900,100);

        panelEast.setLayout(new GridLayout(2,1,5,5));
        panelEast.setBorder(BorderFactory.createTitledBorder("Your Dashboard"));
        
        panelEast.add(player1Score);
        panelEast.add(status1);
    }
    
    public void createWest(){
    
        panelWest = new JPanel();
        panelWest.setPreferredSize(new Dimension(200,500));
        panelWest.setLocation(0,100);
        panelWest.setLayout(new GridLayout(3,1,5,5));
        panelWest.setBorder(BorderFactory.createTitledBorder("Player 2 Dashboard"));
        
        panelWest.add(player2Score);
        panelWest.add(status2);
        panelWest.add(player2NumCards);
        
    }
    
    public void createCenter(){
    
        panelCenter = new JPanel();
        panelCenter.setPreferredSize(new Dimension(700,500));
        panelCenter.setLocation(200,100);
        panelCenter.setBorder(BorderFactory.createTitledBorder("Board"));
        panelCenter.setLayout(new GridLayout(3, 1, 5,5));
        gameLog = new JTextArea(logLength,1);
        gameLog.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(gameLog);
        panelCenter.add(scrollPane);

    }
    
    class Click implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            
            for(int i=0; i< buttonsList.size(); i++){
                if(event.getSource() == buttonsList.get(i))// in this if we check the event of the card first and then OK button
                {
                buttonsList.get(i).setVisible(false);
            }
                //panelSouth.remove(buttonsList.get(i));
            }
        }
    }
    
    private void createButtons()
    {
        for(int i=0; i< player1Hand.size(); i++)//need to change this one to the actually arrayList
            //use arraylist instead of array
            buttonsList.add(new JButton(player1[i]));
        for(int j=0; j<buttonsList.size(); j++)
            buttonsList.get(j).setFont(new Font("Arial", Font.PLAIN, 60));

        quit = new JButton("Quit");
        Reset = new JButton("Reset");
        OK = new JButton("OK");

        ActionListener listener = new Click();


        for(int i=0; i<buttonsList.size(); i++){
            buttonsList.get(i).addActionListener(listener);
        }

        quit.addActionListener(listener);
        Reset.addActionListener(listener);
        //OK.addActionListener(listener);
    
    }

    //setting display variables
    public static void setPlayer1ScoreDisplay(int i){
        player1Score.setText("Your Score: " + i);
    }

    public static void setPlayer2ScoreDisplay(int i){
        player2Score.setText("Player 2 Score: " + i);
    }

    public static void setPlayer2HandSize(int i){
        player2NumCards.setText("Player 2 Has " + i +" Cards Left");
    }

    public static void setPlayer1isDealer(boolean t){
        if (t){
            status1.setText("Status: Dealer");
        } else status1.setText("Status: Prone");
    }

    public static void setPlayer2isDealer(boolean t){
        if (t){
            status2.setText("Status: Prone");
        } else status2.setText("Status: Dealer");
    }

    public static void outPutToGameLog(String input){
        logLength++;
        gameLog.append(input +"\n");

        //output log or scroll pane
    }
    
//     public static void main(String[] args){
//
//
//
//        JFrame frame = new GameFrame();
//
//        frame.setSize(1100,700);
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setTitle("Cribbage");
//
//
//    }
}

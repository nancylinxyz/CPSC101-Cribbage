//might still be easier to go with int input
import java.util.Scanner;

public class HumanPlayer extends Players {

    //private  Suit suite;
    //private Value value;


    //constructor
    public HumanPlayer(Board board){
        super(board);
    }


    //to-do: be able to enter a Go decision
    @Override
    public Cards decideCard(){
        System.out.println("Input card Card index (example: first card from left is 0):");
        Scanner in = new Scanner(System.in);
        String parameters = in.nextLine();
        int j = splitSuiteValues(parameters);

        return super.getHand().getCard(j);
    }

    private int splitSuiteValues(String parameters){
        int paramHolder = Integer.parseInt(parameters);
        //String[] paramHolder = parameters.split(",");

        //Enum suite = Enum.valueOf(Suit.class ,paramHolder[0]);
        //Enum value = Enum.valueOf(Value.class, paramHolder[1]);
        return paramHolder;
    }



}
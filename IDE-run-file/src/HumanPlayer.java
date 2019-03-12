//might still be easier to go with int input
import java.util.Scanner;

public class HumanPlayer extends Players {

    private  Suit suite;
    private Value value;

    //constructor
    public HumanPlayer(){
        super();
    }


    //to-do: be able to enter a Go decision
    @Override
    public Cards decideCard(){
        System.out.println("Input card in Suite, Value format (example: Spade, Ace):");
        Scanner in = new Scanner(System.in);
        String parameters = in.nextLine();
        splitSuiteValues(parameters);

        return Cards(suite, value);
    }

    private void splitSuiteValues(String parameters){
        String[] paramHolder = parameters.split(",");

        Enum suite = Enum.valueOf(Suit.class ,paramHolder[0]);
        Enum value = Enum.valueOf(Value.class, paramHolder[1]);

    }



}
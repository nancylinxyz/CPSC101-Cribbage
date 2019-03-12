
public class HumanPlayer extends Players{
    private String Suite;
    private String Value;
    //constructor
    public HumanPlayer(){
        super.Player();
    }


    //to-do: be able to enter a Go decision
    @Override
    public Cards decideCard(){
        System.out.println("Input card in Suite, Value formate (example: Spade, Ace):");
        Scanner in = new Scanner(System.in);
        String parameters = in.nextLine();
        splitSuiteValues(parameters);

        return Cards(Suite, Value);
    }

    private void splitSuiteValues(String parameters){
        String[] paramHolder = parameters.split(",");

        Suite = paramHolder[0];
        Value = paramHolder[1];

    }

}
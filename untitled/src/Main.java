import java.util.Scanner;

class Main{
    public static void main(String[] agrs){
        TrackComponent tracks = new TrackComponent();

        Referee ref = new Referee(tracks);
        ref.start();


        System.out.println("Types play to start the game!!! ");
        Scanner input1 = new Scanner(System.in);

        String start= input1.next();

        if(start.equals("play")){

        }

        //frame
    }
}


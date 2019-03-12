import java.util.Scanner;

class Main{
    public static void main(String[] agrs){
        Referee ref = new Referee();
        ref.start();


        System.out.println("Types play to start the game!!! ");
        Scanner input1 = new Scanner(System.in);

        String start= input1.next();

        if(start.equals("play")){

        }
    }
}


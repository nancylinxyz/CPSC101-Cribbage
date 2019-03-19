import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TrackComponent extends JComponent {

    private static int xTrack[] = new int[123];
    private static int xPoint1;
    private static ArrayList<TrackElements> trackList1 = new ArrayList<>();
    private static ArrayList<TrackElements> trackList2 = new ArrayList<>();

    public static void addXPoints(){
        xPoint1 = 10;
        for (int i = 0; i< 2; i++){
            xTrack[i] = xPoint1 + 6*i + 5*(i/20)+120;
        }
        for (int i = 2; i < 123; i++){
            xTrack[i] = xPoint1 + 6*i + 5*(i/20) +125;
            //System.out.println(xTrack[i]);
        }

    }

    public TrackComponent(){
        addXPoints();
        //first 2 pegs are red and rest are black
        for (int i = 0; i < 2; i++){
            TrackElements tempPeg = new TrackElements(xTrack[i], 20);
            tempPeg.updateColor(Color.RED);
            trackList1.add(tempPeg);

            TrackElements tempPeg2 = new TrackElements(xTrack[i], 45);
            tempPeg2.updateColor(Color.RED);
            trackList2.add(tempPeg2);
        }

        for (int i = 2; i < 123; i++){
            TrackElements tempPeg = new TrackElements(xTrack[i], 20);
            tempPeg.updateColor(Color.BLACK);
            trackList1.add(tempPeg);

            TrackElements tempPeg2 = new TrackElements(xTrack[i], 45);
            tempPeg.updateColor(Color.BLACK);
            trackList2.add(tempPeg2);
        }

    }

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        for (int i = 0; i < 123; i++){
            trackList1.get(i).draw(g2);
            trackList2.get(i).draw(g2);
        }
    }

    public static void track1Update(int i){
        for (int j = 2; j < 123; j++){
            trackList1.get(j).updateColor(Color.BLACK);
        }
        if (i+2 < 123) {
            trackList1.get(i + 2).updateColor(Color.GREEN);
        }
        if (i + 2 >= 123){
            trackList1.get(123).updateColor(Color.GREEN);
        }

    }


    public static void track2Update(int i){
        for (int j = 2; j < 123; j++){
            trackList2.get(j).updateColor(Color.BLACK);
        }

        if (i+2 < 123) {
            trackList2.get(i + 2).updateColor(Color.GREEN);
        }
        if (i + 2 >= 123){
            trackList2.get(123).updateColor(Color.GREEN);
        }

    }

    public void updatePaint(){
        repaint();
    }
}

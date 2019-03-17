import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TrackComponent extends JComponent {

    private static int xTrack[] = new int[123];
    private static int xPoint1;
    private ArrayList<TrackElements> trackList1 = new ArrayList<>();
    private ArrayList<TrackElements> trackList2 = new ArrayList<>();

    public static void addXPoints(){
        xPoint1 = 10;
        for (int i = 0; i < 123; i++){
            xTrack[i] = xPoint1 + 6*i + 5*(i/20);
            //System.out.println(xTrack[i]);
        }

    }

    public TrackComponent(){
        addXPoints();
        //first 2 pegs are red and rest are black
        for (int i = 0; i < 2; i++){
            TrackElements tempPeg = new TrackElements(xTrack[i], 310);
            tempPeg.updateColor(Color.RED);
            trackList1.add(tempPeg);

            TrackElements tempPeg2 = new TrackElements(xTrack[i], 440);
            tempPeg2.updateColor(Color.RED);
            trackList2.add(tempPeg2);
        }

        for (int i = 2; i < 123; i++){
            TrackElements tempPeg = new TrackElements(xTrack[i], 310);
            tempPeg.updateColor(Color.BLACK);
            trackList1.add(tempPeg);

            TrackElements tempPeg2 = new TrackElements(xTrack[i], 440);
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

    public void track1PegToGreen(int i){
        trackList1.get(i).updateColor(Color.GREEN);
        repaint();
    }

    public void track1PegToBlack(int i){
        trackList1.get(i).updateColor(Color.BLACK);
        repaint();
    }

    public void track2PegToGreen(int i){
        trackList2.get(i).updateColor(Color.GREEN);
        repaint();
    }

    public void track2PegToBlack(int i){
        trackList2.get(i).updateColor(Color.BLACK);
        repaint();
    }
}

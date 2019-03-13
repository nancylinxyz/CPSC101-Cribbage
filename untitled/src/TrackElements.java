import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class TrackElements {
    private int yTrack1 = 10;
    private int yTrack2 = 40;

    private int xTrack[];
    private int xPoint1;
    private ArrayList<Ellipse2D> track1, track2;



    //populating xTrack with increment 5 pixels
    //615 pixels total
    private void addXPoints(){
        xPoint1 = 10;
        for (int i = 0; i < 123; i++){
            xTrack[i] = xPoint1 + 5;
        }

    }

    private void createTracks(){
        for (int i = 0; i <123; i++){
            Ellipse2D.Double tempPeg = new Ellipse2D.Double(xTrack[i], yTrack1, 5, 5);
            track1.add(tempPeg);
        }
        for (int i = 0; i <123; i++){
            Ellipse2D.Double tempPeg = new Ellipse2D.Double(xTrack[i], yTrack2, 5, 5);
            track2.add(tempPeg);
        }

    }

    public TrackElements(){
        addXPoints();
        createTracks();
    }


    public void draw(Graphics2D g2){
        for (int i = 0; i<123; i++){
            g2.draw(track1.get(i));
            g2.draw(track2.get(i));
        }

        //fill first 2 dot red
        for (int i = 0; i< 2; i++){
            g2.setColor(Color.RED);
            g2.fill(track1.get(i));
            g2.fill(track2.get(i));
        }


    }




}

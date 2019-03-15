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
    private ArrayList<Color> colors1, colors2;



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
            colors1.add(Color.BLACK);

        }
        for (int i = 0; i <123; i++){
            Ellipse2D.Double tempPeg = new Ellipse2D.Double(xTrack[i], yTrack2, 5, 5);
            track2.add(tempPeg);
        }

    }

    public TrackElements(){
        addXPoints();
        createTracks();
        //set peg 1 & 2 red

        for (int i = 0; i<2; i++){
            colors1.set(i, Color.RED);
            colors2.set(i, Color.RED);
        }
    }


    public void draw(Graphics2D g2){
        for (int i = 0; i<123; i++){

            g2.setColor(colors1.get(i));
            g2.draw(track1.get(i));
            g2.fill(track1.get(i));

            g2.setColor(colors2.get(i));
            g2.draw(track2.get(i));
            g2.fill(track2.get(i));
        }


    }

    //i is the peg index
    public void updateColor1(int i, Color color){
        colors1.set(i, color);
    }

    public void updateColor2(int i, Color color){
        colors2.set(i, color);
    }



}

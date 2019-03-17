import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;


public class TrackElements {
    Ellipse2D.Double tempPeg;
    Color color;
    //populating xTrack with increment 5 pixels
    //615 pixels total


    public TrackElements(int x, int y){
        tempPeg = new Ellipse2D.Double(x, y, 3, 3);
        color =  Color.BLACK;
    }


    public void draw(Graphics2D g2){
        for (int i = 0; i<123; i++){

            g2.setColor(color);
            g2.draw(tempPeg);
            g2.fill(tempPeg);

        }


    }

    //i is the peg index
    public void updateColor(Color color){
        this.color = color;
    }


}

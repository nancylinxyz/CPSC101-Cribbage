import javax.swing.*;
import java.awt.*;

public class TrackComponent extends JComponent {

    private TrackElements tracks;

    public TrackComponent(){
        tracks = new TrackElements();
    }

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        tracks.draw(g2);
    }

    public TrackElements getTracks(){
        return tracks;
    }


}

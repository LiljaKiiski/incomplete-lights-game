import java.awt.Graphics2D;
import javax.swing.ImageIcon;

public class Planet extends MyObject{

    public Planet(int x, int y, int width, int height){
        super(x, y, width, height);
    }

    /**
     * Paint in center
     */
    public void paint(Graphics2D g2d){
        int x = (Constants.FRAME_WIDTH - width)/2;
        int y = (Constants.FRAME_HEIGHT - height)/2;        

        g2d.setPaint(Constants.PLANET_COLOR);
        g2d.fillOval(x, y, width, height);
    }
}
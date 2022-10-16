import java.awt.Graphics2D;
import javax.swing.ImageIcon;

public class Rock extends MyObject{
    private int slope;

    //Random rock direction and size
    public Rock(){
        super(0, 0, 50, 50);
        slope = 1;
    }

    public void move(){
        x += 1;
        y += slope;
    }
    
    public void paint(Graphics2D g2d){ 
        g2d.setPaint(Constants.ROCK_COLOR);
        g2d.fillOval(x, y, width, height);
    }
}
import java.awt.Graphics2D;
import javax.swing.ImageIcon;

public class Rock extends MyObject{
    private int slope;

    //Random rock direction and size
    public Rock(){
        super(0, 0, 20, 20);

        //Make random x, y location
        System.out.println((int)(Math.random() *  2));

        //Set x and y to random making sure one of them is 0
        x = (int)(Math.random() *  2) == 0 ? (int)(Math.random() * Constants.FRAME_WIDTH) : 0;
        y = x == 0 ? (int)(Math.random() * Constants.FRAME_WIDTH) : 0;

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
import java.awt.Graphics2D;
import javax.swing.ImageIcon;

public class Rock extends MyObject{
    private int slope;

    //Direction x/y (1 or -1)
    private int dirX;
    private int dirY;

    //Random rock direction and size
    public Rock(){
        super(0, 0, 20, 20);

        //Make x start at side
        int setBase = (int)(Math.random() *  2);

        //Set to random side
        if (setBase == 0){
            x = (int)(Math.random() *  2) == 0 ? Constants.FRAME_WIDTH : 0;
            y = (int)(Math.random() * Constants.FRAME_HEIGHT);

        //Set to random start
        } else {
            x = (int)(Math.random() * Constants.FRAME_WIDTH);
            y = (int)(Math.random() *  2) == 0 ? Constants.FRAME_HEIGHT: 0;
        }

        //Get slope from start to target (planet at center)
        int slopeX = Math.abs(Constants.CENTERX - x);
        int slopeY = Math.abs(Constants.CENTERY - y);

        //Make slope go backward
        dirX = 1;
        dirY = 1;
        if (x > Constants.CENTERX) {
            dirX = -1;
        
        } if (y > Constants.CENTERY){
            dirY = -1;
        }

        slope = slopeY/slopeX;
    }

    public void move(){
        x += 1*dirX;
        y += slope*dirY;
    }
    
    public void paint(Graphics2D g2d){ 
        g2d.setPaint(Constants.ROCK_COLOR);
        g2d.fillOval(x, y, width, height);
    }
}
import java.awt.Graphics2D;
import javax.swing.ImageIcon;

public class Bullet extends MyObject{

    public Bullet(int x, int y, int width, int height){
        super(x, y, width, height);
    }

    //Random bullet
    public Bullet(){
        super(0, 0, 0, 0);
    }

    public void paint(Graphics2D g2d){ 
        g2d.setPaint(Constants.BULLET_COLOR);
        g2d.fillOval(x, y, width, height);
    }
}
import java.awt.Graphics2D;
import javax.swing.ImageIcon;

public class MyObject {
    public int x;
    public int y;
    public int width;
    public int height;

    public ImageIcon image;

    public MyObject(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        image = null;
    }

    public boolean collidedWith(MyObject object2){
        return false;
    }

    public void paint(Graphics2D g2d){
        g2d.drawRect(x, y, width, height);
    }
}
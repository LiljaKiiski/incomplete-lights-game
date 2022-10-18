import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import java.util.ArrayList;

public class Planet extends MyObject{
    private int health;

    public Planet(int x, int y, int width, int height){
        super(x, y, width, height);
        this.x = (Constants.FRAME_WIDTH - width)/2;
        this.y = (Constants.FRAME_HEIGHT - height)/2;    

        health = 10;
    }

    /**
     * Check for collisions with rocks
     */
    public void checkCollisions(ArrayList<Rock> rocks){
        for (int x = 0; x < rocks.size(); x++){
            Rock r = rocks.get(x);

            int pLeft = this.x;
            int pRight = this.x + this.width;
            int pTop = this.y;
            int pBottom = this.y + this.height;

            int rLeft = r.x;
            int rRight = r.x + r.width;
            int rTop = r.y;
            int rBottom = r.y + r.height;

            //Has collided
            if(((pLeft >= rLeft && pLeft <= rRight) ||  //If objects have collided on x axis (left and right sides)
                (pRight >= rLeft && pRight <= rRight) ||
                (pLeft >= rLeft && pRight <= rRight) || 
                (pLeft <= rLeft && pRight >= rRight)) &&

                ((pTop >= rTop && pTop <= rBottom) ||  //If objects have collided on y axis (top and bottom sides)
                    (pBottom <= rBottom && pBottom >= rTop) ||
                    (pTop >= rBottom && pBottom <= rBottom ) ||
                    (pTop <= rBottom && pBottom >= rBottom))) {

                //Collided
                health--;
                rocks.remove(r);
                System.out.println("Collided!!!");
            }
        }
    }

    /**
     * Paint in center
     */
     @Override
    public void paint(Graphics2D g2d){ 
        g2d.setPaint(Constants.PLANET_COLOR);

        //Percent filled
        g2d.fillArc(x, y, width, height, 0, health*36);
    }
}
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

            //Planet and rock centers
            int pCenterX = this.x + this.width/2;
            int pCenterY = this.y + this.height/2;

            int rCenterX = r.x + r.width/2;
            int rCenterY = r.y + r.height/2;

            int dist = (int)Math.sqrt( Math.pow(pCenterX - rCenterX, 2) + Math.pow(pCenterY - rCenterY, 2));

            //If distance between centers is less than two radii added, collision occured
            if (dist <= this.width/2 + r.width/2){
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
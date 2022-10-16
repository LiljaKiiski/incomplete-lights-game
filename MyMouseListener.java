import javax.swing.JFrame;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.MouseInfo;

public class MyMouseListener implements MouseListener{
		boolean held; //If mouse is pressed down
		JFrame frame;

    	public MyMouseListener(JFrame frame) {
			this.frame = frame;
    	}

    	public void mouseClicked(MouseEvent e) {  
       
    	}

    	public void mouseEntered(MouseEvent e) {  
        
    	}

    	public void mouseExited(MouseEvent e) {  
        
    	}

    	public void mousePressed(MouseEvent e) {  
			held = true;
    	}  

    	public void mouseReleased(MouseEvent e) {  
			held = false;
    	}  

		public boolean isHeld(){
			return held;
		}

		public void getCoords(){
			
		}

		public int getMouseX(){
			//X relative to screen minus x relative to frame
			return (int)(MouseInfo.getPointerInfo().getLocation().getX() - frame.getLocationOnScreen().getX());
		}

		public int getMouseY(){
			//Y relative to screen minus y relative to frame
			return (int)(MouseInfo.getPointerInfo().getLocation().getY() - frame.getLocationOnScreen().getY());
		}
}

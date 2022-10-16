import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyActionListener implements ActionListener{
		public MyMouseListener mouseListener;
		public MyPanel panel;

    	public MyActionListener(MyMouseListener mouseListener, MyPanel panel){
			this.mouseListener = mouseListener;
			this.panel = panel;
    	}

    	@Override
    	public void actionPerformed(ActionEvent e) { 
			System.out.println(mouseListener.getMouseX());

			if (mouseListener.isHeld()){
				panel.addPoint(mouseListener.getMouseX(), mouseListener.getMouseY());
			}

    	}
}
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
		if (mouseListener.isHeld()){
			panel.addPoint(mouseListener.getCoords());

			panel.repaint();
		
		} else {
			panel.clearPoints();
		}

	}
}
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;

import java.util.ArrayList;

public class MyPanel extends JPanel {
		public ArrayList<MyPoint> points;

    	public MyPanel(){
        	setBounds(Constants.FRAME_BOUNDS);
			points = new ArrayList<>();
    	}

		public void addPoint(PMyPoint p){
			points(p)
		}

    	@Override
    	protected void paintComponent(Graphics g){
        	super.paintComponent(g);
        	Graphics2D g2d = (Graphics2D)g;

        	g2d.setPaint(Color.blue);

			g2d.setStroke(new BasicStroke(10));

			g2d.drawLine(100, 100, 100, 100);

			System.out.println("point!");
    	}
}

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

import java.util.ArrayList;

public class MyPanel extends JPanel {
	private ArrayList<MyPoint> points;

	private Planet planet;
	private ArrayList<Rock> rocks;

	public MyPanel(){
		setBounds(Constants.FRAME_BOUNDS);
		points = new ArrayList<>();

		planet = new Planet(300, 300, 150, 150);
		rocks = new ArrayList<>();
		addRock();
	}

	public void addRock(){
		rocks.add(new Rock());
	}

	public void addPoint(MyPoint p){
		points.add(p);
	}

	public void clearPoints(){
		points.clear();
	}

	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;

		planet.paint(g2d);

		g2d.setPaint(Constants.LINE_COLOR);
		g2d.setStroke(new BasicStroke(Constants.LINE_SIZE));

		for (int x = 1; x < points.size(); x++){
			MyPoint p = points.get(x);
			MyPoint p2 = points.get(x-1);

			//Connect two points
			g2d.drawLine(p.x, p.y, p2.x, p2.y);
		}

		for (Rock r : rocks){
			r.paint(g2d);
		}
	}
}
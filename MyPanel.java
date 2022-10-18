import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

import java.util.ArrayList;

public class MyPanel extends JPanel {
	private ArrayList<MyPoint> points;

	public Planet planet;
	public ArrayList<Rock> rocks;

	public MyPanel(){
		setBounds(0, 0, Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
		points = new ArrayList<>();

		planet = new Planet(300, 300, 150, 150);
		rocks = new ArrayList<>();
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

		//Paint planet
		planet.paint(g2d);

		//Paint mouse points
		g2d.setPaint(Constants.LINE_COLOR);
		g2d.setStroke(new BasicStroke(Constants.LINE_SIZE));

		for (int x = 1; x < points.size(); x++){
			MyPoint p = points.get(x);
			MyPoint p2 = points.get(x-1);

			//Connect points
			g2d.drawLine(p.x, p.y, p2.x, p2.y);
		}

		//Print rocks
		for (int x = 0; x < rocks.size(); x++){
			Rock r = rocks.get(x);
			r.move();
			r.paint(g2d);

			//Remove rock from list if not in screen range
			if (r.x < 0 || r.x > Constants.FRAME_WIDTH ||
					r.y < 0 || r.y > Constants.FRAME_HEIGHT){

				rocks.remove(r);
			}
			}
	}
}
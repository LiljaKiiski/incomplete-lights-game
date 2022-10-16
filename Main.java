import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {
	private MyMouseListener mouseListener;
	private JFrame frame;
	private MyPanel panel;

	//Main timer
	private Timer timer;

	//Bullet shooting timer
	private Timer rockTimer;

	public Main(){
		frame = new JFrame("Lights");
		panel = new MyPanel();

		mouseListener = new MyMouseListener(frame);
		
		timer = new Timer(Constants.DELAY, e -> runGame());
		rockTimer = new Timer(Constants.DELAY, e -> addRocks());

		setUpFrame();
		timer.start();
	}

	public void addRocks(){
		panel.addRock();
	}

	public void runGame(){
		if (mouseListener.isHeld()){
			panel.addPoint(mouseListener.getCoords());

			panel.repaint();
		
		} else {
			panel.clearPoints();
		}
	}

	public void setUpFrame(){
		frame.setIconImage(new ImageIcon("images/image.png").getImage());
		frame.setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
		frame.setLayout(null);

		frame.addMouseListener(mouseListener);

		frame.add(panel);

		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
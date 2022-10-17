import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

//Have to use this because flipping Java Swing is stupid
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
	private MyMouseListener mouseListener;
	private JFrame frame;
	private MyPanel panel;

	private int addTime; //Add rock every 50 or something

	//Lock for updating panel.rocks and points cuz flip java
	public Lock lock = new ReentrantLock();

	//Main timer
	private Timer timer;

	public Main(){
		frame = new JFrame("Lights");
		panel = new MyPanel();
		addTime = 0;

		mouseListener = new MyMouseListener(frame);
		
		timer = new Timer(Constants.DELAY, e -> runGame());
		
		setUpFrame();
		timer.start();
	}

	public void runGame(){
		try {
			game.lock.lock();
			game.grid[posX][posY] = player;
		} finally {
						game.lock.unlock();
					}
		if (mouseListener.isHeld()){
			panel.addPoint(mouseListener.getCoords());
		
		} else {
			panel.clearPoints();
		}

		//Every certain time add a rock
		if (addTime == 50){
			addTime = 0;
			panel.addRock();
		}

		panel.repaint();
		Toolkit.getDefaultToolkit().sync();
		addTime++;
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
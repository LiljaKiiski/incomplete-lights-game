import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Main {
    	MyKeyListener keyListener;
    	MyMouseListener mouseListener;
    	MyActionListener actionListener;
    	Timer timer;
		JFrame frame;
    	MyPanel panel;

    	public Main(){
			frame = new JFrame("Lights");
			panel = new MyPanel();
        	keyListener = new MyKeyListener();
        	mouseListener = new MyMouseListener(frame);
        	actionListener = new MyActionListener(mouseListener, panel);
        	timer = new Timer(Constants.DELAY, actionListener);

        	setUpFrame();
    	}

    	public void setUpFrame(){
        	frame.setIconImage(new ImageIcon("images/image.png").getImage());
        	frame.setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
        	frame.setLayout(null);

        	frame.addMouseListener(mouseListener);

        	frame.addKeyListener(keyListener);
        	frame.setFocusable(true);

        	frame.add(panel);

        	frame.setLocationRelativeTo(null);
        	frame.setResizable(false);
        	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	frame.setVisible(true);

			int num = 0;

        	timer.start();
    	}
}

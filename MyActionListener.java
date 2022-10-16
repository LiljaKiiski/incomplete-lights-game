import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyActionListener implements ActionListener{

		public MyMouseListener mouseListener;

    	public MyActionListener(MyMouseListener mouseListener){
			this.mouseListener = mouseListener;
    	}

    	@Override
    	public void actionPerformed(ActionEvent e) { 
			System.out.println(mouseListener.getMouseX());

    	}
}

import java.awt.Rectangle;
import java.awt.Color;

public class Constants {
	public static final int ADD = 38; //Add to heigh cuz swing is stupid

	public static final int FRAME_WIDTH = 700;
	public static final int FRAME_HEIGHT = 700 + ADD;

	public static final Rectangle FRAME_BOUNDS = new Rectangle(0, 0, FRAME_WIDTH, FRAME_HEIGHT);

	public static final int DELAY = 13;

	public static final int LINE_SIZE = 10;
	public static final Color LINE_COLOR = Color.BLUE;
}
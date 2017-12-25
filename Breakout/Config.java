
public class Config {

	
	public static int getWidth() {
		return WIDTH;
	}

	public static int getHeight() {
		return HEIGHT;
	}

	public static int getPaddleWidth() {
		return PADDLE_WIDTH;
	}

	public static int getPaddleHeight() {
		return PADDLE_HEIGHT;
	}

	public static int getPaddleYOffset() {
		return PADDLE_Y_OFFSET;
	}

	public static int getNbricksPerRow() {
		return NBRICKS_PER_ROW;
	}

	public static int getNbrickRows() {
		return NBRICK_ROWS;
	}

	public static int getBrickSep() {
		return BRICK_SEP;
	}

	public static int getBrickWidth() {
		return BRICK_WIDTH;
	}

	public static int getBrickHeight() {
		return BRICK_HEIGHT;
	}

	public static int getBallRadius() {
		return BALL_RADIUS;
	}

	public static int getBrickYOffset() {
		return BRICK_Y_OFFSET;
	}

	public static int getNturns() {
		return NTURNS;
	}

	public static int getyDistance() {
		return Y_DISTANCE;
	}

	/** Dimensions of game board (usually the same) */
	private static final int WIDTH = 400;
	private static final int HEIGHT = 600;

	/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

	/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

	/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

	/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

	/** Separation between bricks */
	private static final int BRICK_SEP = 4;

	/** Width of a brick */
	private static final int BRICK_WIDTH = (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

	/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

	/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 13;

	/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

	/** Number of turns */
	private static final int NTURNS = 3;

	private static final int Y_DISTANCE = 5;

}

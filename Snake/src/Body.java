import java.awt.Color;

import acm.graphics.GRect;

public class Body extends GRect{
	
	private int direction;

	private static final double SIZE = 8;
	private static final double MOVE = 10;
	
	public Body(double x, double y) {
		super(x, y, SIZE, SIZE);
		this.setColor(Color.GREEN);
		this.setFilled(true);
	}
	

	public void moveSnake() {
		switch(direction) {
			case 1: this.move(MOVE, 0);
			System.out.println("work");
			case 2: this.move(0, MOVE);
			System.out.println("work");
			case 3: this.move(-MOVE, 0);
			System.out.println("work");
			case 4: this.move(0, -MOVE);
			System.out.println("work");
		}
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
	public int getDirection() {
		return direction;
	}


	public int getPositionX() {
		return (int) this.getX();
	}
	
	public int getPositionY() {
		return (int) this.getY();
	}
}

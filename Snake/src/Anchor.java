import java.awt.Color;

import acm.graphics.GRect;

public class Anchor extends GRect{
	private int direction;
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	public Anchor(double x, double y){
		super(x - 2, y - 2, 10, 10);
		this.setVisible(true);
		this.setColor(Color.ORANGE);
		
	}
}

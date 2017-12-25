import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import acm.graphics.GTurtle;
import acm.program.GraphicsProgram;

public class blockWalk extends GraphicsProgram{
	private List<Integer> angle = new ArrayList<Integer>();
	private int x;
	private int y;
	public blockWalk() {
		super();
		this.x = x;
		this.y = y;
		this.toitle = toitle;
	}

	private GTurtle toitle = new GTurtle(x, y);	
	public List<Integer> getAngle() {
		return angle;
	}
	public void setAngle(List<Integer> angle) {
		this.angle = angle;
	}
	public GTurtle getToitle() {
		return toitle;
	}
	public void setToitle(GTurtle toitle) {
		this.toitle = toitle;
	}
	private int n = (0);
	int previous;
	Random rand = new Random();

	public GTurtle createTurtle(int x, int y){
		GTurtle toitle = new GTurtle(x, y);
		toitle.hideTurtle();
		toitle.setSpeed(.899999999999999999);
		toitle.penDown();
		return toitle;
		}
	
	public Color randomColor(){
		int first = rand.nextInt(255);
		int second = rand.nextInt(255);
		int third = rand.nextInt(255);
		Color randomColor = new Color(first, second, third);
		return randomColor;

	}
	public void walk(GTurtle toitle){
		List<Integer> angle = new ArrayList<Integer>();
		while(n != 720){
			angle.add(n);
			n += 90;
		}
		int dir = rand.nextInt(4);
		
		toitle.setDirection(angle.get(dir));
		previous = dir;
		
		toitle.forward(5);
		if(toitle.getX() < 0 || toitle.getX() > 1200 || toitle.getY() < 0 || toitle.getY() > 800){
			toitle.left(180);
			toitle.forward(5);
		}
		
	}
}
	

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import acm.graphics.GLabel;
import acm.graphics.GTurtle;
import acm.program.GraphicsProgram;

public class Environment extends GraphicsProgram{

	Random rand = new Random();
	List<GTurtle> turtles = new ArrayList<GTurtle>();
	int newX;
	int newY;
	boolean newTurtle = false;
	private static final int WIDTH = 1200;
	private static final int LENGTH = 800;
	private int turtleCounter = 0;
	private int stepsCounter = 0;
	GLabel counters = new GLabel("Turtles: " + turtleCounter + ", Steps Takes: " + stepsCounter, 0, LENGTH - 20);
	List<Integer> angle = new ArrayList<Integer>();

	public void run() {
		setSize(WIDTH, LENGTH);
		addMouseListeners();
		counters.setColor(Color.BLACK);
		add(counters);
		createTurtle(WIDTH/2, LENGTH/2);
		directions();
		while(true){
			turtles();
		}
	}
	
	public void turtles(){
		if(newTurtle){
			createTurtle(newX, newY);
			newTurtle = false;
		}
		for(int i = 0; i< turtles.size(); i++){
			walk(turtles.get(i));
			stepsCounter++;
			counters.setLabel("Turtles: " + turtleCounter + ", Steps Takes: " + stepsCounter);
			counters.sendToFront();
		}
		
	}

	@Override public void mouseClicked(MouseEvent e) {
		newX = e.getX();
		newY = e.getY();
		newTurtle = true;

	}
	public void createTurtle(int x, int y){
		turtleCounter++;
		GTurtle toitle = new GTurtle(x, y);
		toitle.hideTurtle();
		toitle.setSpeed(.9);
		toitle.penDown();
		toitle.setColor(randomColor());
		add(toitle);
		turtles.add(toitle);
	}

	public void walk(GTurtle toitle){
		int dir = rand.nextInt(4);
		toitle.setDirection(angle.get(dir));
		toitle.forward(5);
		if(toitle.getX() < 0 || toitle.getX() > WIDTH || toitle.getY() < 0 || toitle.getY() > LENGTH){
			toitle.left(180);
			toitle.forward(5);
		}
		
	}
	private void directions(){
		int n = 0;
		while(n != 720){
			angle.add(n);
			n += 90;
		}		
	}
	public Color randomColor(){
		return new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
	}
}




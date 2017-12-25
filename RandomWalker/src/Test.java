import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import acm.graphics.*;
import acm.graphics.GTurtle;
import acm.program.GraphicsProgram;

public class Test extends GraphicsProgram {
	public void run() {
	setSize(1200, 800);
		Random rand = new Random();
		blockWalk turtle = new blockWalk();
		List<GTurtle> turtles = new ArrayList<GTurtle>();
		GTurtle toitle = turtle.createTurtle(rand.nextInt(1200), rand.nextInt(800));
		turtles.add(toitle);
		add(turtles.get(0));
		while(true){
			turtle.walk(turtles.get(0));
		}

	}

}

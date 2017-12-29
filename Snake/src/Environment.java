import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class Environment extends GraphicsProgram {

	private static final double MOVE = 10;

	private int snakeCounter = 1;

	private boolean anchorCreate = false;
	private boolean gameOver = false;
	private boolean pause = false;

	private GRect food;

	private List<Body> bodies = new ArrayList<Body>();
	private List<Anchor> anchors = new ArrayList<Anchor>();
	private List<Integer> directions = new ArrayList<Integer>();

	public void init() {
		setSize(400, 400);
		GRect background = new GRect(0, 0, getWidth(), getHeight());
		background.setFilled(true);
		add(background);
		bodies.add(new Body(31, 31));
		add(bodies.get(0));
		initFood();
	}

	public void run() {
		addKeyListeners();
		while (true) {
			while (!gameOver) {
				pause(Math.max(40, 100 / bodies.size()));
				createAnchor();
				foodCollideTest();
				snakeMove();
				directions.clear();
			}
			finished();
		}
	}

	private void snakeMove() {

		this.bodies.stream().forEach(body -> {
			collisionTest(body);
			moveSnake(body);
		});
		bodyCollisionTest();
		testOutOfBounds();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyChar() == KeyEvent.VK_SPACE) {
			pause = !pause;
		}
		if (!pause) {
			int direction = getDirection(e.getKeyCode(), bodies.get(0).getDirection());
			if (direction != 0) {
				directions.add(direction);
				anchorCreate = true;
			}

			if (directions.size() != 0) {
				bodies.get(0).setDirection(directions.get(0));
			}
		}
	}

	public int getDirection(int keyCode, int getDirection) {
		if (keyCode == KeyEvent.VK_RIGHT && getDirection != 3 && getDirection != 1) {
			return 1;
		} else if (keyCode == KeyEvent.VK_UP && getDirection != 4 && getDirection != 2) {
			return 2;
		} else if (keyCode == KeyEvent.VK_LEFT && getDirection != 1 && getDirection != 3) {
			return 3;
		} else if (keyCode == KeyEvent.VK_DOWN && getDirection != 2 && getDirection != 4) {
			return 4;
		}
		return 0;
	}

	public void createAnchor() {
		if (anchorCreate && directions.size() != 0) {
			anchors.add(new Anchor(bodies.get(0).getPositionX(), bodies.get(0).getPositionY()));
			add(anchors.get(anchors.size() - 1));
			anchors.get(anchors.size() - 1).setDirection(directions.get(0));
			anchorCreate = false;
		}
	}

	public void pause(int milli) {
		try {
			Thread.sleep(milli);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (pause) {
			pause(milli);
		}
	}

	public void collisionTest(Body body) {
		GObject collider = getElementAt(body.getPositionX() - 1, body.getPositionY() - 1);

		int place = this.bodies.indexOf(body);

		for (int i = 0; i < anchors.size(); i++) {
			if (collider == anchors.get(i)) {
				body.setDirection(anchors.get(i).getDirection());
				if (place == bodies.size() - 1) {
					remove(collider);
					anchors.remove(i);
				}
			}
		}              
	}
	

	public void moveSnake(Body body) {
		switch (body.getDirection()) {
		case 1:
			body.move(MOVE, 0);
			break;
		case 2:
			body.move(0, -MOVE);
			break;
		case 3:
			body.move(-MOVE, 0);
			break;
		case 4:
			body.move(0, MOVE);
			break;
		}
	}

	public void createBody() {
		int end = bodies.size() - 1;
		switch (bodies.get(end).getDirection()) {
		case 1:
			bodies.add(new Body(bodies.get(end).getX() - 10, bodies.get(end).getY()));
			break;
		case 2:
			bodies.add(new Body(bodies.get(end).getX(), bodies.get(end).getY() + 10));
			break;
		case 3:
			bodies.add(new Body(bodies.get(end).getX() + 10, bodies.get(end).getY()));
			break;
		case 4:
			bodies.add(new Body(bodies.get(end).getX(), bodies.get(end).getY() - 10));
			break;
		}
		bodies.get(bodies.size() - 1).setDirection(bodies.get(end).getDirection());
		add(bodies.get(bodies.size() - 1));
	}

	public void testOutOfBounds() {
		int headX = bodies.get(0).getPositionX();
		int headY = bodies.get(0).getPositionY();
		if (headX < 0 || headX > 400 || headY < 0 || headY > 400) {
			gameOver = true;
		}
	}

	public void initFood() {
		food = new GRect(0, 0, 8, 8);
		food.setColor(Color.red);
		food.setFilled(true);
		teleportFood();
		add(food);
	}

	public void teleportFood() {
		Random rand = new Random();
		int x = rand.nextInt(39) * 10 + 1;
		int y = rand.nextInt(39) * 10 + 1;
		GObject tester = getElementAt(x, y);
		if (bodies.contains(tester)) {
			teleportFood();
		} else {
			food.setLocation(x, y);
		}
	}

	public void foodCollideTest() {
		if (bodies.get(0).getPositionX() == food.getX() && bodies.get(0).getPositionY() == food.getY()) {
			createBody();
			teleportFood();
			snakeCounter++;
		}
	}

	public void bodyCollisionTest() {
		Body head = bodies.get(0);
		if(bodies.stream().anyMatch(body -> head.isCollidedWith(body))){
			gameOver = true;
		}
	}

	public void finished() {
		gameOverLabels();
		pause = true;
		pause(1);
		removeAll();
		gameOver = false;
		anchorCreate = false;
		bodies.clear();
		directions.clear();
		snakeCounter = 0;
		init();
	}

	public void gameOverLabels() {
		GLabel gameDone = new GLabel("Game Over! Press Space to play again", 5, 30);
		GLabel score = new GLabel("Score: " + snakeCounter, 5, 60);
		gameDone.setColor(Color.WHITE);
		gameDone.setFont(new Font("Ariel", Font.BOLD, 20));
		score.setColor(Color.WHITE);
		score.setFont(new Font("Ariel", Font.BOLD, 20));
		add(gameDone);
		add(score);
	}
}

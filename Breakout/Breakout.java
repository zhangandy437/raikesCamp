
/*
 * File: Breakout.java
 * -------------------
 * This file will eventually implement the game of Breakout.
 *
 * TODO: Update this file with a description of what your program
 * actually does!
 */

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.Random;

import acm.graphics.GLabel;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.graphics.GRoundRect;
import acm.program.GraphicsProgram;

public class Breakout extends GraphicsProgram {

	private static final long serialVersionUID = 1L;
	private GRoundRect paddle;
	private GOval ball;

	private boolean gameOver = false;
	private boolean play;

	private int winCounter = 0;
	private int turnCounter = 0;

	GLabel end;

	// init tis is comments
	public void init() {
		setSize(Config.getWidth(), Config.getHeight());
		paddleCreate();
		brickCreate();
		gameOver = false;
		winCounter = 0;
		turnCounter = 0;
	}

	private void paddleCreate() {
		paddle = new GRoundRect(Config.getWidth() / 2, Config.getHeight() - Config.getPaddleYOffset(),
				Config.getPaddleWidth(), Config.getPaddleHeight());
		paddle.setFilled(true);
		paddle.setFillColor(Color.BLACK);
		add(paddle);
		createBall();
	}

	private void createBall() {
		ball = new GOval(getWidth() / 2, getHeight() / 2, Config.getBallRadius() * 2, Config.getBallRadius() * 2);
		Color color = randomColor();
		ball.setColor(color);
		ball.setFillColor(color);
		ball.setFilled(true);
		add(ball);

	}

	// brick create
	private void brickCreate() {
		for (int i = 0; i < Config.getNbrickRows(); i++) {
			for (int j = 0; j < Config.getNbricksPerRow(); j++) {
				GRect brick = new GRect(j * Config.getBrickWidth() + j * Config.getBrickSep(),
						i * Config.getBrickHeight() + i * Config.getyDistance() + Config.getBrickYOffset(),
						Config.getBrickWidth(), Config.getBrickHeight());
				Color color = randomColor();
				brick.setColor(color);
				brick.setFilled(true);
				brick.setFillColor(color);
				add(brick);
			}
		}
	}

	// main body
	public void run() {
		Direction direction = new Direction();
		direction.reset();
		addMouseListeners();
		while (true) {
			while (!gameOver) {
				wallDetectX(direction);
				wallDetectY(direction);
				entityDetect(direction);
				ballMove(direction);
				counterCheck();
			}
			gameFinished();
			replay();
		}
	}

	private void gameFinished() {
		if (turnCounter == Config.getNturns()) {
			end = new GLabel("YOU LOST: click to play again", 0, Config.getHeight() - Config.getPaddleYOffset() - 20);
		} else {
			end = new GLabel("YOU WIN: click to play again", 0, Config.getHeight() - Config.getPaddleYOffset() - 20);
		}
		end.setColor(Color.BLACK);
		add(end);
		play = false;
	}

	private void replay() {
		while (!play) {
			pause(1000);
		}
		if (winCounter == 100) {
			removeAll();
			init();
		}
		remove(end);

	}

	private void counterCheck() {
		if (winCounter == 100 || turnCounter == Config.getNturns()) {
			gameOver = true;
		}
	}

	// mouse events
	@Override
	public void mouseMoved(MouseEvent e) {
		if (e.getX() - Config.getPaddleWidth() / 2 > 0 && e.getX() + Config.getPaddleWidth() / 2 < Config.getWidth() && !gameOver) {
			paddle.setLocation(e.getX() - Config.getPaddleWidth() / 2, paddle.getY());
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		play = true;
	}

	// detects wall bouncing
	private void wallDetectY(Direction direction) {
		if (ball.getY() <= 0) {
			direction.invertVerticle();
		}
		if (ball.getY() + Config.getBallRadius() * 2 >= Config.getHeight() + Config.getBallRadius() * 2) {
			turnCounter++;
			remove(ball);
			createBall();
			direction.reset();
			pause(3000);
		}
	}
	private void wallDetectX(Direction direction){
		if (ball.getX() <= 0 || ball.getX() + Config.getBallRadius() * 2 >= Config.getWidth()) {
			direction.invertHorizontal();
		}
	}

	// detect objects
	private void entityDetect(Direction direction) {
		brickYCollisionTest(ball.getX() + Config.getBallRadius(), ball.getY() - 1, direction);
		brickYCollisionTest(ball.getX() + Config.getBallRadius(), ball.getY() + Config.getBallRadius() * 2 + 1, direction);
		brickXCollisionTest(ball.getX() - 1, ball.getY() + Config.getBallRadius(), direction);
		brickXCollisionTest(ball.getX() + Config.getBallRadius() * 2 + 1, ball.getY() + Config.getBallRadius(), direction);
	}

	private void brickYCollisionTest(double inx, double iny, Direction direction) {
		if (getElementAt(inx, iny) == null) {
			return;
		}
		direction.invertVerticle();
		if (getElementAt(inx, iny) != paddle) {
			remove(getElementAt(inx, iny));
			winCounter++;
		}
	}

	private void brickXCollisionTest(double d, double e, Direction direction) {
		if (getElementAt(d, e) == null) {
			return;
		}
		direction.invertHorizontal();
		if (getElementAt(d, e) != paddle) {
			remove(getElementAt(d, e));
			winCounter++;
		}

	}

	private void pause(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// makes ball move
	private void ballMove(Direction direction) {
		ball.move(direction.getHorizontal(), direction.getVerticle());
		pause(5);
	}

	private Color randomColor() {
		Random rand = new Random();
		return new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
	}
	
	private class Direction{
		private int horizontal;
		private int verticle;
		
		int getHorizontal(){
			return horizontal;
		}
		
		void invertHorizontal(){
			horizontal*=-1;
		}
		
		int getVerticle(){
			return verticle;
		}

		void invertVerticle(){
			verticle*=-1;
		}
		
		 void reset(){
			horizontal = new Random().nextInt(2) + 1;
			verticle = -2;
		}
	}
}
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;

public class TriangleThing extends GraphicsProgram {
	
	List<GOval> dividends;
	
	public void init() {
		GImage pic = new GImage("file:///C:/Users/Andy/Pictures/adf.jpg");
		setSize((int) pic.getWidth(), (int) pic.getHeight() + 3);
		GOval first = new GOval((int) pic.getWidth(), (int) pic.getHeight());
		initCircle(first);
	}
	
	public void run() {
		addMouseListeners();
		
	}
	@Override public void mouseMoved(MouseEvent e){
		GOval discard = (GOval) getElementAt(e.getX(), e.getY());
		if(discard != null && discard.getHeight() > 10 && discard.getWidth() > 10){
		divide(discard, (int) discard.getX(), (int) discard.getY());
		}
	}
	
	public void divide(GOval discard1, int x, int y) {
		int width = (int) discard1.getWidth() / 2;
		int height = (int) discard1.getHeight() / 2;
		remove(discard1);
		
		dividends = new ArrayList<GOval>();
		dividends.add(new GOval(x, y, width, height));
		dividends.add(new GOval(x+ width, y, width, height));
		dividends.add(new GOval(x + width, y + height, width, height));
		
		for(GOval s: dividends){
			initCircle(s);
		}
	}
	
	public Color averageColor(int x, int y, int width, int height){
		GImage pic = new GImage("file:///C:/Users/Andy/Pictures/adf.jpg");
		int[][] pixels = pic.getPixelArray();
		int red = 0;
		int green = 0;
		int blue = 0;
		int pixelTotal = 0;
		
		for(int i = 0; i  < height; i++){
			for(int j = 0; j < width; j++){
				int pixel = pixels[i + y][j + x];
				Color pixelColor = new Color(pixel);
				red += pixelColor.getRed();
				green += pixelColor.getGreen();
				blue += pixelColor.getBlue();
				pixelTotal++;
			}
		}
		return new Color(red / pixelTotal, green / pixelTotal, blue / pixelTotal);
	}
	
	public void initCircle(GOval circle){
		Color color = averageColor((int) circle.getX(), (int) circle.getY(), (int) circle.getWidth(), (int) circle.getHeight());
		circle.setColor(color);
		circle.setFilled(true);
		circle.setFillColor(color);
		add(circle);
	}
}

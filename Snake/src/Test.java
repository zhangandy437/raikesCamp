import java.awt.event.MouseEvent;

import acm.graphics.GObject;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class Test extends GraphicsProgram{

	private GRect grect;
	private GRect grect1;
	private GRect grect2;
	public void run() {
		grect = new GRect(0, 0, getWidth(), getHeight());
		grect1 = new GRect(0, 0, getWidth(), getHeight());
		grect2 = new GRect(0, 0, getWidth(), getHeight());
		grect.setFilled(true);
		add(grect);
		add(grect1);
//		add(grect2);
		addMouseListeners();
	}
	@Override public void mouseClicked(MouseEvent e){
		GObject collider = getElementAt(e.getX(), e.getY());
		if(collider == grect){
			System.out.println("poop");
		}
		if(collider == grect && collider == grect1){
			System.out.println("2");
		}
		if(collider == grect1){
			System.out.println("3");
		}
	}

}

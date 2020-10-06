import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.applet.*;

public class GameF20 extends Applet implements Runnable, KeyListener{
	
	/**
	 * 
	 */
	static Thread t;
	
	boolean up_pressed = false;
	boolean down_pressed = false;
	boolean left_pressed = false;
	boolean right_pressed = false;
	
	public static final int UP = KeyEvent.VK_UP;
	public static final int DOWN = KeyEvent.VK_DOWN;
	public static final int LEFT = KeyEvent.VK_LEFT;
	public static final int RIGHT = KeyEvent.VK_RIGHT;
	
	Tank tank1 = new Tank(200,100,90);
	Tank tank2 = new Tank(100,200,90);

	public void init() {
		requestFocus();
		
		addKeyListener(this);
		
		t = new Thread(this);
		t.start();
	}
	
	public void run() {
		while(true) {
			
//			if(up_pressed)    tank1.moveBy(0, -5);
//			if(down_pressed)  tank1.moveBy(0, +5);
//			if(left_pressed)  tank1.moveBy(-5, 0);
//			if(right_pressed) tank1.moveBy(+5, 0);
			
			if(up_pressed) tank1.moveForwardBy(-10);
			if(down_pressed) tank1.moveForwardBy(10);
			if(left_pressed) tank1.rotateBy(3);;
			if(right_pressed) tank1.rotateBy(-3);
			
			tank2.moveBy(1,-1);
			tank2.rotateBy(10);
			
			repaint();
			
			try {
				Thread.sleep(16);
				
			}catch(InterruptedException x){
				
			}
		}
	}
	
	public void paint (Graphics g) {
		
		tank1.draw(g);
		tank2.draw(g);
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == UP ) up_pressed = true;
		if(key == DOWN ) down_pressed = true;
		if(key == LEFT ) left_pressed = true;
		if(key == RIGHT ) right_pressed = true;
	}
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == UP ) up_pressed = false;
		if(key == DOWN ) down_pressed = false;
		if(key == LEFT ) left_pressed = false;
		if(key == RIGHT ) right_pressed = false;
	}
	
	public void keyTyped(KeyEvent e) {
		System.out.println("key typed");
	}

}

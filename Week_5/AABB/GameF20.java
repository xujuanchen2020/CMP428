import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.applet.*;

public class GameF20 extends Applet implements Runnable, KeyListener, MouseListener, MouseMotionListener {
	
	/**
	 * 
	 */
	static Thread t;
	
	Tank tank1 = new Tank(300, 300, 0);
	
	Tank tank2 = new Tank(100, 100, 45);
	
	Rect r1 = new Rect(100, 200, 300, 100);
	Rect r2 = new Rect(400, 400, 300, 150);
	
	boolean overlap = false;
	
	boolean up_pressed = false;
	boolean down_pressed = false;
	boolean left_pressed = false;
	boolean right_pressed = false;
	
	public static final int UP = KeyEvent.VK_UP;
	public static final int DOWN = KeyEvent.VK_DOWN;
	public static final int LEFT = KeyEvent.VK_LEFT;
	public static final int RIGHT = KeyEvent.VK_RIGHT;

	public void init() {
		requestFocus();
		
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		
		t = new Thread(this);
		t.start();
	}
	
	public void run() {
		while(true) {
			
//			if (up_pressed) r1.moveBy(0, -1);
//			if (down_pressed) r1.moveBy(0, 1);
//			if (left_pressed) r1.moveBy(-1, 0);
//			if (right_pressed) r1.moveBy(1, 0);
			
			if (up_pressed) tank1.moveBy(0, -1);
			if (down_pressed) tank1.moveBy(0, 1);
			if (left_pressed) tank1.rotateBy(3);
			if (right_pressed) tank1.rotateBy(-3);
			
			repaint();
			
			try {
				Thread.sleep(16);
				
			}catch(InterruptedException x){
				
			}
		}
	}
	
	public void paint (Graphics g) {
		
		if (tank1.overlaps(tank2)) {
			overlap = true;
			g.setColor(Color.RED);
			
		}else {
			overlap = false;
			g.setColor(Color.BLACK);
		}
		
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

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
//		holding_r1 = false;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
		int mx = e.getX();
		int my = e.getY();
		
//		if(r1.contains(mx, my)) {
//			in_r1 = true;
//		}else {
//			in_r1 = false;
//		}
		
	}


}

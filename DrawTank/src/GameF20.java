import java.awt.*;
import java.awt.event.*;

import java.applet.*;


public class GameF20 extends Applet implements Runnable, KeyListener {
	Thread t;
	
	Tank tank1 = new Tank(100, 100);
	Tank tank2 = new Tank(50, 50);
	
	boolean up_pressed = false;
	boolean dn_pressed = false;
	boolean lt_pressed = false;
	boolean rt_pressed = false;
	
	public void init(){
		requestFocus();
		
		addKeyListener(this);
		
		t = new Thread(this);
		t.start();
	}
	
	public void run(){
		while(true){
			if(up_pressed)  tank1.moveBy(0, -5);
			if(dn_pressed)  tank1.moveBy(0, +5);
			if(lt_pressed)  tank1.moveBy(-5, 0);
			if(rt_pressed)  tank1.moveBy(+5, 0);
			
			tank2.moveBy(1,3);
			
			repaint();  // Ask the OS to call paint (but not directly, paint is called via update)
			
			try{
				t.sleep(16);
			}
			catch(InterruptedException x) {};			
		}
	}	
	
	public static final int UP = KeyEvent.VK_UP;
	public static final int DN = KeyEvent.VK_DOWN;
	public static final int LT = KeyEvent.VK_LEFT;
	public static final int RT = KeyEvent.VK_RIGHT;
	
	public void keyPressed(KeyEvent e){ 
		int key = e.getKeyCode();
		
		if(key == UP)   up_pressed = true;  
		if(key == DN)   dn_pressed = true;
		if(key == LT)   lt_pressed = true;
		if(key == RT)   rt_pressed = true;
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		if(key == UP)   up_pressed = false;  
		if(key == DN)   dn_pressed = false;
		if(key == LT)   lt_pressed = false;
		if(key == RT)   rt_pressed = false;
	}
	
	public void paint(Graphics g){
		g.setColor(Color.RED);
		tank1.draw(g);
		
		g.setColor(Color.BLUE);
		tank2.draw(g);
 	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
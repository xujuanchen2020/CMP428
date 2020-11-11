import java.awt.*;
import java.awt.event.*;

import java.applet.*;


public class GameF20 extends Applet implements Runnable, KeyListener{
	Thread t;
	
	Tank tank1 = new Tank(200, 200, 90);
	Tank tank2 = new Tank(0, 0, 90);
	
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
			if(up_pressed)  tank1.moveForwardBy(10);
			if(dn_pressed)  tank1.moveBy(0, +5);
			if(lt_pressed)  tank1.rotateBy(-3);
			if(rt_pressed)  tank1.rotateBy(+3);
			
			tank2.moveBy(1,3);
			tank2.rotateBy(6);
			
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
	
	public void keyTyped(KeyEvent e){
	}
	
	public void paint(Graphics g){		
		tank1.draw(g);
		tank2.draw(g);
 	}

}
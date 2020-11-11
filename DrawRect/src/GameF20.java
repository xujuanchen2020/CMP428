import java.awt.*;

import java.applet.*;

public class GameF20 extends Applet implements Runnable{
	Thread t;
	Rect r1 = new Rect(10, 10, 200, 100);	
	Rect r2 = new Rect(100, 500, 100, 400);
	Rect r3 = new Rect(10, 100, 300, 20);
	
	public void init(){
		t = new Thread(this);
		t.start();
	}
	
	public void run(){
		while(true){
			r1.moveBy(1, 0);
			r2.moveBy(0, -2);
			repaint();
			try{
				t.sleep(16);
			}
			catch(InterruptedException x) {};			
		}
	}
	
	public void paint(Graphics g){
		
		r1.draw(g);
		r2.draw(g);
		r3.draw(g);	
 	}
}
import java.awt.*; //graphics object

import java.applet.*; 

public class GameFall20 extends Applet {
	
	public void paint(Graphics g) {
//		g.drawLine(1, 1, 200, 200);		
//		drawPoint (200,200,g);
//		drawHLine(0,300,50,15,g);
		
		int[] xp = {100,400,400,100};
		int[] yp = {  0,  0,200,200};
		drawPoly(xp, yp, g);
	}
	
	public void drawPoint(int x, int y, Graphics g) {
		g.drawLine(x, y, x, y);
	}
	
	public void drawHLine(int x1, int x2, int y, int thickness, Graphics g) {
		for (int i=0;i<thickness;i=i+5) {
			for(int x = x1; x<=x2;x++) {
				drawPoint(x,y+i,g);
			}
		}
		
	}
	
	public void drawPoly(int[] xp, int[] yp, Graphics g) {
		for (int i = 0; i < xp.length-1; i++) { // length-1, because xp[i+1] will out of range
			g.drawLine( xp[i], yp[i], xp[i+1], yp[i+1]);
		}
		
		g.drawLine(xp[xp.length-1], yp[yp.length-1], xp[0], yp[0]);
	}

}

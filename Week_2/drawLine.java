import java.awt.*; //graphics object

import java.applet.*; 

public class GameFall20 extends Applet {
	
	public void paint(Graphics g) {
//		g.drawLine(1, 1, 200, 200);		
//		drawPoint (200,200,g);
//		drawHLine(0,300,50,15,g);
		
//		int[] xp = {100,400,400,100};
//		int[] yp = {  0,  0,200,200};
//		drawPoly(xp, yp, g);
		
//		drawVLine(100,100,300,10,g); 
		
		drawLine(100,500,0,200,g);
	}
	
	public void drawPoint(int x, int y, Graphics g) {
		g.drawLine(x, y, x, y);
	}
	
	public void drawLine(int x1, int x2, int y1, int y2, Graphics g) {
		int dy = y2 -y1;
		int dx = x2 - x1;
		
		if (dx == 0) {
			drawVLine(x1,y1,y2,1,g);
		}else {
			{
				double  m = (double)dy / dx;;
				if (m == 0) {
					drawHLine(x1,x2,y1,1,g);
				}else {
					if(m<=1) {
						if(x1 > x2) {
							int temp = x1;
							x1       = x2;
							x2       = temp;
							
							temp     = y1;
							y1       = y2;
							y2       = temp;
						}
						
						double y = y1;
						for (int x = x1; x <=x2; x++) {
							drawPoint(x, (int)y,g);
							y += m;
						}
					}else if (m>1) {
						if(y1 > y2) {
							int temp = y1;
							y1       = y2;
							y2       = temp;
							
							temp     = x1;
							x1       = x2;
							x2       = temp;
						}
						double x = x1;
						for (int y = y1; y <= y2; y++) {
							drawPoint((int)x, y, g);
							x += 1/m;
						}
					}
				}
			}
		}
	}
	
	public void drawHLine(int x1, int x2, int y, int thickness, Graphics g) {
		
		if(x1>x2) {
			int temp = x1;
			x1       = x2;
			x2       = temp;
		}
		
		for (int i=0;i<thickness;i=i+5) {
			for(int x = x1; x<=x2;x++) {
				drawPoint(x,y+i,g);
			}
		}
		
	}
	
	public void drawVLine(int x, int y1, int y2, int thickness, Graphics g ) {
		if(y1 > y2) {
			int temp = y1;
			y1       = y2;
			y2       = temp;
		}
		
		for (int y = y1; y <= y2; y++) {
			for (int i = 0; i < thickness; i++) {
				drawPoint(x+i,y,g);
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

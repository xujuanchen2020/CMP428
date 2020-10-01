import java.awt.Color;
import java.awt.Graphics;


public class Tank {
	
	Color color;
	
	int x;
	int y;
	int A;

	int[] body_x = { -25, 25, 25, -25 };
	int[] body_y = { -40, -40, 40, 40 };
	
	int[] hatch_x = { -10, 10, 10, -10 };
	int[] hatch_y = { -10, -10, 10, 10 };
	
	int[] gun_x = { -3, 3, 3, -3 };
	int[] gun_y = { -35, -35, -10, -10 };
	
	int[] trackL_x = { -35, -25, -25, -35 };
	int[] trackL_y = { -35, -35, 35, 35 };
	
	int[] trackR_x = { 35, 25, 25, 35 };
	int[] trackR_y = { -35, -35, 35, 35 };
	
	public Tank (Color color) {
		this.color = color;
	}
	
	public Tank(int x, int y, int A) {
		this.x = x;
		this.y = y;
		this.A = A;
	}
	
	public void moveBy(int dx, int dy) {
		x += dx;
		y += dy;
	}
	
	public void rotateBy(int dA) {
		A += dA;
	}
	
	public void moveForwardBy(int d) {
		int dx = (int)(d*Math.cos(Math.PI/180*A));
		int dy = (int)(d*Math.sin(Math.PI/180*A));
		
		moveBy(dx,dy);
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		
		int[] x_points = new int[4];
		int[] y_points = new int[4];
		
		// change angle
		for (int i=0; i < x_points.length; i++) {
			x_points[i] = (int) (body_x[i]*Math.cos(Math.PI/180*A) - body_y[i]*Math.sin(Math.PI/180*A)) + x ;
			y_points[i] = (int) (body_y[i]*Math.cos(Math.PI/180*A) + body_x[i]*Math.sin(Math.PI/180*A)) + y ;
		}
		g.drawPolygon(x_points, y_points, 4);
		
		for (int i=0; i < x_points.length; i++) {
			x_points[i] = (int) (hatch_x[i]*Math.cos(Math.PI/180*A) - hatch_y[i]*Math.sin(Math.PI/180*A)) + x ;
			y_points[i] = (int) (hatch_y[i]*Math.cos(Math.PI/180*A) + hatch_x[i]*Math.sin(Math.PI/180*A)) + y ;
		}
		g.drawPolygon(x_points, y_points, 4);
		
		for (int i=0; i < x_points.length; i++) {
			x_points[i] = (int) (gun_x[i]*Math.cos(Math.PI/180*A) - gun_y[i]*Math.sin(Math.PI/180*A)) + x ;
			y_points[i] = (int) (gun_y[i]*Math.cos(Math.PI/180*A) + gun_x[i]*Math.sin(Math.PI/180*A)) + y ;
		}
		g.drawPolygon(x_points, y_points, 4);
		
		for (int i=0; i < x_points.length; i++) {
			x_points[i] = (int) (trackL_x[i]*Math.cos(Math.PI/180*A) - trackL_y[i]*Math.sin(Math.PI/180*A)) + x ;
			y_points[i] = (int) (trackL_y[i]*Math.cos(Math.PI/180*A) + trackL_x[i]*Math.sin(Math.PI/180*A)) + y ;
		}
		g.drawPolygon(x_points, y_points, 4);
		for (int i=0; i < x_points.length; i++) {
			x_points[i] = (int) (trackR_x[i]*Math.cos(Math.PI/180*A) - trackR_y[i]*Math.sin(Math.PI/180*A)) + x ;
			y_points[i] = (int) (trackR_y[i]*Math.cos(Math.PI/180*A) + trackR_x[i]*Math.sin(Math.PI/180*A)) + y ;
		}
		g.drawPolygon(x_points, y_points, 4);
		
	}
}

import java.awt.*;

public class Tank {
	int x;
	int y;
	int A;
	
	double[] cos = Lookup.cos;
	double[] sin = Lookup.sin;

	int[] body_y   = {-25,  25, 25, -25};
	int[] body_x	= {-40, -40, 40,  40};

	int[] hatch_y  = {-10,  10, 10, -10};
	int[] hatch_x  = {-10, -10, 10,  10};

	int[] gun_y    = { -3,   3,   3,  -3};
	int[] gun_x	   = { 35,  35,  10,  10};
 
	int[] trackL_y = {-35, -25, -25, -35};
	int[] trackL_x	= {-35, -35,  35,  35};
 
	int[] trackR_y = { 35,  25,  25,  35};
	int[] trackR_x	= {-35, -35,  35,  35};
	
	public Tank(int x, int y, int A) {
		this.x = x;
		this.y = y;
		this.A = A;
	}
	
	public void moveBy(int dx, int dy) {
	   x += dx;
	   y += dy;
	}
	
	public void moveForwardBy(int d) {
		int dx = (int)(d * cos[A]);
		int dy = (int)(d * sin[A]);

		moveBy(dx, dy);
 	}
	
	public void rotateBy(int dA) {
		A += dA;
		
		if(A > 359)  A -= 360;
		if(A < 0)    A += 360;
	}
	
	public void draw(Graphics g) {
		int[] x_points = new int[4];
		int[] y_points = new int[4];
		
		for(int i = 0; i < x_points.length; i++) {
			x_points[i] = (int)(body_x[i]*cos[A] - body_y[i]*sin[A]) + x;
			y_points[i] = (int)(body_y[i]*cos[A] + body_x[i]*sin[A]) + y;
		}
		
		g.drawPolygon(x_points, y_points , 4);

		for(int i = 0; i < x_points.length; i++) {
			x_points[i] = (int)(hatch_x[i]*cos[A] - hatch_y[i]*sin[A]) + x;
			y_points[i] = (int)(hatch_y[i]*cos[A] + hatch_x[i]*sin[A]) + y;	
		}
		
		g.drawPolygon(x_points, y_points , 4);

		for(int i = 0; i < x_points.length; i++) {
			x_points[i] = (int)(gun_x[i]*cos[A] - gun_y[i]*sin[A]) + x;
			y_points[i] = (int)(gun_y[i]*cos[A] + gun_x[i]*sin[A]) + y;	
		}
		
		g.drawPolygon(x_points, y_points , 4);
		
		for(int i = 0; i < x_points.length; i++) {
			x_points[i] = (int)(trackL_x[i]*cos[A] - trackL_y[i]*sin[A]) + x;
			y_points[i] = (int)(trackL_y[i]*cos[A] + trackL_x[i]*sin[A]) + y;
		}

		g.drawPolygon(x_points, y_points , 4);
		
		for(int i = 0; i < x_points.length; i++) {
			x_points[i] = (int)(trackR_x[i]*cos[A] - trackR_y[i]*sin[A]) + x;
			y_points[i] = (int)(trackR_y[i]*cos[A] + trackR_x[i]*sin[A]) + y;
		}
		
		g.drawPolygon(x_points, y_points , 4);
		
	}
}
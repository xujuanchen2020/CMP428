import java.awt.Color;
import java.awt.Graphics;

public class PolygonModel2D {
	
	int x;
	int y;
	int A;
	
	double[] cos = LookUp.cos;
	double[] sin = LookUp.sin;
	
	int[][] x_structure;
	int[][] y_structure;
	
	public PolygonModel2D(int x, int y, int A, int[][] x_structure, int[][] y_structure) {
		this.x = x;
		this.y = y;
		
		this.A = A;
		
		this.x_structure = x_structure;
		this.y_structure = y_structure;
		
		
	}
	

	public void moveBy(int dx, int dy) {
		x += dx;
		y += dy;
	}
	
	public void rotateBy(int dA) {
		A += dA;
		
		if(A > 359) A -= 360;
		if(A < 0) A += 360;
	}
	
	public void moveForwardBy(int d) {
		int dx = (int)(d*cos[A]);
		int dy = (int)(d*sin[A]);
		
		moveBy(dx,dy);
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		
		int _x;
		int _y;
		int[] x_points = new int[4];
		int[] y_points = new int[4];
		
		for(int polygon = 0; polygon < x_structure.length; polygon++) {
			for(int vertex = 0; vertex < x_points.length; vertex++) {
				_x = x_structure[polygon][vertex];
				_y = y_structure[polygon][vertex];
				
				x_points[vertex] = (int)(_x*cos[A] - _y*sin[A] + x);
				y_points[vertex] = (int)(_y*cos[A] + _x*sin[A] +y);
				
			}
			g.drawPolygon(x_points, y_points, 4);
		}		
		
	}
	
}

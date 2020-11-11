import java.awt.*;

public class Tank{
	int x;
	int y;
	
	int[] body_x   = {-25,  25, 25, -25};
	int[] body_y   = {-40, -40, 40,  40};
			 
	int[] hatch_x = {-10,  10, 10, -10};
	int[] hatch_y = {-10, -10, 10,  10};

	int[] gun_x = { -3,   3,   3,  -3};
	int[] gun_y	= {-35, -35, -10, -10};
			 
	int[] trackL_x = {-35, -25, -25, -35};
	int[] trackL_y	= {-35, -35,  35,  35};
			 
	int[] trackR_x = { 35,  25,  25,  35};
	int[] trackR_y	= {-35, -35,  35,  35};
	
	public Tank(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void moveBy(int dx, int dy){
	   x += dx;
	   y += dy;
	}
	
	public void draw(Graphics g){
		int[] x_points = new int[4];
		int[] y_points = new int[4];
		
		for(int i = 0; i < x_points.length; i++){
			x_points[i] = body_x[i] + x;
			y_points[i] = body_y[i] + y;			
		}
		
		g.drawPolygon(x_points, y_points , 4);
		
		for(int i = 0; i < x_points.length; i++){
			x_points[i] = hatch_x[i] + x;
			y_points[i] = hatch_y[i] + y;			
		}
		
		g.drawPolygon(x_points, y_points , 4);

		
		for(int i = 0; i < x_points.length; i++){
			x_points[i] = gun_x[i] + x;
			y_points[i] = gun_y[i] + y;			
		}
		
		g.drawPolygon(x_points, y_points , 4);
		
		for(int i = 0; i < x_points.length; i++){
			x_points[i] = trackL_x[i] + x;
			y_points[i] = trackL_y[i] + y;
		}
		
		g.drawPolygon(x_points, y_points , 4);
		
		for(int i = 0; i < x_points.length; i++){
			x_points[i] = trackR_x[i] + x;
			y_points[i] = trackR_y[i] + y;			
		}
		
		g.drawPolygon(x_points, y_points , 4);

	}
}
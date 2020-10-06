import java.awt.Graphics;

public abstract class UsePolygonModel {
	
	PolygonModel2D model;
	
	public abstract int[][] gen_x_structure();
	public abstract int[][] gen_y_structure();
	
	public UsePolygonModel(int x, int y, int A) {
		model = new PolygonModel2D(x, y, A, gen_x_structure(), gen_y_structure());
	}
	
	public void moveForwardBy(int d) {
		model.moveForwardBy(d); 		
	}
	
	public void rotateBy(int dA) {
		model.rotateBy(dA);
	}
	
	public void moveBy(int dx, int dy) {
		model.moveBy(dx, dy);
	}
	
	public void draw(Graphics g) {
		model.draw(g);
	}

}

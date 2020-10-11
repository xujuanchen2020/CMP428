import java.awt.Color;
import java.awt.Graphics;


public class Tank extends PolygonModel2D{
	
	public static int[][] tank_x_structure = {
		{ -25, 25, 25, -25 },
		{ -10, 10, 10, -10 },
		{ -3, 3, 3, -3 },
		{ -35, -25, -25, -35 },
		{ 35, 25, 25, 35 },
		{4,20,30,5},
		{4,20,40,5},
		{-4,-20,-30,-5},
		{-4,-20,-30,-5}
	};
	
	public static int[][] tank_y_structure = {
		{ -40, -40, 40, 40 },
		{ -10, -10, 10, 10 },
		{ -35, -35, -10, -10 },
		{ -35, -35, 35, 35 },
		{ -35, -35, 35, 35 },
		{3,3,70,50},
		{-3,-3,-70,-50},
		{3,3,70,50},
		{-3,-3,-70,-50}
	};

	public Tank (int x, int y, int A) {
		super(x,y,A,tank_x_structure,tank_y_structure);
	}
	
}

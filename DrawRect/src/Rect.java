import java.awt.Graphics;

public class Rect
{
	int x;
	int y;
	
	int w;
	int h;
	
	
	public Rect(int x, int y, int w, int h)
	{
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	
	public void moveBy(int dx, int dy)
	{
		x += dx;
		y += dy;		
	}
	
	
	public void draw(Graphics g)
	{
		g.drawRect(x, y, w, h);
	}
}

public class Pixel {
	private int x;
	public Pixel(int x1, int y1, int c1)
	{
		x=x1;
		y=y1;
		color=c1;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	private int y;
	private int color;

}

import java.awt.Color;

public abstract class VirtualObject implements Displayable{

	protected float x,y; 
	protected int width,height; 
	
	public Vector getPosition() {
		return position;
	}

	public void setPosition(Vector position) {
		this.position = position;
	}
	protected Vector position; //position vector
	
	protected Color color; 
	
	VirtualObject(){
		width = 50; 
		height = 50; 
		x = 0; 
		y = 0; 
		color = new Color(0);
	}
	
	public float getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	
	
}

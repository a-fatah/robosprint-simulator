import java.awt.Color;

import processing.core.PApplet;


public class Destination extends VirtualObject implements Displayable{

	PApplet parent; 
	int radius; 
	
	public Destination(int x, int y,PApplet parent){
		super();
		this.parent = parent;
		this.x = x; 
		this.y = y; 
		color = new Color(0,255,0);
		radius = 50;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		parent.ellipseMode(PApplet.CENTER);
		parent.fill(color.getRGB());
		parent.noStroke();
		parent.ellipse(x,y,radius,radius);
		parent.noFill();
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	
}

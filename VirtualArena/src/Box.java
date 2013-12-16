import java.awt.Color;

import processing.core.PApplet;


public class Box extends VirtualObject implements Displayable{

	PApplet parent; 
	
	public Box(int x, int y, PApplet parent){
		super();
		this.parent = parent;
		this.x = x; 
		this.y = y; 
		color = new Color(0,0,255);
		
	}
	
	public void display(){
		parent.rectMode(PApplet.CENTER);
		parent.fill(this.color.getRGB());
		parent.noStroke();
		parent.rect(x,y,width,height);
		parent.noFill();
	}
	
}

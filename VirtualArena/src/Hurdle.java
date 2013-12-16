import java.awt.Color;

import processing.core.PApplet;


public class Hurdle extends VirtualObject{
	
	PApplet parent; 
	public Hurdle(int x, int y,PApplet parent){
		
		this.x = x; 
		this.y = y; 
		this.width = 50; 
		this.height = 50; 
		color = new Color(255,0,0);
		this.parent = parent;
	}

	public void display(){
		parent.rectMode(PApplet.CENTER);
		parent.fill(color.getRGB());
		parent.noStroke();
		parent.rect(x,y,width,height);
		parent.noFill();
	}

	public void setColor(int newColor){
		this.color = new Color(newColor);
	}

}

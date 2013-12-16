import java.awt.Toolkit;

import javax.swing.JOptionPane;

import processing.core.PApplet;
import processing.core.PImage;

public class Robot extends VirtualObject implements Receiver,Movable{

	PApplet parent; 
	private float speed; //speed at which robot moves
	
	private float degrees; 
	
	private Vector orientation; //orientation vector
	
	Controller controller;
	
	PImage icon; 
	private String name;
	Robot(String name,int x, int y,PApplet parent){
		this.parent = parent;
		this.name = new String(name);

		controller = new Controller(this);
		
		this.x = x; 
		this.y = y; 
		
		position = new Vector(x,y); //set position vector
		
		updateAndShowOrientation();
		
		this.width = 50; 
		this.height = 50; 

		speed = 5;

		degrees = -90.0f; //orientation angle in degrees

		icon = parent.loadImage("android2.png");
		
	}
	
	

	public void setName(String name) {
		this.name = name;
	}

	public void display(){
		parent.imageMode(PApplet.CENTER);
		parent.pushMatrix();
		parent.translate(x,y);
		parent.rotate((float)Math.toRadians(degrees));
		parent.image(icon,0,0,width,height);
		
		parent.popMatrix();
		parent.textSize(10);
		parent.text(name, x, y);

		updateAndShowOrientation();
		
	    parent.stroke(2.0f);
	    parent.fill(0);
	    
	    float start = 0; 
	    float stop = PApplet.radians(degrees);
	    
	    parent.noFill();
	    parent.stroke(150,0,0);
	    if (stop < 0) {
	    	parent.arc(this.x, this.y, 20, 20, stop, start);
			
		}else{
			parent.arc(this.x, this.y, 20, 20, start, stop);
		}
		parent.noStroke();
		
		
	}
	
	private void updateAndShowOrientation() {
		// TODO Auto-generated method stub
		
		
		parent.stroke(2.0f);
		parent.line(x-30,y,x+30,y);

		float degreesInRadians = PApplet.radians(this.degrees);
		float x = (float)(30*Math.cos(degreesInRadians));
		float y = (float)(30*Math.sin(degreesInRadians));
		parent.line(this.x, this.y, this.x+x, this.y+y);
		
		position = new Vector(getX(),getY());
		Vector arrow = new Vector(x+this.x,y+this.y).minus(position);
		Vector base = new Vector(this.x+1,y).plus(position);
		
//		System.out.println("position vector : "+position);
		orientation = new Vector(x,y).minus(position);
		
		
		orientation = orientation.direction();
		
//		System.out.println(Vector.angleBetween(new Vector(this.x+1,this.y), orientation));
		System.out.println("base: "+base);
		System.out.println("arrow: "+arrow);
		System.out.println(Vector.angleBetween(base,arrow));
		
		
	}



	public float getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	

	@Override
	public void turnRight(float degrees) {
		// TODO Auto-generated method stub
		this.degrees += degrees; 
		this.degrees %= 360;
		
		//update orientation vector
		
		
//		System.out.println(orientation);
	}

	@Override
	public void turnLeft(float degrees) {
		// TODO Auto-generated method stub
		//find angle from orientation vector
		
		this.degrees -= degrees; 
		this.degrees %= 360;
		//update orientation vector
	    float x = (float)(10*Math.cos(this.degrees));
	    float y = (float)(10*Math.sin(this.degrees));
	    parent.line(this.x, this.y, this.x+x, this.y+y);
//		x = x*Math.cos(this.degrees)-y*Math.sin(this.degrees);
//		y = y*Math.sin(this.degrees)+y*Math.cos(this.degrees);
//		orientation = new Vector((float)x,(float)y).direction();
//		System.out.println(orientation);
	}

	@Override
	public void moveForward(int d) {
		float _x = (this.x + d*PApplet.cos(PApplet.radians(degrees)));
		float _y = (this.y + d*PApplet.sin(PApplet.radians(degrees)));
		if ((_x > 0 && _x < parent.width)   //out-of-boundary check
				&& (_y > 0 && _y < parent.height)) {
			x = _x;
			y = _y;
		} 
		else{
			Toolkit.getDefaultToolkit().beep();
//			System.err.println("out of boundary");
		}
		
		
		float x = (float)(10*Math.cos(this.degrees));
	    float y = (float)(10*Math.sin(this.degrees));
	    parent.line(this.x, this.y, this.x+x, this.y+y);
	    
	}

	@Override
	public void moveBackward(float d) {
		float _x = (x - d*PApplet.cos(PApplet.radians(degrees)));
		float _y = (y - d*PApplet.sin(PApplet.radians(degrees)));
		if ((_x > 0 && _x < parent.width) 
				&& (_y > 0 && _y < parent.height)) {
			x = _x;
			y = _y;
		}else{
			Toolkit.getDefaultToolkit().beep();
			System.err.println("Out of boundary");
		}
		
		float x = (float)(10*Math.cos(this.degrees));
	    float y = (float)(10*Math.sin(this.degrees));
	    parent.line(this.x, this.y, this.x+x, this.y+y);

	}
	
	@Override
	public void receiveCommand(int cmd) {
		// TODO Auto-generated method stub
		switch(cmd){
			case 1:
			//left
			turnLeft(5); //turn left by 5 degrees
			break; 
			case 2:
			//down 
			moveBackward(5); //move backward 5 units
			break; 
			
			case 3:
			//right
			turnRight(5);	
			break; 
			
			case 5:
			//up
			moveForward(5);	
			break;
		}
		
	}



	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name; 
	}
	

}

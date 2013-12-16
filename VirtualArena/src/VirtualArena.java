import processing.core.PApplet;
import processing.core.PFont;

public class VirtualArena extends PApplet{

	Hurdle h1; 
	Hurdle h2; 
	Destination d; 
	Robot droid; 
//	Robot droid2;
//	Robot droid3; 
	Box box;
	
	public void setup(){
		
		size(500,520); 
		
		h1 = new Hurdle(100,100,this);
		h2 = new Hurdle(220+100,height/2+100,this);
		d = new Destination(width/2,30,this);
		droid = new Robot("droid",width-50,height-50,this);
//		droid2 = new Robot("droid2",width-50,height-50,this);
//		droid3 = new Robot("droid3",width-50,height-50,this);
		box = new Box(220,200,this);
		PFont font = createFont("Georgia",32);  
		textFont(font);
	}

	public void draw(){
		background(255);
		droid.display();
//		droid2.display();
//		droid3.display();
		h1.display();
		h2.display();
		d.display();
		box.display();
				
	}
	
}
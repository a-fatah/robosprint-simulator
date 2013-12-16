import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import javax.swing.JFrame; 
import javax.swing.JPanel; 
import javax.swing.JLabel; 
import java.awt.Rectangle; 
import java.net.*; 
import java.io.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class RemoteControl extends PApplet {

	// IO streams
	private DataOutputStream toArena;
	private DataInputStream fromArena;



	Rectangle rectUp, rectDown, rectRight, rectLeft; 


	public void setup(){
		size(400,420); 

		//  arduinoPort = new Serial(this,"COM25",9600); 
		background(255); 

		try {

			// Create a socket to connect to the server

			String ip = javax.swing.JOptionPane.showInputDialog("Enter IP of PC running VirtualArena: ");
			if(ip.length() == 0){
				javax.swing.JOptionPane.showMessageDialog(null,"No IP entered!");
				exit();
			}

			Socket socket = new Socket(ip, 8000);

			// Socket socket = new Socket("130.254.204.36", 8000);
			// 
			// Create an input stream to receive data from the server
			fromArena = new DataInputStream(
					socket.getInputStream());
			// Create an output stream to send data to the server
			toArena =
					new DataOutputStream(socket.getOutputStream());
			println("input streams established between remote control and arena...");

		}
		catch (IOException ex) {
			println(ex);
		}   

	}

	public void draw(){

		PImage robotIcon = loadImage("robot2.png"); 

		PImage leftIcon = loadImage("left.png"); 
		PImage rightIcon = loadImage("right.png"); 
		PImage upIcon = loadImage("up.png"); 
		PImage downIcon = loadImage("down.png"); 


		rectLeft = new Rectangle(200-80-40,195+80,80,80); 
		rectDown = new Rectangle(200-40,195+80,80,80); 
		rectRight = new Rectangle(200+80-40,195+80,80,80); 
		rectUp = new Rectangle(200-40,195-80+80,80,80); 


		imageMode(CENTER); 
		image(robotIcon,200,70,150,150); 

		pushMatrix(); 
		translate(0,120); 
		imageMode(CENTER); 
		image(leftIcon,200-80,195,80,80); 
		image(downIcon,200,195,80,80); 
		image(rightIcon,200+80,195,80,80); 
		image(upIcon,200,195-80,80,80); 
		popMatrix(); 

	}

	public void mousePressed(){

		try{
			if(rectUp.contains(mouseX,mouseY)){
				//javax.swing.JOptionPane.showMessageDialog(null,"Up pressed!");
				println("UP!");  
				//   arduinoPort.write('w'); 
				toArena.writeChar('w');
			}
			if(rectDown.contains(mouseX,mouseY)){
				println("DOWN!");  
				//    arduinoPort.write('s');
				toArena.writeChar('s');

			}
			if(rectRight.contains(mouseX,mouseY)){
				println(6); 
				//    arduinoPort.write('d');
				toArena.writeChar('d');

			}
			if(rectLeft.contains(mouseX,mouseY)){
				println("LEFT!"); 
				//    arduinoPort.write('a');
				toArena.writeChar('a');

			}
		}catch(Exception e){
			println(e);
		}

	}

	public void keyPressed(){

		try{
			if(key == CODED){
				int code = keyCode; 

				switch(code){
				case UP: 
					//      arduinoPort.write('w');
					toArena.writeChar('w');
					break;

				case DOWN:
					//      arduinoPort.write('s');
					toArena.writeChar('s');

					break;

				case LEFT:
					//      arduinoPort.write('a');
					toArena.writeChar('a');
					break; 

				case RIGHT:
					//      arduinoPort.write('d');
					toArena.writeChar('d');
					break;      
				}
			}
		}catch(Exception e){
			println(e);
		}
	}

	static public void main(String[] passedArgs) {
		String[] appletArgs = new String[] { "RemoteControl" };
		if (passedArgs != null) {
			PApplet.main(concat(appletArgs, passedArgs));
		} else {
			PApplet.main(appletArgs);
		}
	}
}
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

class ImageWindow extends JFrame {
    
    Image image; 
    int x = 0; 
    int y = 0; 
    
    ImageWindow(){
      
      setLayout(new FlowLayout(FlowLayout.CENTER)); 
      
      //set image property
      try {
		
    	  this.image = ImageIO.read(new File("sample.jpg"));
    	  
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      
      setSize(500,400);
      setVisible(true);
      setLocationRelativeTo(null);
      
    }
    
    void refresh(Image newImage){
       this.image = newImage;
      repaint(); 
      
    }
    
    
    
    @Override
    public void paint(Graphics g){
      super.paint(g); 
      g.drawImage(image, x, y, 500, 400, null);
      
      
    }
    
       public static void main(String[] args){
//    	   ImageWindow window = new ImageWindow();
       }
    
  }//end of ImagePanel class
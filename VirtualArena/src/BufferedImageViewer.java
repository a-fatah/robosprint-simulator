import java.awt.FlowLayout;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class BufferedImageViewer extends JFrame {
	BufferedImage image;
	public BufferedImageViewer(BufferedImage bufferedImage) {
		this.image = bufferedImage;
		
		this.getContentPane().setLayout(new FlowLayout());
		this.getContentPane().add(new JLabel(new ImageIcon(image)));
		this.pack();
		this.setVisible(true);
		
	}

}

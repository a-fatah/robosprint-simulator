import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Test2 extends JFrame{

	Receiver receiver; 
	JPanel buttonPanel; 
	
	JButton btnUp; 
	JButton btnDown; 
	JButton btnLeft; 
	JButton btnRight; 
	
	public Test2(Receiver receiver) {
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout());
		this.receiver = receiver;
		
		JPanel buttonPanel = new JPanel(new GridLayout(2, 3));
		
		btnUp = new JButton("Up");
		
		btnDown = new JButton("Down");
//		btnDown.addActionListener(this);
		
		btnLeft = new JButton("Left");
//		btnLeft.addActionListener(this); 
		
		btnRight = new JButton("Right");
//		btnRight.addActionListener(this);
		
		buttonPanel.add(new JPanel());
		buttonPanel.add(btnUp);
		buttonPanel.add(new JPanel());
		buttonPanel.add(btnLeft);
		buttonPanel.add(btnDown);
		buttonPanel.add(btnRight);
		
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("typed");
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("released");
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("pressed");
			}
		});
		
		JPanel iconPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		ImageIcon icon = new ImageIcon(getClass().getResource("robot2.png"));
		icon = new ImageIcon(icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
		JLabel iconLabel = new JLabel(icon);
		iconPanel.add(iconLabel);
		
		add(iconPanel,BorderLayout.CENTER);
		add(buttonPanel,BorderLayout.SOUTH);
		
		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}
	
	public static void main(String[] args){
		
	}
	
	
}

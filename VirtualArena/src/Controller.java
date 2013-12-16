import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Controller extends JFrame implements MouseListener,KeyListener{
	
	Receiver receiver; 
	JPanel buttonPanel; 
	
	JButton btnUp; 
	JButton btnDown; 
	JButton btnLeft; 
	JButton btnRight; 
	
	Runnable sender;//used for sending commands
	Thread thread; 
	
	boolean buttonPressed = false; 
	Object pressed;
	
	public Controller(final Receiver receiver) {
		setLayout(new BorderLayout());
		this.receiver = receiver;
		
		sender = new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					while(buttonPressed){
						
						if (pressed instanceof JButton) { //if gui button pressed
							if (pressed == btnUp) {
								receiver.receiveCommand(ControllerConstants.UP);
							} else if (pressed == btnDown) {
								receiver.receiveCommand(ControllerConstants.DOWN);
							} else if (pressed == btnLeft) {
								receiver.receiveCommand(ControllerConstants.LEFT);
							} else if (pressed == btnRight) {
								receiver.receiveCommand(ControllerConstants.RIGHT);
							}
						}else if(pressed instanceof KeyEvent){ //if keyboard key pressed
							
							int code = ((KeyEvent) pressed).getKeyCode();
							switch(code){
							case KeyEvent.VK_UP:
								receiver.receiveCommand(ControllerConstants.UP);
								break; 
							case KeyEvent.VK_DOWN:
								receiver.receiveCommand(ControllerConstants.DOWN);
								break; 
							case KeyEvent.VK_LEFT:
								receiver.receiveCommand(ControllerConstants.LEFT);
								break;
							case KeyEvent.VK_RIGHT:
								receiver.receiveCommand(ControllerConstants.RIGHT);
								break;
							}
						}
						
						try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
						}
						
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					
				}
			}
			
		};
		
		thread = new Thread(sender);
		
		JPanel buttonPanel = new JPanel(new GridLayout(2, 3));
		ImageIcon upIcon = new ImageIcon(new ImageIcon("up.png").getImage()
				.getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		ImageIcon downIcon = new ImageIcon(new ImageIcon("down.png").getImage()
				.getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		ImageIcon leftIcon = new ImageIcon(new ImageIcon("left.png").getImage()
				.getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		ImageIcon rightIcon = new ImageIcon(new ImageIcon("right.png").getImage()
				.getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		
		
		btnUp = new JButton("Up",upIcon);
		btnUp.addMouseListener(this);
		btnUp.setBackground(Color.WHITE);
		btnUp.setFocusPainted(false);
		btnUp.setBorderPainted(false);
		
		btnDown = new JButton("Down",downIcon);
		btnDown.addMouseListener(this);
		btnDown.setBackground(Color.WHITE);
		btnDown.setFocusPainted(false);
		btnDown.setBorderPainted(false);
		
		btnLeft = new JButton("Left",leftIcon);
		btnLeft.addMouseListener(this);
		btnLeft.setBackground(Color.WHITE);
		btnLeft.setFocusPainted(false);
		btnLeft.setBorderPainted(false);
		
		btnRight = new JButton("Right",rightIcon);
		btnRight.addMouseListener(this);
		btnRight.setBackground(Color.WHITE);
		btnRight.setFocusPainted(false);
		btnRight.setBorderPainted(false);
		
		buttonPanel.add(new JPanel());
		buttonPanel.add(btnUp);
		buttonPanel.add(new JPanel());
		buttonPanel.add(btnLeft);
		buttonPanel.add(btnDown);
		buttonPanel.add(btnRight);
		
		JPanel iconPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		ImageIcon icon = new ImageIcon(getClass().getResource("robot2.png"));
		icon = new ImageIcon(icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
		JLabel iconLabel = new JLabel(icon);
		iconPanel.add(iconLabel);
		
		JPanel header= new JPanel(new FlowLayout(FlowLayout.CENTER));
		header.add(new JLabel("Controller : "+receiver.getName()));
		add(header,BorderLayout.NORTH);
		add(iconPanel,BorderLayout.CENTER);
		add(buttonPanel,BorderLayout.SOUTH);
		setFocusable(true);
		addKeyListener(this);
		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		buttonPressed = true;
		pressed = e.getSource();
		
		thread = new Thread(sender);
		thread.start();
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		buttonPressed = false;
		if(thread.isAlive())
			thread.stop();
		
		requestFocus();
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		buttonPressed = true;
		pressed = e;
		
		thread = new Thread(sender);
		thread.start();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		buttonPressed = false;
		if(thread.isAlive())
			thread.stop();
		
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	

}

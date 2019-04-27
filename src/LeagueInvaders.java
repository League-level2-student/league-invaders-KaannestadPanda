import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class LeagueInvaders {
JFrame frame;
final static int width=500;
final static int height=800;
GamePanel gamepanel;

	public static void main(String[] args) {
	
	LeagueInvaders k=new LeagueInvaders();
	k.setup();
	}
	
	LeagueInvaders(){
		frame=new JFrame();
		gamepanel= new GamePanel();
	}
	
	void setup() {
		frame.add(gamepanel);
		frame.addKeyListener(gamepanel);
		frame.getContentPane().setPreferredSize(new Dimension(width, height));
		frame.pack();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		gamepanel.startGame();
	}
	
	
}

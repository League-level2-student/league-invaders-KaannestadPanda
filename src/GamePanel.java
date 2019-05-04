import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener,KeyListener{
	
	Rocketship ship=new Rocketship(250,700,50,50);
	
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	ObjectManager manager=new ObjectManager(ship);
	Timer timer;
	Font titleFont=new Font("Arial",Font.PLAIN,24);
	
	void updateMenuState() {
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("keytyped");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==10) {
			
				currentState++;
			
			if(currentState>END_STATE) {
				currentState=MENU_STATE;
			}
		}
		if(e.getKeyCode()==32) {
			ship.spacePressed=true;
		}
		
		 if(e.getKeyCode()==37) {
			ship.leftPressed=true;
		}
		 if(e.getKeyCode()==39) {
			ship.rightPressed=true;
		}
		 
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==37) {
			ship.leftPressed=false;
		}
		else if(e.getKeyCode()==39) {
			ship.rightPressed=false;
		}
		if(e.getKeyCode()==32) {
			ship.spacePressed=false;
		}
		
	}
	
void updateGameState() {
	if(ship.spacePressed==true) {
		manager.addProjectile(new Projectile(ship.x+25, ship.y, 10, 10));
	}
		manager.update();
	}

void updateEndState() {
	
}
void drawMenuState(Graphics g) {
	
	g.setFont(titleFont);
	
	g.setColor(Color.BLUE);
	g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
	g.setColor(Color.WHITE);
	g.drawString("lets blast some aliens", 0, 100);
	g.drawString("BOIIIII", 0, 130);
}

void drawGameState(Graphics g) {
	g.setColor(Color.BLACK);
	g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
	manager.draw(g);
}

void drawEndState(Graphics g) {
	g.setColor(Color.RED);
	g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
	g.setFont(titleFont);
	g.setColor(Color.WHITE);
	g.drawString("GAME OVER", 0, 100);
	g.drawString("lul u died", 0, 130);
}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		if(currentState==MENU_STATE) {
			updateMenuState();
		}
		else if(currentState==GAME_STATE) {
			updateGameState();
		}
		else if(currentState==END_STATE) {
			updateEndState();
		}
		
		
	}
	
	GamePanel(){
		timer = new Timer(1000/60,this);
		
	}
	
	void startGame() {
		timer.start();
	}
	
	@Override

	public void paintComponent(Graphics g){
		if(currentState==MENU_STATE) {
			drawMenuState(g);
		}
		else if(currentState==GAME_STATE) {
			drawGameState(g);
		}
		else if(currentState==END_STATE) {
			drawEndState(g);
		}
		

	}

	
	
}

import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject{
int sped=5;
	Alien(int newX, int newY, int newWidth, int newHeight) {
		super(newX, newY, newWidth, newHeight);
		// TODO Auto-generated constructor stub
	}
	
	void update(){
		if(y>800) {
			isAlive=false;
		}
		y+=sped;
		super.update();
	}
	
	void draw(Graphics g) {
		
		g.drawImage(GamePanel.alienImg,x,y,width,height,null);
		
	}
	
	
}

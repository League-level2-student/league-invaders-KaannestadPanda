import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject{
int sped=10;
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
		
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);
		
	}
	
	
}

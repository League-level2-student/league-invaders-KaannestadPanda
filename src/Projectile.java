import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject{
	
	int speed=10;

	Projectile(int newX, int newY, int newWidth, int newHeight) {
		super(newX, newY, newWidth, newHeight);
		// TODO Auto-generated constructor stub
	}

	void draw(Graphics g) {
		g.drawImage(GamePanel.bulletImg,x,y,width,height,null);
	}
	
	void update() {
		
		y-=speed;
		super.update();
		if(y<=0) {
			isAlive=false;
		}
	}
	
}

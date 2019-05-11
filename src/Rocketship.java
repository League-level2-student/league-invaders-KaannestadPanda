import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{
int speed;
	Rocketship(int newX, int newY, int newWidth, int newHeight) {
		super(newX, newY, newWidth, newHeight);
		// TODO Auto-generated constructor stub
		speed=5;
	}

void update() {
	
	if(rightPressed==true) {
		x+=speed;
	}
if(leftPressed==true) {
	x-=speed;
	}
super.update();
}

void draw(Graphics eg) {
	eg.setColor(Color.BLUE);
	eg.fillRect(x, y, width, height);
}
	
	
	
	
	
	
	
}

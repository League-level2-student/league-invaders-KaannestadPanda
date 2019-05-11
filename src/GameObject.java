import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class GameObject {
	Boolean leftPressed=false;
	Boolean rightPressed=false;
	Boolean spacePressed=false;
	Boolean isAlive=true;
	int x;
    int y;
    int width;
    int height;
    Rectangle collisionBox;

GameObject(int newX, int newY, int newWidth, int newHeight){
	x=newX;
	y=newY;
	width=newWidth;
	height=newHeight;
	collisionBox=new Rectangle(x,y,width,height);
}

void update() {
	collisionBox.setBounds(x, y, width, height);
}

void draw(Graphics ge) {
	
}

	
}

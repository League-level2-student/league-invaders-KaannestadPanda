import java.awt.Graphics;
import java.util.Random;

public class GameObject {
	int x;
    int y;
    int width;
    int height;

GameObject(int newX, int newY, int newWidth, int newHeight){
	x=newX;
	y=newY;
	width=newWidth;
	height=newHeight;
}

void update() {
	Random widthran = new Random();
	x=widthran.nextInt(LeagueInvaders.width-99);
	Random heightran = new Random();
	y=heightran.nextInt(LeagueInvaders.height-99);
}

void draw(Graphics ge) {
	ge.fillRect(x,y,100,100);
}

	
}

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
long enemyTimer=0;
int enemySpawnTime=2000;
	int score=0;
	
	int getScore() {
		return score;
	}
	
	
	

	Rocketship rock;
	ArrayList<Projectile> project=new ArrayList<Projectile>();
	
	ArrayList<Alien> enemy=new ArrayList<Alien>();
	
	ObjectManager(Rocketship r){
		rock=r;
		
	}
	
	void update() {
		rock.update();
		
		for(int i=project.size()-1;i>0;i--) {
			project.get(i).update();
		}
		for(int i=enemy.size()-1;i>0;i--) {
			enemy.get(i).update();
		}
	}
	
	void draw(Graphics g) {
		rock.draw(g);
		for(int i=project.size()-1;i>0;i--) {
			project.get(i).draw(g);
		}
		for(int i=enemy.size()-1;i>0;i--) {
			enemy.get(i).draw(g);
		}
	}
	
	void addProjectile(Projectile p){
		project.add(p);
	}
	
	void addAlien(Alien a) {
		enemy.add(a);
	}
	
	void manageEnemies() {
	    if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
            addAlien(new Alien(new Random().nextInt(LeagueInvaders.width-50), -60, 50, 50));

enemyTimer = System.currentTimeMillis();

    }
	    
	}
	
	void purgeObjects() {
		
		for(int i=enemy.size()-1;i>0;i--) {
			if(enemy.get(i).isAlive==false) {
				enemy.remove(i);
				
			}
			
		}
		for(int i=project.size()-1;i>0;i--) {
		if(project.get(i).isAlive==false) {
			project.remove(i);
		}
		}
		
	}
	
	void checkCollision() {
		
		for(int g=enemy.size()-1;g>0;g--){

	        if(rock.collisionBox.intersects(enemy.get(g).collisionBox)){

	                rock.isAlive = false;

	         }

	}
		
		for(int i=project.size()-1;i>0; i--) {
			for(int g=enemy.size()-1;g>0;g--) {
				if(project.get(i).collisionBox.intersects(enemy.get(g).collisionBox)&&enemy.get(g).isAlive==true) {
					project.get(i).isAlive=false;
					enemy.get(g).isAlive=false;
					score++;
				}
				
			}
			
		}
		
	}
	
}

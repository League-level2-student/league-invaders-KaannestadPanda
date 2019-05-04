import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {

	

	Rocketship rock;
	ArrayList<Projectile> project=new ArrayList<Projectile>();
	
	ObjectManager(Rocketship r){
		rock=r;
		
	}
	
	void update() {
		rock.update();
		
		for(int i=project.size()-1;i>0;i--) {
			project.get(i).update();
		}
	}
	
	void draw(Graphics g) {
		rock.draw(g);
		for(int i=project.size()-1;i>0;i--) {
			project.get(i).draw(g);
		}
	}
	
	void addProjectile(Projectile p){
		project.add(p);
	}
	
}

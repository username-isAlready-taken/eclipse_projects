package entities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class EntityManager {
	
	private ArrayList<Entity> entities;
	private Player player;
	private static Comparator<Entity> entityComparator = new Comparator<Entity>(){
		@Override
		public int compare(Entity e1, Entity e2) {
			if(e1.getY()+e1.getHeight() < e2.getY()+e2.getHeight())
				return -1;
			return 1;
		}
	};

	public EntityManager() {
		entities = new ArrayList<Entity>();
	}
	
	public void addEntity(Entity e) {
		entities.add(e);
		
		if(e.getClass().getName().equals("entities.Player"))
			player = (Player) e;
	}
	
	public void removeEntity(Entity e) {
		entities.remove(e);
	}

	public void update() {
		Iterator<Entity> iter = entities.iterator();
		while(iter.hasNext()) {
			Entity e = iter.next();
			if(e.remove) {
				iter.remove();
				continue;
			}
			e.update();
		}
		entities.sort(entityComparator);
	}
	
	public void render() {
		Iterator<Entity> i = entities.iterator();
		while(i.hasNext()) {
			Entity e = i.next();
			e.render();
		}
	}
	
	
	//getters
	
	public Player getPlayer() {
		return player;
	}
	
}

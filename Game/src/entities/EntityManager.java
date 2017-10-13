package entities;

import java.util.ArrayList;
import java.util.Iterator;

public class EntityManager {
	
	private ArrayList<Entity> entities;
	private Player player;

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

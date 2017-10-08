package gamestates;

import entities.EntityManager;
import entities.Player;

public class PlayState extends State {
	
	private EntityManager entityManager;
	
	public PlayState() {
		entityManager = new EntityManager();
		
		
		entityManager.addEntity(new Player(100, 100, 100));
	}

	@Override
	public void update() {
		entityManager.update();
		
	}

	@Override
	public void render() {
		entityManager.render();
		
	}
	

	//getters and setters
	public EntityManager getEntityManager() {
		return entityManager;
	}

}

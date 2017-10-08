package gamestates;

import entities.EntityManager;
import entities.Player;

public class GameState extends State {
	
	private EntityManager entityManager;
	
	public GameState() {
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

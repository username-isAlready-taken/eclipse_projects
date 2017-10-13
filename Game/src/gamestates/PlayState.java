package gamestates;

import assets.AssetManager;
import entities.EntityManager;
import main.Game;
import world.WorldManager;

public class PlayState extends State {
	
	
	public PlayState() {
		Game.getHandler().setAssetManager(new AssetManager());
		Game.getHandler().setEntityManager(new EntityManager());
		Game.getHandler().setWorldManager(new WorldManager());
	}

	@Override
	public void update() {
		Game.getHandler().getEntityManager().update();
		Game.getHandler().getWorldManager().update();
		
	}

	@Override
	public void render() {
		
		Game.getHandler().getWorldManager().render();
		Game.getHandler().getEntityManager().render();
		
	}
	
	
	
}

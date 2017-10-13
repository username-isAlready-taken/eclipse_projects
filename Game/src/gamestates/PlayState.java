package gamestates;

import java.awt.event.KeyEvent;

import assets.AssetManager;
import entities.CollisionManager;
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

		if(Game.getHandler().getKeyManager().getKeyPressed(KeyEvent.VK_ESCAPE))
			Game.getHandler().getGameStateManager().switchState(GameStates.MENUSTATE);

		if(Game.getHandler().getKeyManager().getKeyPressedOnce(KeyEvent.VK_F1))
			Game.getHandler().toggleShowFPS();

		if(Game.getHandler().getKeyManager().getKeyPressedOnce(KeyEvent.VK_F2))
			CollisionManager.toggleShowBounds();
		
	}

	@Override
	public void render() {
		
		Game.getHandler().getWorldManager().render();
		Game.getHandler().getEntityManager().render();
		
	}
	
	
	
}

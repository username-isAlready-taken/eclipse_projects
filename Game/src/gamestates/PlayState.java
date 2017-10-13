package gamestates;

import Tiles.Tile;
import Tiles.TileType;
import assets.AssetManager;
import entities.EntityManager;
import entities.Player;
import main.Game;
import world.WorldManager;

public class PlayState extends State {
	
	
	public PlayState() {
		Game.getHandler().setAssetManager(new AssetManager());
		Game.getHandler().setEntityManager(new EntityManager());
		Game.getHandler().setWorldManager(new WorldManager());
		
		
		Game.getHandler().getEntityManager().addEntity(new Player(100, 100, 100, 80, 100));
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

package world;

import Tiles.Tile;
import Tiles.TileType;
import entities.Player;
import entities.Tree;
import main.Game;

public class World {
	
	private int width; //width in tiles
	private int height; //height in tiles
	
	public World(int width, int height) {
		this.width = width;
		this.height = height;
		
		Game.getHandler().getEntityManager().addEntity(new Player(100, 100, 100, 40, 50));
		
		Game.getHandler().getEntityManager().addEntity(new Tree(200, 200, 64, 64));
		Game.getHandler().getEntityManager().addEntity(new Tree(220, 250, 64, 64));
		Game.getHandler().getEntityManager().addEntity(new Tree(190, 175, 64, 64));
		
	}

	public void update() {
		
	}

	public void render() {
		for(int x = 0; x<width; x++) {
			for(int y=0; y<height; y++) {
				if(x>5 && y>5 && x<width-1 && y<height-1)
					Tile.render(TileType.DIRT, x, y);
				else
					Tile.render(TileType.GRASS, x, y);				
			}
		}
		
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public int getPixelWidth() {
		return width * Tile.getWidth();
	}

	public int getPixelHeight() {
		return height * Tile.getHeight();
	}
}

package world;

import Tiles.Tile;
import Tiles.TileType;
import entities.Player;
import entities.Tree;
import main.Game;

public class World {
	
	private int width; //width in tiles
	private int height; //height in tiles
	
	private int spawnX = 800;
	private int spawnY = 600;
	
	public World(int width, int height) {
		this.width = width;
		this.height = height;
		

		Game.getHandler().getEntityManager().addEntity(new Player(100, spawnX, spawnY));
		
		for(int x = 0; x<width; x++) {
			for(int y=0; y<height; y++) {
				if(Math.random()>0.5)
					Game.getHandler().getEntityManager().addEntity(new Tree(x*64, y*64, 64, 64));
			}
		}
		
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
//				if(x%5 == 0 && y%5==0)
//					Game.getHandler().getEntityManager().addEntity(new Tree(x*64, y*64, 64, 64));
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

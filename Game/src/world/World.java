package world;

import Tiles.Tile;
import Tiles.TileType;

public class World {
	
	private int width; //width in tiles
	private int height; //height in tiles
	
	public World(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public void update() {
		// TODO Auto-generated method stub
		
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

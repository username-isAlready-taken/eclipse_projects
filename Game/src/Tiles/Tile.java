package Tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import assets.AssetManager;
import gamestates.PlayState;
import main.Game;

public class Tile {
	private BufferedImage texture;
	private TileType type;
	private static final int WIDTH = 64, HEIGHT = 64;
	
	private static Map<TileType, Tile> tiles = new HashMap<TileType, Tile>();
	
	
	public Tile(BufferedImage texture, TileType type) {
		this.texture = texture;
		this.type = type;
		tiles.put(type, this);
	}

	public static void render(TileType type, int x, int y) {
		int xPixels = x * WIDTH;
		xPixels -= Game.getHandler().getWorldManager().getCamera().getxOffset();
		
		int yPixels = y * HEIGHT;
		yPixels -= Game.getHandler().getWorldManager().getCamera().getyOffset();
		Graphics g = Game.getHandler().getGraphics();
		g.drawImage(tiles.get(type).texture, xPixels, yPixels, null);
	}
	
	//getters
	
	public static int getWidth() {
		return WIDTH;
	}
	
	public static int getHeight() {
		return HEIGHT;
	}

}

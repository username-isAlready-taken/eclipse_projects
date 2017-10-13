package assets;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Tiles.Tile;
import Tiles.TileType;

public class AssetManager {
	public static BufferedImage grass, dirt;
	
	public AssetManager() {
		grass = LoadImage("/grass1.png");
		dirt = LoadImage("/dirt2.png");
		new Tile(grass, TileType.GRASS);
		new Tile(dirt, TileType.DIRT);
		
	}
	
	public static BufferedImage LoadImage(String path) {
		try {
			return ImageIO.read(AssetManager.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}

}

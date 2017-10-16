package assets;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;
import java.io.IOException;

import javax.imageio.ImageIO;

import Tiles.Tile;
import Tiles.TileType;

public class AssetManager {
	public static BufferedImage grassTile, dirtTile, player;
	public static Animation tree;
	public static Animation playerDown;
	
	public AssetManager() {
		grassTile = LoadImage("/grass1.png");
		dirtTile = LoadImage("/dirt2.png");
		new Tile(grassTile, TileType.GRASS);
		new Tile(dirtTile, TileType.DIRT);
		
		
		player = makeTransparent(
					Animation.Crop(LoadImage("/playerIdle.png"), 128, 128).get(1),
					new Color(255, 255, 255)
				);
		
		playerDown = new Animation(
					makeTransparent(
							LoadImage("/playerDown.png"),
							new Color(255, 255, 255)
					),
					0.2, 128, 128
				);
				
		
		tree = new Animation(
					makeTransparent(
							LoadImage("/treesprite.png"),
							new Color(255, 255, 255)
							),
					0.4, 64, 64
				);
		
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
	
	public static BufferedImage makeTransparent(BufferedImage image, final Color color) {
        ImageFilter filter = new RGBImageFilter() {

            // the color we are looking for... Alpha bits are set to opaque
            public int markerRGB = color.getRGB() | 0xFF000000;

            public final int filterRGB(int x, int y, int rgb) {
                if ((rgb | 0xFF000000) == markerRGB) {
                    // Mark the alpha bits as zero - transparent
                    return 0x00FFFFFF & rgb;
                } else {
                    // nothing to do
                    return rgb;
                }
            }
        };

        ImageProducer ip = new FilteredImageSource(image.getSource(), filter);
        Image transparentImage = Toolkit.getDefaultToolkit().createImage(ip);
        
        BufferedImage bufferedImage = new BufferedImage(transparentImage.getWidth(null), transparentImage.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = bufferedImage.createGraphics();
        g2.drawImage(transparentImage, 0, 0, null);
        g2.dispose();
        
        return bufferedImage;
    }

}

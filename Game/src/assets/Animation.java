package assets;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Animation {
	
	private ArrayList<BufferedImage> textures;
	private double speed;
	private int currentIndex;
	private long lastTime, currentTime;
	
	public Animation(BufferedImage spriteSheet, double speed, int width, int height) {
		this.speed = speed;
		this.currentIndex = 0;
		textures = Crop(spriteSheet, width, height);
		lastTime = System.nanoTime();
		currentTime = lastTime;
	}	
	
	public ArrayList<BufferedImage> Crop(BufferedImage spriteSheet, int width, int height) {
		ArrayList<BufferedImage> textures = new ArrayList<BufferedImage>();
		
		for(int x=0; x<spriteSheet.getWidth(); x+=width ) {
			for(int y=0; y<spriteSheet.getHeight(); y+=height ) {
				BufferedImage frame = spriteSheet.getSubimage(x, y, width, height);
				textures.add(frame);
			}
		}
		
		return textures;
	}
	
	public void update() {
		currentTime = System.nanoTime();
		if( (double)( (currentTime-lastTime)/1e9 ) >= speed ) {
			currentIndex++;
			currentIndex%=textures.size();
			lastTime = currentTime;
		}
		
	}
	
	public BufferedImage getCurrentFrame() {
		return textures.get(currentIndex);
	}

}

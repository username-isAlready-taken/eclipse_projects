package entities;

import java.awt.image.BufferedImage;

import assets.Animation;

public abstract class StaticEntity extends Entity {

	
	protected Animation animation;
	protected BufferedImage texture;
	
	public StaticEntity(double x, double y, int width, int height, Animation animation) {
		super(x, y, width, height);
		this.animation = animation;
	}	
	
	public StaticEntity(double x, double y, int width, int height, BufferedImage texture) {
		super(x, y, width, height);
		this.texture = texture;
	}

}

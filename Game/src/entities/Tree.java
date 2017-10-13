package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Iterator;

import assets.AssetManager;
import main.Game;

public class Tree extends StaticEntity {


	public Tree(double x, double y, int width, int height) {
		super(x, y, width, height, AssetManager.tree);
		this.collisions.addHitbox(23, 39, 13, 19);
	}


	@Override
	protected void update() {
		if(animation != null) {
			animation.update();

		}
	}

	@Override
	protected void render() {
		Graphics g = Game.getHandler().getGraphics();
//		BufferedImage frame = texture;
		if(animation != null) {
			BufferedImage frame = animation.getCurrentFrame();
			g.drawImage(frame, 	this.getDrawX(), this.getDrawY(), null);
			
			Collisions.showBounds(this);
		}
	}

}

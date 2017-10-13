package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import assets.AssetManager;
import main.Game;

public class Tree extends StaticEntity {


	public Tree(double x, double y, int width, int height) {
		super(x, y, width, height, AssetManager.tree);
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
			g.drawImage(frame, 	(int) getX() - Game.getHandler().getWorldManager().getCamera().getxOffset(),
								(int) getY() - Game.getHandler().getWorldManager().getCamera().getyOffset(),
						null);
		}
	}

}

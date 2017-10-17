package world;

import main.Game;

public class Camera {
	
	private int xOffset = 0, yOffset = 0;
	
	public Camera() {
		
	}

	public void update() {
		xOffset = (int) Game.getHandler().getEntityManager().getPlayer().getX();
		xOffset -= Game.getHandler().getDisplay().getWidth() /2 ;
		xOffset += Game.getHandler().getEntityManager().getPlayer().getWidth() / 2;
		xOffset = (xOffset<0) ? 0 : xOffset;
		xOffset = (xOffset>Game.getHandler().getWorldManager().getCurrentWorld().getPixelWidth() - Game.getHandler().getDisplay().getWidth()) ?
				Game.getHandler().getWorldManager().getCurrentWorld().getPixelWidth() - Game.getHandler().getDisplay().getWidth() : xOffset;
		
		yOffset = (int) Game.getHandler().getEntityManager().getPlayer().getY();
		yOffset -= Game.getHandler().getDisplay().getHeight() /2 ;
		yOffset += Game.getHandler().getEntityManager().getPlayer().getHeight() / 2;
		yOffset = (yOffset<0) ? 0 : yOffset;
		yOffset = (yOffset>Game.getHandler().getWorldManager().getCurrentWorld().getPixelHeight() - Game.getHandler().getDisplay().getHeight()) ?
				Game.getHandler().getWorldManager().getCurrentWorld().getPixelHeight() - Game.getHandler().getDisplay().getHeight() : yOffset;
		
	}
	
	public int getxOffset() {
		return xOffset;
	}
	
	public int getyOffset() {
		return yOffset;
	}

}

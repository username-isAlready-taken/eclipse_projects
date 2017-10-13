package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import main.Game;
import gamestates.GameStateManager;
import gamestates.GameStates;
import gamestates.PlayState;

enum Direction {
	LEFT, RIGHT, UP, DOWN;
}

public class Player extends Creature {
	
	protected double speed = 4.5;
	
	public Player(int health, double x, double y, int width, int height) {
		super(health, x, y, width, height);
		
	}

	@Override
	protected void update() {
		if(Game.getHandler().getKeyManager().getKeyPressed(KeyEvent.VK_DOWN))
			movePlayer(Direction.DOWN);
		if(Game.getHandler().getKeyManager().getKeyPressed(KeyEvent.VK_UP))
			movePlayer(Direction.UP);
		if(Game.getHandler().getKeyManager().getKeyPressed(KeyEvent.VK_RIGHT))
			movePlayer(Direction.RIGHT);
		if(Game.getHandler().getKeyManager().getKeyPressed(KeyEvent.VK_LEFT))
			movePlayer(Direction.LEFT);
		if(Game.getHandler().getKeyManager().getKeyPressed(KeyEvent.VK_ESCAPE))
			Game.getHandler().getGameStateManager().switchState(GameStates.MENUSTATE);
		
	}
	
	private void movePlayer(Direction d) {
		if(d == Direction.UP) {
			this.y = Math.max(0,this.y-speed);	
		}
		if(d == Direction.DOWN) {
			this.y = Math.min(
						Game.getHandler().getWorldManager().getWorld().getPixelHeight() - height,
						this.y+speed);		
		}
		if(d == Direction.LEFT) {
			this.x = Math.max(0,this.x-speed);		
		}
		if(d == Direction.RIGHT) {
			this.x = Math.min(
						Game.getHandler().getWorldManager().getWorld().getPixelWidth() - width,
						this.x+speed);			
		}
	}

	@Override
	protected void render() {
		Graphics g = Game.getHandler().getGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(
				(int)getX() - Game.getHandler().getWorldManager().getCamera().getxOffset(),
				(int)getY() - Game.getHandler().getWorldManager().getCamera().getyOffset(),
				this.getWidth(), this.getHeight());
	}

}

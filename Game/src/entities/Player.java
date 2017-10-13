package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import main.Game;
import gamestates.GameStates;

enum Direction {
	LEFT, RIGHT, UP, DOWN;
}

public class Player extends Creature {
	
	protected double speed = 4.5;
	
	public Player(int health, double x, double y, int width, int height) {
		super(health, x, y, width, height);
//		this.collisions.addHitbox(0, 0, width, height/2);
		this.collisions.addHitbox(0, height/2, width, height/2);
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
	}
	
	private void movePlayer(Direction d) {
		if(d == Direction.UP && !Collisions.intersects(this, Direction.UP, speed)) {
			this.y = Math.max(0,this.y-speed);	
		}
		if(d == Direction.DOWN && !Collisions.intersects(this, Direction.DOWN, speed)) {
			this.y = Math.min(
						Game.getHandler().getWorldManager().getCurrentWorld().getPixelHeight() - height,
						this.y+speed);		
		}
		if(d == Direction.LEFT && !Collisions.intersects(this, Direction.LEFT, speed)) {
			this.x = Math.max(0,this.x-speed);		
		}
		if(d == Direction.RIGHT && !Collisions.intersects(this, Direction.RIGHT, speed)) {
			this.x = Math.min(
						Game.getHandler().getWorldManager().getCurrentWorld().getPixelWidth() - width,
						this.x+speed);			
		}
	}

	@Override
	protected void render() {
		Graphics g = Game.getHandler().getGraphics();
		g.setColor(Color.YELLOW);
		g.fillRect(this.getDrawX(),	this.getDrawY(), this.getWidth(), this.getHeight());
		Collisions.showBounds(this);
	}

}

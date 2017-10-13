package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import assets.AssetManager;
import main.Game;

enum Direction {
	LEFT, RIGHT, UP, DOWN;
}

public class Player extends Creature {
	
	protected double speed = 4.5;
	protected static int width = 64;
	protected static int height = 64;
	
	public Player(int health, double x, double y) {
		super(health, x, y, width, height);
		this.collisionManager.addHitbox(width/3, height/5*3, width/3, height/5*2);
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
		if(d == Direction.UP && !CollisionManager.intersects(this, Direction.UP, speed)) {
			this.y = Math.max(0,this.y-speed);	
		}
		if(d == Direction.DOWN && !CollisionManager.intersects(this, Direction.DOWN, speed)) {
			this.y = Math.min(
						Game.getHandler().getWorldManager().getCurrentWorld().getPixelHeight() - height,
						this.y+speed);		
		}
		if(d == Direction.LEFT && !CollisionManager.intersects(this, Direction.LEFT, speed)) {
			this.x = Math.max(0,this.x-speed);		
		}
		if(d == Direction.RIGHT && !CollisionManager.intersects(this, Direction.RIGHT, speed)) {
			this.x = Math.min(
						Game.getHandler().getWorldManager().getCurrentWorld().getPixelWidth() - width,
						this.x+speed);			
		}
	}

	@Override
	protected void render() {
		Graphics g = Game.getHandler().getGraphics();
		g.drawImage(AssetManager.player, this.getDrawX(), this.getDrawY(), null);
//		g.setColor(Color.YELLOW);
//		g.fillRect(this.getDrawX(),	this.getDrawY(), this.getWidth(), this.getHeight());
	}

}

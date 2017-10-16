package entities;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import assets.AssetManager;
import main.Game;


public class Player extends Creature {
	
	protected double speed = 4.5;
	protected static int width = 128;
	protected static int height = 128;
	
	public Player(int health, double x, double y) {
		super(health, x, y, width, height);
		this.collisionManager.addHitbox(53, 63, 19, 50);
		this.animation = AssetManager.playerDown;
		this.facing = Direction.DOWN;
	}

	@Override
	protected void update() {
		Direction correctDirection = null;
		walking = false;

		if(Game.getHandler().getKeyManager().getKeyPressed(KeyEvent.VK_DOWN)) {
			walking = true;
			if(facing == Direction.LEFT || facing == Direction.RIGHT)
				correctDirection = Direction.DOWN;
			facing = Direction.DOWN;
			movePlayer(Direction.DOWN);
		}
		if(Game.getHandler().getKeyManager().getKeyPressed(KeyEvent.VK_UP)) {	
			walking = true;
			if(facing == Direction.LEFT || facing == Direction.RIGHT)
				correctDirection = Direction.UP;
			facing = Direction.UP;
			movePlayer(Direction.UP);
		}
		if(Game.getHandler().getKeyManager().getKeyPressed(KeyEvent.VK_RIGHT)) {
			walking = true;	
			facing = Direction.RIGHT;
			movePlayer(Direction.RIGHT);
		}
		if(Game.getHandler().getKeyManager().getKeyPressed(KeyEvent.VK_LEFT)) {	
			walking = true;	
			facing = Direction.LEFT;
			movePlayer(Direction.LEFT);	
		}

		correctFacing(correctDirection);
		animation.update();
	}
	
	private void correctFacing(Direction d) {
		if(d != null)
			facing = d;

	}
	
	private void movePlayer(Direction d) {
		if(d == Direction.UP && !CollisionManager.collides(this, Direction.UP, speed)) {
			this.y = Math.max(0,this.y-speed);
			this.animation = AssetManager.playerUp;
		}
		if(d == Direction.DOWN && !CollisionManager.collides(this, Direction.DOWN, speed)) {
			this.y = Math.min(
						Game.getHandler().getWorldManager().getCurrentWorld().getPixelHeight() - height,
						this.y+speed);	
			this.animation = AssetManager.playerDown;	
		}
		if(d == Direction.LEFT && !CollisionManager.collides(this, Direction.LEFT, speed)) {
			this.x = Math.max(0,this.x-speed);	
//			this.animation = AssetManager.playerDown;	
		}
		if(d == Direction.RIGHT && !CollisionManager.collides(this, Direction.RIGHT, speed)) {
			this.x = Math.min(
						Game.getHandler().getWorldManager().getCurrentWorld().getPixelWidth() - width,
						this.x+speed);	
//			this.animation = AssetManager.playerDown;		
		}
	}

	@Override
	protected void render() {
		Graphics g = Game.getHandler().getGraphics();
		g.drawString("Facing: "+facing, 100, 100);
		BufferedImage renderPlayer = null;
		if(walking == false || facing == Direction.LEFT || facing == Direction.RIGHT) {
			if(facing == Direction.DOWN)
				renderPlayer = AssetManager.playerIdleDown;
			if(facing == Direction.UP)
				renderPlayer = AssetManager.playerIdleUp;
			if(facing == Direction.LEFT)
				renderPlayer = AssetManager.playerIdleLeft;
			if(facing == Direction.RIGHT)
				renderPlayer = AssetManager.playerIdleRight;
		} else {
			renderPlayer = animation.getCurrentFrame();
		}
		g.drawImage(renderPlayer, this.getDrawX(), this.getDrawY(), null);
	}

}

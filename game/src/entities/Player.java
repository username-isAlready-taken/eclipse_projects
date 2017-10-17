package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import assets.AssetManager;
import main.Game;


public class Player extends Creature {
	
	protected double speed = 4.5;
	protected static int width = 128;
	protected static int height = 128;
	
	protected double lastVerticalMovement=0, lastHorizontalmovement=0;
	
	public Player(int health, double x, double y) {
		super(health, x, y, width, height);
		this.collisionManager.addHitbox(53, 63, 19, 50);
		this.animation = AssetManager.playerDown;
		this.facing = Direction.DOWN;
	}

	@Override
	protected void update() {
		double currentTime = System.nanoTime();
		boolean resetLastH = true;
		boolean resetLastV = true;
		walking = false;

		if(Game.getHandler().getKeyManager().getKeyPressed(KeyEvent.VK_DOWN)) {
			walking = true;
			this.lastVerticalMovement = (this.lastVerticalMovement==0) ? currentTime : this.lastVerticalMovement;
			resetLastV = false;
			if(this.lastVerticalMovement > this.lastHorizontalmovement) {
				facing = Direction.DOWN;
				this.animation = AssetManager.playerDown;
			}
			movePlayer(Direction.DOWN);
		}
		if(Game.getHandler().getKeyManager().getKeyPressed(KeyEvent.VK_UP)) {	
			walking = true;
			this.lastVerticalMovement = (this.lastVerticalMovement==0) ? currentTime : this.lastVerticalMovement;
			resetLastV = false;
			if(this.lastVerticalMovement > this.lastHorizontalmovement) {
				facing = Direction.UP;
				this.animation = AssetManager.playerUp;				
			}
			movePlayer(Direction.UP);
		}
		if(Game.getHandler().getKeyManager().getKeyPressed(KeyEvent.VK_RIGHT)) {
			walking = true;	
			this.lastHorizontalmovement = (this.lastHorizontalmovement==0) ? currentTime : this.lastHorizontalmovement;
			resetLastH = false;
			if(this.lastVerticalMovement < this.lastHorizontalmovement) {
				facing = Direction.RIGHT;
				this.animation = AssetManager.playerRight;	
			}
			movePlayer(Direction.RIGHT);
		}
		if(Game.getHandler().getKeyManager().getKeyPressed(KeyEvent.VK_LEFT)) {	
			walking = true;	
			this.lastHorizontalmovement = (this.lastHorizontalmovement==0) ? currentTime : this.lastHorizontalmovement;
			resetLastH = false;
			if(this.lastVerticalMovement < this.lastHorizontalmovement) {
				facing = Direction.LEFT;
				this.animation = AssetManager.playerLeft;
			}
			movePlayer(Direction.LEFT);	
		}
		if(resetLastH)
			this.lastHorizontalmovement = 0;
		if(resetLastV)
			this.lastVerticalMovement = 0;

		animation.update();
	}
	
	private void movePlayer(Direction d) {
		
		if(d == Direction.UP && !CollisionManager.collides(this, Direction.UP, speed)) {
			this.y = Math.max(0,this.y-speed);
		}
		if(d == Direction.DOWN && !CollisionManager.collides(this, Direction.DOWN, speed)) {
			this.y = Math.min(
						Game.getHandler().getWorldManager().getCurrentWorld().getPixelHeight() - height,
						this.y+speed);		
		}
		if(d == Direction.LEFT && !CollisionManager.collides(this, Direction.LEFT, speed)) {
			this.x = Math.max(0,this.x-speed);		
		}
		if(d == Direction.RIGHT && !CollisionManager.collides(this, Direction.RIGHT, speed)) {
			this.x = Math.min(
						Game.getHandler().getWorldManager().getCurrentWorld().getPixelWidth() - width,
						this.x+speed);		
		}
	}

	@Override
	protected void render() {
		Graphics g = Game.getHandler().getGraphics();
		g.setColor(Color.cyan);
		g.drawString("facing: "+facing, 100, 100);
		BufferedImage renderPlayer = null;
		if(walking == false) {
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

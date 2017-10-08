package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import main.Game;

public class Player extends Creature {
	
	protected double speed = 4.5;
	
	public Player(int health, double x, double y) {
		super(health, x, y);
		
	}

	@Override
	protected void update() {
//		this.y+=speed;
		if(Game.getHandler().getKeyManager().getKeyPressed(KeyEvent.VK_DOWN))
			this.y+=speed;
		else if(Game.getHandler().getKeyManager().getKeyPressed(KeyEvent.VK_UP))
			this.y-=speed;
		if(Game.getHandler().getKeyManager().getKeyPressed(KeyEvent.VK_RIGHT))
			this.x+=speed;
		else if(Game.getHandler().getKeyManager().getKeyPressed(KeyEvent.VK_LEFT))
			this.x-=speed;
		
	}

	@Override
	protected void render() {
		Graphics g = Game.getHandler().getGraphics();
		g.setColor(Color.BLACK);
		g.fillRect((int)getX(), (int)getY(), 110, 150);
	}

}

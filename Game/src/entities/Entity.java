package entities;

import main.Game;

public abstract class Entity {
	
	protected double x, y;
	protected int width, height;
	protected Collisions collisions = new Collisions();
	protected boolean remove = false;
	
	public Entity(double x, double y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	
	protected abstract void update();
	
	protected abstract void render();

	
	//getters and setters

	public int getDrawX() {
		return (int)getX() - Game.getHandler().getWorldManager().getCamera().getxOffset();
	}
	
	public int getDrawY() {
		return (int)getY() - Game.getHandler().getWorldManager().getCamera().getyOffset();
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}

}

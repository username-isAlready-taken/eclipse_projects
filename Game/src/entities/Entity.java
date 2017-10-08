package entities;

public abstract class Entity {
	
	protected double x, y;
	protected boolean remove = false;
	
	public Entity(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	
	protected abstract void update();
	
	protected abstract void render();

	
	//getters and setters
	
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

}

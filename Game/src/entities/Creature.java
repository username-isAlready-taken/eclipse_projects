package entities;

public abstract class Creature extends Entity {

	protected int health;
	protected int maxHealth;
	
	public Creature(int health, double x, double y) {
		super(x, y);
		this.health = health;
		this.maxHealth = health;
	}
	
	//getters and setters
	
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getMaxHealth() {
		return maxHealth;
	}
	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}
	


}

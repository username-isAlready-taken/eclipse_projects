package world;

import entities.Player;
import main.Game;

public class WorldManager {
	
	private Camera camera;
	private World currentWorld;
	
	public WorldManager() {
		this.currentWorld = new World(75, 100);
		this.camera = new Camera();
		
	}

	public void update() {
		camera.update();
		currentWorld.update();
		
	}

	public void render() {
		currentWorld.render();
		
	}
	
	
	//getters
	
	public Camera getCamera() {
		return camera;
	}
	
	public World getCurrentWorld() {
		return currentWorld;
	}

}

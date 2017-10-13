package world;

public class WorldManager {
	
	private Camera camera = new Camera();
	private World currentWorld = new World(25, 25);
	
	public WorldManager() {
		
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
	
	public World getWorld() {
		return currentWorld;
	}

}

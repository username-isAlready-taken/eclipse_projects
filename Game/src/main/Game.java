package main;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import assets.AssetManager;
import entities.EntityManager;
import gamestates.GameStateManager;
import keyManager.KeyManager;
import world.WorldManager;

public class Game implements Runnable {
	
	private final String title = "Generic RPG Game";

	private static Game game;
	private Display display;
	private Graphics g;
	private BufferStrategy bs;
	private Boolean running = false;
	private static long lastTime;
	private static long currentTime;
	private static int FPS = 60;
	private static int currentFPS;
	
//	private int blockX = 0;
//	private int blockY = 100;
//	private Color blockColor = Color.BLACK;
	
	private GameStateManager gameStateManager;
	private KeyManager keyManager;
	private EntityManager entityManager;
	private AssetManager assetManager;
	private WorldManager worldManager;
	
	public Game() {
		display = new Display(title, 960, 720);
		run();
	}

	@Override
	public void run() {
		init();

		lastTime = System.nanoTime();
		currentFPS = 0;
		
		while(running) {
			currentTime = System.nanoTime();
			if(currentTime - lastTime >= 1e9/FPS) {
				currentFPS = (int) Math.round((1e9 / (currentTime - lastTime)));
				update();
				render();
				lastTime = currentTime;
			}
		}
		System.exit(0);
	}
	
	
	private void init() {
		running = true;
		game = this;
		gameStateManager = new GameStateManager();
		keyManager = new KeyManager();

	}
	
	
	private void update() {
//		blockX+=3;
//		blockX%=display.getWidth();
//		blockY = 100 + (int) (30*Math.sin(2*blockX));
//		blockColor = new Color( (blockColor.getRGB()-500)%-(256*256*256) );
		
		gameStateManager.update();
		
	}

	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, display.getWidth(), display.getHeight()); //clear screen
		       
//		g.setColor(Color.GREEN);
//		g.fillRect(0, 0, display.getWidth(), display.getHeight());
//		g.setColor(blockColor);
//		g.fillRect(blockX, blockY, 150, 150);
//		
//		g.setColor(Color.black);
//		g.setFont(new Font(g.getFont().getFontName(), Font.BOLD, 20));
//		g.drawString("FPS: "+currentFPS, 10, 50);
		
		
		gameStateManager.render();
		
		
		bs.show();	//draw on the screen
		g.dispose(); //dispose graphics object
	}
	
	public void exit() {
		running = false;
	}
	
	
	//getters and setters
	
	public static Game getHandler() {
		return game;
	}
	
	public GameStateManager getGameStateManager() {
		return gameStateManager;
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public AssetManager getAssetManager() {
		return assetManager;
	}
	
	public WorldManager getWorldManager() {
		return worldManager;
	}

	public Display getDisplay() {
		return display;
	}
	
	public Graphics getGraphics() {
		return g;
	}
	
	public int getFPS() {
		return currentFPS;
	}
	
	public String getTitle() {
		return title;
	}

	public void setAssetManager(AssetManager assetManager) {
		this.assetManager = assetManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void setWorldManager(WorldManager worldManager) {
		this.worldManager = worldManager;
	}

}

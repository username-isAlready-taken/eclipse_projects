package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {


	private Display display;
	private Graphics g;
	private BufferStrategy bs;
	private Boolean running = false;
	private long lastTime;
	private long currentTime;
	private int FPS = 60;
	private int currentFPS = 0;
	
	private int blockX = 0;
	private int blockY = 100;
	private Color blockColor = Color.BLACK;
	
	
	public Game() {
		display = new Display("Test game", 960, 720);
		run();
	}

	@Override
	public void run() {
		init();

		lastTime = System.nanoTime();
		
		while(running) {
			currentTime = System.nanoTime();
			if(currentTime - lastTime >= 1e9/FPS) {
				currentFPS = (int) Math.round((1e9 / (currentTime - lastTime)));
				update();
				render();
				lastTime = currentTime;
			}
		}	
	}
	
	
	private void init() {
		display.getCanvas().createBufferStrategy(3);
		running = true;
	}
	
	
	private void update() {
		blockX+=3;
		blockX%=display.getWidth();
		
		blockY = 100 + (int) (30*Math.sin(2*blockX));
		
		blockColor = new Color( (blockColor.getRGB()-500)%-(256*256*256) );
		
	}

	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, display.getWidth(), display.getHeight()); //clear screen
		       
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, display.getWidth(), display.getHeight());
		g.setColor(blockColor);
		g.fillRect(blockX, blockY, 150, 150);
		
		g.setColor(Color.black);
		g.setFont(new Font(g.getFont().getFontName(), Font.BOLD, 20));
		g.drawString("FPS: "+currentFPS, 10, 50);
		
		bs.show();	//draw on the screen
		g.dispose(); //dispose graphics object
		
	}

	public Display getDisplay() {
		return display;
	}


}

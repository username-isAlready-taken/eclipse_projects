package main;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {
	
	private int width, height;
	private String title;
	private Canvas canvas;
	
	public Display(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		init();
	}

	private void init() {
		JFrame display = new JFrame(title);
		display.setSize(width, height);
		display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		display.setResizable(false);
		display.setLocationRelativeTo(null);
		display.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		display.add(canvas);

		display.pack();
		
	}

	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
	
}

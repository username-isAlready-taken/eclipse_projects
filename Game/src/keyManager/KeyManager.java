package keyManager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.Game;

public class KeyManager implements KeyListener {
	
	private boolean[] keys, pressedOnce;
	
	public KeyManager() {
		keys = new boolean[256];
		pressedOnce = new boolean[256];
		Game.getHandler().getDisplay().getCanvas().addKeyListener(this);
	}
	
	private boolean validKey(int keyCode) {
		if(keyCode<0 || keyCode>keys.length) 
			return false;
		if(		keyCode == KeyEvent.VK_DOWN ||
				keyCode == KeyEvent.VK_UP ||
				keyCode == KeyEvent.VK_LEFT ||
				keyCode == KeyEvent.VK_RIGHT ||
				keyCode == KeyEvent.VK_ENTER ||
				keyCode == KeyEvent.VK_ESCAPE)
			return true;
		return false;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(validKey(keyCode)) {
			keys[keyCode] = true;
			pressedOnce[keyCode] = true;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(validKey(keyCode))
			keys[keyCode] = false;
			pressedOnce[keyCode] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {}
	
	
	//getters and setters
	
	public boolean getKeyPressed(int keyCode) {
		if(validKey(keyCode) == false)
			return false;
		if(keys[keyCode])
			return true;
		return false;
	}

	public boolean getKeyPressedOnce(int keyCode) {
		if(validKey(keyCode) == false)
			return false;
		if(pressedOnce[keyCode]) {
			pressedOnce[keyCode] = false;
			return true;
		}
		return false;
	}

}

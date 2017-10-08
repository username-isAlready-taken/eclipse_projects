package gamestates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import main.Game;

public class ExitState extends State {

	private String title;
	private ArrayList<String> menuItems;
	private int selection;
	
	public ExitState() {
		title = "Do you really want to quit?";
		menuItems = new ArrayList<String>();
		menuItems.add("yes");
		menuItems.add("no");
		selection = 0;
	}

	@Override
	public void update() {

		if(Game.getHandler().getKeyManager().getKeyPressedOnce(KeyEvent.VK_UP)) {
			selection = (menuItems.size() + selection -1) % menuItems.size();
		}
		else if(Game.getHandler().getKeyManager().getKeyPressedOnce(KeyEvent.VK_DOWN)) {
			selection = (menuItems.size() + selection +1) % menuItems.size();
		}
		else if(Game.getHandler().getKeyManager().getKeyPressedOnce(KeyEvent.VK_ENTER)) {
			if(menuItems.get(selection).equals("yes"))
				Game.getHandler().exit();
			else
				Game.getHandler().getGameStateManager().switchState(GameStates.MENUSTATE);
		}

	}

	@Override
	public void render() {

		Graphics g = Game.getHandler().getGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Game.getHandler().getDisplay().getWidth(), Game.getHandler().getDisplay().getHeight());

		g.setFont(new Font(g.getFont().getFontName(), Font.BOLD, 30));
		g.setColor(Color.GREEN);
		int x = Game.getHandler().getDisplay().getWidth()/2 - g.getFontMetrics().stringWidth(title)/2;
		g.drawString(title, x, 150);
		
		g.setFont(new Font(g.getFont().getFontName(), Font.PLAIN, 20));
		x = Game.getHandler().getDisplay().getWidth()/2 - g.getFontMetrics().stringWidth(menuItems.get(0))/2;
		
		for(String s: menuItems) {
			if(menuItems.indexOf(s) == selection) {
				g.setColor(Color.WHITE);
			}
			g.drawString(s, x, 200 + 30*(menuItems.indexOf(s)+1));
			g.setColor(Color.GREEN);
		}
		

	}


}

package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

import main.Game;

public class Collisions {
	
	private ArrayList<Rectangle> collisionBounds;
	
	private static boolean showBounds = false;
	
	public Collisions() {
		collisionBounds = new ArrayList<Rectangle>();
	}
	
	public void addHitbox(int x, int y, int width, int height) {
		collisionBounds.add(new Rectangle(x, y, width, height));
	}

//	public ArrayList<Rectangle> getCollisionBounds() {
//		return collisionBounds;
//	}
	
	public static void showBounds(Entity e) {
		if(showBounds) {
			Graphics g = Game.getHandler().getGraphics();
			Iterator<Rectangle> iterator = e.collisions.collisionBounds.iterator();
			g.setColor(Color.cyan);
			while(iterator.hasNext()) {
				Rectangle r = iterator.next();
				g.drawRect((int)(r.getX() + e.getDrawX()), (int)(r.getY() + e.getDrawY()), (int)r.getWidth(), (int)r.getHeight());
			}
		}
	}
	
	public static boolean intersects(Entity e1, Direction d, double speed) {
		Iterator<Rectangle> iteratorBounds1 = e1.collisions.collisionBounds.iterator();
		while(iteratorBounds1.hasNext()) {
			Rectangle bounds1 = new Rectangle(iteratorBounds1.next());
			if(d == Direction.UP) {
				bounds1.setLocation( 	(int)(bounds1.getX()+e1.getX()),
										(int)(bounds1.getY()+e1.getY()-speed)
									);
			}
			else if(d == Direction.DOWN) {
				bounds1.setLocation( 	(int)(bounds1.getX()+e1.getX()),
										(int)(bounds1.getY()+e1.getY()+speed)
									);
			}
			else if(d == Direction.LEFT) {
				bounds1.setLocation( 	(int)(bounds1.getX()+e1.getX()-speed),
										(int)(bounds1.getY()+e1.getY())
									);
			}
			else if(d == Direction.RIGHT) {
				bounds1.setLocation( 	(int)(bounds1.getX()+e1.getX()+speed),
										(int)(bounds1.getY()+e1.getY())
									);
			}
			
			Iterator<Entity> iteratorEntity = Game.getHandler().getEntityManager().getEntities().iterator();
			while(iteratorEntity.hasNext()) {
				Entity e2 = iteratorEntity.next();
				if(e1.equals(e2) ||
						e2.getDrawX()<0 || e2.getDrawY()<0 ||
						e2.getDrawX()>Game.getHandler().getDisplay().getWidth() ||
						e2.getDrawY()>Game.getHandler().getDisplay().getHeight()
				) {
					continue;
				}
				Iterator<Rectangle> iteratorBounds2 = e2.collisions.collisionBounds.iterator();
				while(iteratorBounds2.hasNext()) {
					Rectangle bounds2 = new Rectangle(iteratorBounds2.next());
					bounds2.setLocation(	(int)(bounds2.getX()+e2.getX()),
											(int)(bounds2.getY()+e2.getY())
										);
					
					if(d == Direction.UP) {
						if( bounds1.getY()>bounds2.getY() && bounds1.intersects(bounds2)) {
							return true;
						}
					}
					else if(d == Direction.DOWN) {
						if( bounds1.getY()<bounds2.getY() && bounds1.intersects(bounds2)) {
							return true;
						}
					}
					else if(d == Direction.LEFT) {
						if( bounds1.getX()>bounds2.getX() && bounds1.intersects(bounds2)) {
							return true;
						}
					}
					else if(d == Direction.RIGHT) {
						if( bounds1.getX()<bounds2.getX() && bounds1.intersects(bounds2)) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	public static void toggleShowBounds() {
		showBounds = !showBounds;
	}

}

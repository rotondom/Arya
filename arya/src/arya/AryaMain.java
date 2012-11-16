package arya;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Animation;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Polygon;

/**
 * The main game program
 * 
 * @author Mike Kucharski
 * @version 0.01, 6 November 2012
 */
public class AryaMain extends BasicGame {
	private float playerX=320;
	private float playerY=240;
	private Animation player;
	private Polygon playerPoly;
	
	public AryaMain() {
		super("Arya");
	}
	
	public void init(GameContainer container) throws SlickException {
		container.setVSync(true);
		SpriteSheet sheet = new SpriteSheet("data/mapResources/enemySprite.png",32,32);
		new BlockMap("data/mapResources/mikesmap.tmx");		
		player = new Animation();
		player.setAutoUpdate(true);
		
		for (int frame=0;frame<3;frame++) {
			player.addFrame(sheet.getSprite(0,0), 150);
			
			playerPoly = new Polygon(new float[]{
					playerX,playerY,
					playerX+32,playerY,
					playerX+32,playerY+32,
					playerX,playerY+32
			});
		}		
	}
	public void update(GameContainer container, int delta) throws SlickException{ 
		if (container.getInput().isKeyDown(Input.KEY_LEFT) ) {
			playerX-=.1 * delta;
			playerPoly.setX(playerX);
			if (entityCollisionWith()){
				playerX++;
				playerPoly.setX(playerX);
			}
		}
		if (container.getInput().isKeyDown(Input.KEY_RIGHT) ) {
 
			playerX+= .1 * delta;
			playerPoly.setX(playerX);
			if (entityCollisionWith()){
				playerX--;
				playerPoly.setX(playerX);
			}
		}
		if (container.getInput().isKeyDown(Input.KEY_UP)) {
 
			playerY-= .1 * delta;
			playerPoly.setY(playerY);
			if (entityCollisionWith()){
				playerY++;
				playerPoly.setY(playerY);
			}
		}
		if (container.getInput().isKeyDown(Input.KEY_DOWN)) {
			playerY+= .1* delta;
			playerPoly.setY(playerY);
			if (entityCollisionWith()){
				playerY--;
				playerPoly.setY(playerY);
			}
		}
	}
	
	public boolean entityCollisionWith() throws SlickException {
		for (int i = 0; i < BlockMap.entities.size(); i++) {
			Block entity1 = (Block) BlockMap.entities.get(i);
			if (playerPoly.intersects(entity1.poly)) {
				return true;
			}       
		}       
		return false;
	}
	
	public void render(GameContainer container, Graphics g)  {
		BlockMap.tmap.render(0, 0);
		g.drawAnimation(player, playerX, playerY);
	}
	public static void main(String[] argv) throws SlickException {
		AppGameContainer container = 
			new AppGameContainer(new AryaMain(), 640, 480, false);
		container.start();
	}
}


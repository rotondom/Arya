package aryaFE;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Animation;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Polygon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Board extends JPanel implements Runnable, Commons { 

    private Dimension d;
    private ArrayList aliens;
    private Player player;
    private Shot shot;

    private int alienX = 150;
    private int alienY = 5;
    private int direction = -1;
    private int deaths = 0;

    private boolean ingame = true;
    private final String expl = "../spacepix/explosion.png";
    private final String alienpix = "../spacepix/alien.png";
    private String message = "Game Over";

    private Thread animator;
    
    
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
			playerX-= .1 * delta;
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
	
	public void drawBombing(Graphics g) {

	     Iterator i3 = aliens.iterator();      
	     while (i3.hasNext()) {
	         Alien a = (Alien) i3.next();

	         Alien.Bomb b = a.getBomb();
	         if (!b.isDestroyed()) {
	             g.drawImage(b.getImage(), b.getX(), b.getY(), this); 
	         }
	     }
	 }
}



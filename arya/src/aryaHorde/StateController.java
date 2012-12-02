package aryaHorde;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

/** 
 * Core class. State based game controller, acts as the main entry point for the game.
 * 
 * @author youngb2
 * @version 1.0
 */
public class StateController extends StateBasedGame implements GameConstants {

	public static final String gamename = "Project Arya";
	public static final int MENU = 0;
	public static final int PLAY = 1;
	
	public StateController(String name) {
		super(name);
		this.addState(new Menu(MENU));
		this.addState(new Play(PLAY));
	}
	
	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(MENU).init(gc, this);
		this.getState(PLAY).init(gc, this);
		
		this.enterState(MENU);
	}
	
	/**
	 * 
	 * @param args		the arguments passed to the program
	 */
	public static void main(String[] args) {
		AppGameContainer appgc;
		
		try {
			appgc = new AppGameContainer(new StateController(gamename));
			appgc.setDisplayMode(WIDTH, HEIGHT, false);
			appgc.start();
		} catch(SlickException e) {
			e.printStackTrace();
		}
	}
	
}

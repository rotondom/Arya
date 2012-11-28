package aryaHorde;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

/** 
 * Core class. State based game controller, acts as the main entry point for the game.
 * 
 * @author youngb2
 * @version 1.0
 */
public class StateController extends StateBasedGame {

	public static final String gamename = "Project Arya";
	public static final int menu = 0;
	public static final int play = 1;
	
	public StateController(String name) {
		super(name);
		this.addState(new Menu(menu));
		this.addState(new Play(play));
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(menu).init(gc, this);
		this.getState(play).init(gc, this);
		
		this.enterState(menu);
	}

	public static void main(String[] args) {
		AppGameContainer appgc;
		
		try {
			appgc = new AppGameContainer(new StateController(gamename));
			appgc.setDisplayMode(640, 480, false);
			appgc.start();
		} catch(SlickException e) {
			e.printStackTrace();
		}
	}
	
}

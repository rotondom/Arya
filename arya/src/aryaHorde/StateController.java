package aryaHorde;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

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
	public void initStatesList(GameContainer arg0) throws SlickException {
		
	}

	public static void main(String[] args) {
		
	}
	
}

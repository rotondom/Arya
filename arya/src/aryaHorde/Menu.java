package aryaHorde;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Menu extends BasicGameState {

		
	public Menu(int state) {
		
	}
	
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		
		g.fillOval(75, 100, 100, 100);
		g.drawString("Press me!", 85, 70);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		
		Input input = container.getInput();
		//int xpos = Mouse.getX();
		//int ypos = Mouse.getY();
		
	}

	@Override
	public int getID() {
		return 0;
	}

}

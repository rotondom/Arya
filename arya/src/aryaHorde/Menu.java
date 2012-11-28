package aryaHorde;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Menu extends BasicGameState {

	Image playButton;
		
	public Menu(int state) {
		
	}
	
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		
		playButton = new Image("res/bucky/playNow.png");
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		
		int playButtonX1 = (container.getWidth() / 2) - (playButton.getWidth() / 2);
		int playButtonY1 = (container.getHeight() / 2) - (playButton.getHeight() /2);
		
		g.drawImage(playButton, playButtonX1, playButtonY1);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		int mouseX = Mouse.getX();
		int mouseY = Mouse.getY();
		int playButtonX1 = (container.getWidth() / 2) - (playButton.getWidth() / 2);
		int playButtonY1 = (container.getHeight() / 2) - (playButton.getHeight() /2);
		int playButtonX2 = playButtonX1 + playButton.getWidth();
		int playButtonY2 = playButtonY1 + playButton.getHeight();
		
		Input input = container.getInput();
		
		if((mouseX > playButtonX1 && mouseX < playButtonX2) 
				&& (mouseY > playButtonY1 && mouseY < playButtonY2)) {
			if (input.isMouseButtonDown(0)) { game.enterState(1); }
		}
	}

	@Override
	public int getID() {
		return 0;
	}

}

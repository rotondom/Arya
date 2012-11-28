package aryaHorde;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState implements GameConstants {

	Animation player, movingUp, movingDown, movingLeft, movingRight;
	Image worldMap;
	boolean quitGame = false;
	//how long each image will last (200 = 2/10 of a second)
	int[] duration = {200, 200};
	float playerPositionX = 0;
	float playerPositionY = 0;
	float shiftX = playerPositionX + WIDTH/2;
	float shiftY = playerPositionY + HEIGHT/2;
	
	
	
	public Play(int state) {
		
	}
	
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		
		//Image back = new Image("res/bucky/buckysBack.png");
		//Image backFlipped = back.getFlippedCopy(false, true);
		//Image left = new Image("res/bucky/buckysLeft.png");
		//Image leftFlipped = left.getFlippedCopy(false, true);
		
		worldMap = new Image("res/bucky/world.png");
		Image[] walkUp = {new Image("res/bucky/buckysBack.png"), new Image("res/bucky/buckysBack.png")};
		Image[] walkDown = {new Image("res/bucky/buckysFront.png"), new Image("res/bucky/buckysFront.png")};
		Image[] walkLeft = {new Image("res/bucky/buckysLeft.png"), new Image("res/bucky/buckysLeft.png")};
		Image[] walkRight = {new Image("res/bucky/buckysRight.png"), new Image("res/bucky/buckysRight.png")};
		
		movingUp = new Animation(walkUp, duration, false);
		movingDown = new Animation(walkDown, duration, false);
		movingLeft = new Animation(walkLeft, duration, false);
		movingRight = new Animation(walkRight, duration, false);
		
		player = movingDown;
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		worldMap.draw(playerPositionX, playerPositionY);
		player.draw(shiftX, shiftY);
		g.drawString("Ermagerd, the player is at x: " + -1 * playerPositionX 
				+ " y: " + playerPositionY, 20, HEIGHT - 20);
		
		if(quitGame) {
			g.drawString("Resume (R)", 250, 100);
			g.drawString("Main Menu (M)", 250, 130);
			g.drawString("Quit Game (Q)", 250, 160);
			if(!quitGame) {
				g.clear();
				System.exit(0);
			}
		}
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		Input input = container.getInput();
		
		if(input.isKeyDown(Input.KEY_W)) {
			player = movingUp;
			playerPositionY += delta * .1f;
			
		}
		if(input.isKeyDown(Input.KEY_A)) {
			player = movingLeft;
			playerPositionX += delta * .1f;
			
		}
		if(input.isKeyDown(Input.KEY_S)) {
			player = movingDown;
			playerPositionY -= delta * .1f;
			
		}
		if(input.isKeyDown(Input.KEY_D)) {
			player = movingRight;
			playerPositionX -= delta * .1f;
			
		}
	}

	@Override
	public int getID() {
		return 1;
	}

}

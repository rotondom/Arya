package aryaHorde;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState implements GameConstants {

	Animation player, movingUp, movingDown, movingLeft, movingRight;
	Image worldMap;
	boolean quitGame = false;
	//how long each image will last (200 = 2/10 of a second)
	int[] duration = {200, 200};
	float cameraX = 0;
	float cameraY = 0;
	float playerX = cameraX + WIDTH/2;
	float playerY = cameraY + HEIGHT/2;
	float centeredX = playerX;
	float centeredY = playerY;
	float lowerYCollisionShift;
	
	
	
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
		
		lowerYCollisionShift = (-1 * worldMap.getHeight() + playerY * 2 + movingDown.getHeight());
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		worldMap.draw(cameraX, cameraY);
		player.draw(playerX, playerY);
		g.drawString("Camera is at x: " + cameraX 
				+ " y: " + cameraY, 20, HEIGHT - 20);
		g.drawString("Player is at x: " +  playerX 
				+ " y: " + playerY, 20, HEIGHT - 40);
		
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
		
		if(input.isKeyDown(Input.KEY_W)) {						//Move up
			player = movingUp;
			
			
			if(cameraY < 0) {									//Track camera up
				//move camera
				cameraY += delta * .1f;
				if (cameraY < lowerYCollisionShift) {			//Lock camera, move player up (top border)
					cameraY -= delta * .1f;
					playerY -= delta * .1f;
				} else if (playerY > centeredY ) {				//lock camera, move player up. (lower border)
					playerY -= delta * .1f;
					cameraY -= delta * .1f;
				}
			} else {											
				//move player
				playerY -= delta * .1f;
				if (playerY <= 0) { 
					playerY += delta * .1f; 
				}
			}
		}
		
		if(input.isKeyDown(Input.KEY_S)) {						//Move down
			
			player = movingDown;
			
			if(cameraY > lowerYCollisionShift) {
				cameraY -= delta * .1f;
				if (cameraY < lowerYCollisionShift - playerY) {
					cameraY += delta * .1f;
					playerY -= delta * .1f;
				} else if (playerY < centeredY) {
					playerY += delta * .1f;
					cameraY += delta * .1f;
				}
			} else {
				//move player
				playerY += delta * .1f;
				if (playerY >= (centeredY * 2) - movingDown.getHeight()) {
					playerY -= delta * .1f;
				}
			}
		}
		
		if(input.isKeyDown(Input.KEY_A)) {
			player = movingLeft;
			cameraX += delta * .1f;
			
		}
		
		
		
		if(input.isKeyDown(Input.KEY_D)) {
			player = movingRight;
			cameraX -= delta * .1f;
			
		}
	}

	@Override
	public int getID() {
		return 1;
	}

}

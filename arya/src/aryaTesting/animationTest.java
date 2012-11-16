package aryaTesting;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import aryaCharacters.Zombie;

/**
 * 
 * @author youngb2
 * @since Alpha.02
 */
public class animationTest extends BasicGame{

	protected Zombie testUnit;
	Color bg = new Color(0, 0, 0);
	
	public animationTest() {
		super("Test Animation");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(GameContainer game, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		g.setBackground(bg);
		testUnit.drawAttack(20, 20);
	}

	@Override
	public void init(GameContainer game) throws SlickException {
		testUnit = new Zombie();
	}

	@Override
	public void update(GameContainer game, int arg1) throws SlickException {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] argv) throws SlickException {
		AppGameContainer container = 
			new AppGameContainer(new animationTest(), 640, 480, false);
		container.start();
	}
}

package arya;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 * The main game program
 * 
 * @author Bryan Young
 * @version 0.01, 6 November 2012
 */
public class AryaMain extends BasicGame {
	
	public BlockMap map;
	
	public AryaMain() {
		super("Project Arya");
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		BlockMap.tmap.render(0, 0);
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		container.setVSync(true);
		map = new BlockMap("data/FirstMap.tmx");
		
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		
	}

	public static void main (String[] args) throws SlickException {
		AppGameContainer container = new AppGameContainer(new AryaMain());
		container.setDisplayMode(640, 480, false);
		container.start();
	}
}

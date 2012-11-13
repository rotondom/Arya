package arya;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

/**
 * Manages information used to render the unit health Heads Up Display object drawn over the game screen.
 * @author youngb2
 *
 */
public class UnitHealthHUD {
	Graphics unitStats = new Graphics();
	Image icon;
	Rectangle background;
	Rectangle healthTotal;
	Rectangle healthCurrent;
	String name = "Arya";
	String hp = "HP:";
	int health = 0;
	int totalHealth = 100;
	
	/**
	 * Constructor to create an appropriately scaled HUD for the game container
	 * @param container		the AppGameContainer to build the health HUD for, provides information on size
	 * @param unit			the unit who's health stats are to be rendered
	 * @throws SlickException 
	 */
	UnitHealthHUD(AppGameContainer container, BasicUnit unit) throws SlickException {
		background.setSize((float)(container.getWidth()*.3), (float)(container.getHeight()*.2));
		icon = unit.getIcon();
		
	}
	
	void render() {
		
	}
}

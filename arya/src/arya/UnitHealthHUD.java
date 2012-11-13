package arya;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Color;
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
	Color bgColor = new Color(95, 235, 245, 200); //Light blue, some transparency
	Rectangle background;
	Rectangle healthTotal;
	Rectangle healthCurrent;
	String name = "Arya";
	String hp = "HP:";
	int health = 0;
	int totalHealth = 100;
	double width;
	double height;
	
	/**
	 * Constructor to create an appropriately scaled HUD for the game container
	 * @param container		the AppGameContainer to build the health HUD for, provides information on size
	 * @param unit			the unit who's health stats are to be rendered
	 * @throws SlickException 
	 */
	UnitHealthHUD(AppGameContainer container, BasicUnit unit) throws SlickException {
		width = (double)(container.getWidth())*.3;
		height = (double)(container.getHeight())*.2;
		background = new Rectangle(0, 0, (float)(container.getWidth()*.3), (float)(container.getHeight()*.2));
		unitStats.setColor(bgColor);
		unitStats.fill(background);
		icon = unit.getCharacterSheet();
		unitStats.drawImage(icon, 5, 5, 69, 69, 0, 0, 64, 64); //crop to the first frame of the characterSheet
		unitStats.drawString(name, 82, 5);
		
	}
	
	void render() {
		
	}
}

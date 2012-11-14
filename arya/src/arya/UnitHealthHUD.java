package arya;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
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
	int health = 50;
	int totalHP = 100;
	float bgWidth;
	float bgHeight;
	double iconWidth;
	double barTotalWidth;
	double healthBarWidth;
	
	/**
	 * Constructor to create an appropriately scaled HUD for the game container
	 * @param container		the AppGameContainer to build the health HUD for, provides information on size
	 * @param unit			the unit who's health stats are to be rendered
	 * @throws SlickException 
	 */
	public UnitHealthHUD(GameContainer container, BasicUnit unit) throws SlickException {
		bgWidth = (float)(container.getWidth()*.3);
		bgHeight = (float)(container.getHeight()*.2);
		background = new Rectangle(0, 0, bgWidth, bgHeight);
		unitStats.setColor(bgColor);
		unitStats.fill(background);
		
		iconWidth = bgWidth*.45;
		icon = unit.getCharacterSheet();
		unitStats.drawImage(icon, 5, 5, (int)iconWidth, (int)bgHeight-5, 0, 0, 64, 64); //crop to the first frame of the characterSheet
		unitStats.drawString(name, 82, 5);
		
		barTotalWidth = bgWidth-5 - bgWidth * .5;
		healthBarWidth = barTotalWidth * (1 - ((totalHP - health) / totalHP));
		//Fix the following line, too long and nasty
		healthCurrent = new Rectangle((float)(bgWidth *.5), (float)(bgHeight*.74), (float)(bgWidth - 5), (float)(bgHeight*.76));
	}
	
	void render() {
		
	}
}

package arya;

import org.newdawn.slick.Image;

/**
 * Superclass for game units, both player and NPC. 
 * Provides methods and variables to manipulate and track unit statistics.
 *  
 *  @author youngb2
 *  @since 0.01
 */

public class BasicUnit {
	
	protected int xPosition;
	protected int yPosition;
	
	protected Weapon equipped;
	protected int totalHealth;
	protected int health;
	protected int skill;
	protected int attack;
	protected int defence;
	protected int movement;
	protected int speed;
	
	protected Image characterSheet;
	protected Image worldSprite;
	protected Image combatSprite;
	protected Image icon = characterSheet.getSubImage(0, 0, 64, 64);	//The icon is the first frame of characterSheet
	
	
	/**
	 * Checks the state of life of the unit
	 * @return 	true or false based on the unit's health
	 */
	protected Boolean checkLife() {
		if(this.health <= 0) return false;
		return true;
	}
	
	/**
	 * Outlines the combat engine that dictates the results of character engagement
	 * @param opponent		the character being attacked
	 */
	protected void combat(BasicUnit opponent) {
		//Initial attack
		final int damageInflicted = this.attack + equipped.damage;
		opponent.health -= damageInflicted;
		//Call attack animation of this
		
		//Retaliation if opponent is not dead
		if (opponent.checkLife()) {
			final int damageTaken = opponent.attack + equipped.damage;
			this.health -= damageTaken;
			//call attack animation of opponent
		}
	}
	
	/**
	 * Disposes of the unit and it's references and resources
	 */
	protected void dispose() {
		//Destroy character object
	}
	
	/**
	 * Gets the health of a unit
	 * @return
	 */
	int getHealth() {
		return health;
	}
	
	/**
	 * Gets the combat sprite sheet image of the unit
	 * @return		the combat sprite sheet of the unit
	 */
	Image getCombatSprite() {
		return combatSprite;
	}
	
	/**
	 * Gets the icon image of the unit
	 * @return		the icon image of the unit
	 */
	Image getIcon() {
		return icon;
	}
	
	/**
	 * Gets the world sprite sheet image of the unit
	 * @return		the world sprite sheet image of the unit
	 */
	Image getWorldSprite() {
		return worldSprite;
	}
	
	/**
	 * Sets the units health
	 * @param health		the new value for the unit's health to be set to
	 */
	void setHealth(int health) {
		this.health = health;
	}
}

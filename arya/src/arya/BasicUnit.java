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
	
	//Both Getter and setters
	protected Weapon equipped;
	protected int totalHealth;
	protected int health;//done
	protected int skill;
	protected int attack;
	protected int defense;
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
	 * Gets the unit's attack strength
	 * @return the integer value of the unit's strength
	 */
	int getAttack() {
		return attack;
	}
	
	/**
	 * Gets the character sheet Image
	 * @return the Image object of the character sheet
	 */
	Image getCharacterSheet() {
		return characterSheet;
	}
	
	/**
	 * Gets the combat sprite sheet image of the unit
	 * @return		the combat sprite sheet of the unit
	 */
	Image getCombatSprite() {
		return combatSprite;
	}
	
	/**
	 * Gets the unit's defensive strength
	 * @return the integer value of the unit's defense
	 */
	int getDefense() {
		return defense;
	}
	/**
	 * Gets the unit's currently equipped weapon
	 * @return the Weapon object equipped by the unit
	 */
	Weapon getEquipped() {
		return equipped;
	}
	
	/**
	 * Gets the health of a unit
	 * @return the integer value of the unit's current health
	 */
	int getHealth() {
		return health;
	}
	
	/**
	 * Gets the icon image of the unit
	 * @return		the icon image of the unit
	 */
	Image getIcon() {
		return icon;
	}
	
	/**
	 * Gets the unit's movement value
	 * @return	the integer value of the unit's movement value
	 */
	int getMovement() {
		return movement;
	}

	/**
	 * Gets the unit's speed value
	 * @return	the integer value of the unit's speed
	 */
	int getSpeed() {
		return speed;
	}

	/**
	 * Gets the unit's skill
	 * @return 	returns the integer value of the unit's skill
	 */
	int getSkill() {
		return skill;
	}

	/**
	 * Gets the unit's max health
	 * @return	the integer value of the unit's max health
	 */
	int getTotalHealth() {
		return totalHealth;
	}
	
	/**
	 * Gets the world sprite sheet for the unit
	 * @return	the Image of the unit's world sprite sheet
	 */
	Image getworldSprite() {
		return worldSprite;
	}
	
	/**
	 * Gets the world sprite sheet image of the unit
	 * @return	the world sprite sheet image of the unit
	 */
	Image getWorldSprite() {
		return worldSprite;
	}

	/**
	 * Sets the unit's attack strength
	 * @param attack		the new value for the unit's attack
	 */
	void setAttack(int attack) {
		this.attack = attack;
	}

	/**
	 * Sets the character sprite sheet
	 * @param characterSheet	the new Image for the unit's icons
	 */
	void setCharacterSheet(Image characterSheet) {
		this.characterSheet = characterSheet;
	}
	
	/**
	 * Sets the unit's combat sprite sheet
	 * @param combatSprite	the new Image for the unit's sprite sheet
	 */
	void setCombatSprite(Image combatSprite) {
		this.combatSprite = combatSprite;
	}
	
	/**
	 * Sets the unit's defense value
	 * @param defense		the new value for the unit's defense
	 */
	void setDefence(int defense){ 
		this.defense = defense;
	}

	/**
	 * Sets the equipped weapon of the unit
	 * @param equipped		the new equipped weapon of the unit
	 */
	void setEquipped(Weapon equipped) {
		this.equipped = equipped;
	}
	/**
	 * Sets the unit's health
	 * @param health		the new value for the unit's health
	 */
	void setHealth(int health) {
		this.health = health;
	}

	/**
	 * Sets the unit's movement value
	 * @param movement
	 */
	void setMovement(int movement) {
		this.movement = movement;
	}

	/**
	 * Sets the unit's skill
	 * @param skill			the new value for the unit's skill
	 */
	void setSkill(int skill) {
		this.skill =skill;
	}

	/**
	 * Sets the unit's speed	
	 * @param speed			the new value for the unit's speed
	 */
	void setSpeed(int speed) {
		this.speed= speed;
	}

	/**
	 * Sets the max health of the unit
	 * @param totalHealth	the new max health value for the unit
	 */
	void setTotalHealth(int totalHealth) {
		this.totalHealth = totalHealth;
	}

	/**
	 * Sets the world sprite sheet of the unit
	 * @param worldSprite	the new Image for the unit's world sprite sheet
	 */
	void setWorldSprite(Image worldSprite) {
		this.worldSprite = worldSprite;
	}


}
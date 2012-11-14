package arya;

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
	protected int health;
	protected int skill;
	protected int attack;
	protected int defence;
	protected int movement;
	protected int speed;
	
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
	 * Gets the state of life of the unit
	 * @return 	true or false based on the unit's health
	 */
	protected Boolean checkLife() {
		if(this.health <= 0) return false;
		return true;
	}
	
	/**
	 * Removes object from update list, destroys any references to the object
	 */
	protected void destructor() {
		//Destroy character object
	}
}

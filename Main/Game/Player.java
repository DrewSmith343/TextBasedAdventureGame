package Game;

import Items.Item;

/**
 * Player.java
 * 
 * Class to model the player and create their name, health and damage.
 *
 * @author Drew Smith, Marshall Kirk, Joel Penney
 */

public class Player {

	/**
	 * The players health and damage
	 */
	private int health, damage;

	/**
	 * creates a private inventory for the player thats handled in the inventory
	 * class, a class only player works with
	 */
	private Inventory Inventory = new Inventory();

	/**
	 * the players instance, since there is only one
	 */
	private static Player instance;

	/**
	 * Private constructor since we will only make one
	 */
	private Player() {
		health = 100;
		damage = 5;
	}

	/**
	 * Static initializer
	 */
	static {
		instance = new Player();
	}

	/**
	 * Updates the players damage with the best damage in the inventory and
	 * prints out the new damage
	 */
	public void update() {
		damage = Inventory.bestWepDamage();
		System.out.print("your damage is now " + damage);
		System.out.println("");
	}

	/**
	 * A command to eat a specific food from the inventory that also
	 * prevents one from eating to over 100 health
	 * 
	 * @param the food the player wants to eat
	 */
	public void eat(String input) {
		if (health < 100) { //Eligible to eat
			int temp = Inventory.heal(input);//gets the integer return of health (all health is >0) of that item from the inventory
			if(eatHelper(temp)) System.out.println("You don't have that food"); 
		} else
			System.out.println("You are at full health"); //Can't eat past 100
	}

	/**
	 * A command to eat a random food from the inventory that also
	 * prevents one from eating to over 100 health
	 */
	public void eatRandom() {
		if (health < 100) {
			int temp = Inventory.healRandom();//all is same as above except a random food is grabbed
			if(eatHelper(temp)) System.out.println("You don't have any food"); 
		}else
			System.out.println("You are at full health");
	}

	public boolean eatHelper(int temp){
		if (temp != 0) {
			System.out.println("You gained " + temp + " points of health");
			health = health + temp;
			if (health > 100)
				health = 100;
			System.out.println("Your total health is: " + health);
			return false; 
		} else
			return true; 
	}
	
	/**
	 * Prints the inventory by calling the print command in inventory class
	 */
	public void inventory() {
		Inventory.getInventory();
	}

	/**
	 * Adds an item to inventory
	 * 
	 * @param the item to add
	 */
	public void addItem(Item grabed) {
		Inventory.addItem(grabed);
	}

	/**
	 * Prints out the players current stats
	 */
	public void status() {
		System.out.println("Health: " + health);
		System.out.println("Damage: " + damage);
	}

	/**
	 * Accesor for damage
	 * 
	 * @return the damage a player inflicts
	 */
	public int getDamage() {
		return damage;
	}

	/**
	 * Accesor for health
	 * 
	 * @return the health a player has remaining
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * inflicts damage upon the player, makes sure it isn't game over, and 
	 * prints out the effects 
	 * 
	 * @param damage to take
	 */
	public void takeDamage(int dam) {
		health = health - dam; //does the damage
		System.out.println("You took: " + dam + " points of damage and have: " + health + " health points left");
		if (!isAlive()) //makes sure the game is still going
			Game.getGame().finishGame();//Game over
	}

	/**
	 * Checks to make sure the player is in fact, alive
	 * 
	 * @return is he alive?
	 */
	public boolean isAlive() {
		if (health > 0) //if not dead
			return true;
		else
			return false; //you dead
	}

	/**
	 * Static instance getter
	 * 
	 * @return the player
	 */
	public static Player getInstance() {
		return instance;
	}

	/**
	 * Checks to see if the player has the appropriate tech
	 * 
	 * @param which tech for the planet number?
	 * @return does he have that tech
	 */
	public boolean hasTech(int i) {
		return Inventory.hasTech(i);
	}

}

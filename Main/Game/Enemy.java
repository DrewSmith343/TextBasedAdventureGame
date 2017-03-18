package game;

/**
 * Enemy.java
 * 
 * Class to model an enemy that spawns in rooms and create its name health
 * damage.
 *
 * @author Drew Smith, Marshall Kirk, Joel Penney
 */

public class Enemy {

	private int damage, health; // Stores the damage and the health of the enemies

	private String name; // Stores the name of the enemy after it has been selected from the array of possible enemies


	private static String[][] nameArray = { // The array of enemy names that can appear, with each subarray
											// storing the planets spawn list
			{ "Wolf", "Bear", "Moose", "Scorpian", "Land Whale", "Flying Bear", "Horse", "Aggresive tree", "Spider",
					"One Ply Toilet paper" },
			{ "Land Fish", "Frog Thing", "Giant Mole", "Venomous snake", "Giant Land Whale", "Zombie",
					"Poisnous flowers", "Radioactive Hamster", "Aggresive mutants", "Super Strong Rodents" },
			{ "Slightly Miffed Sand Hermit", "Rock Crab", "One Ply Toilet paper", "Angry Sand Hermit", "Giant Desert Land Whale", "Pit Viper",
					"Desert Rat", "Aggressive Cactus", "Angry Sand", "Big Scorpion" },
			{ "Huge Bat", "Daredevil", "Guy in a clown mask", "Bat-man", "Giant Flying Pale Land whale", "Guy-who-sneaks-up-and-5-stars-you", "Pile of legos in a dark room",
					"Shady-looking character", "Giant Eagle with INFRARED GOGGLES!!!!", "One Ply Toilet paper"},
			{ "Giant Flying Land whale with freaking laser beams", "Former human", "Demon", "One Ply Toilet paper", "Militerized Ants", "Super mutants",
					"Weaponized AI", "Terminator robots", "Brain Sucking Parasites", "Unkown malicous force" } };

	/**
	 * Constructs enemies and randomly sets a damage and health based on the
	 * planet and the curve for each Also checks to see if it is one of the boss
	 * types
	 * 
	 * @param the planet this is on to manage difficulty curve and possible monster spawns
	 */
	public Enemy(int level) {
		name = nameArray[(int) (Math.random() * (level - 1))][(int) (Math.random() * 10)].toLowerCase();//randomly sets the enemy name
		damage = (int) ((Math.random() * (5 * level)) + 1 ); //Randomly set damage
		health = (int) ((Math.random() * (25 * level)) + 1 );//Randomly set health 
		if (name.equalsIgnoreCase("Giant Flying Land whale with freaking laser beams")) { //check to see if it is a boss and upscale attacks and health
			System.out.println("The Harbinger of end times has arived");
			damage = (damage + 5) * 2;
			health = (health + 25) * 2;
		}
	}

	/**
	 * Accessor for name
	 * 
	 * @return The name of the enemy
	 */
	public String getName() {
		return name;
	}

	/**
	 * Accessor for damage
	 * 
	 * @return The damage of the enemy
	 */
	public int getDamage() {
		return damage;
	}

	/**
	 * Accessor for remaining health
	 * 
	 * @return The remaining health of the enemy
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * Takes damage from the player and prints the amount of damage done and
	 * then tells the program whether the enemy is alive
	 * 
	 * @param the amount of damage to remove from the enemy
	 * @return whether the enemy is alive
	 */
	public boolean takeDamage(int input) {
		health = health - input;
		System.out.println("You attack for: " + input + " points of damage leaving " + health + " points");
		return isAlive();
	}

	/**
	 * Accesor for life
	 * 
	 * @return if the enemy is alive
	 */
	public boolean isAlive() {
		if (health <= 0)
			return false;
		else
			return true;
	}

}

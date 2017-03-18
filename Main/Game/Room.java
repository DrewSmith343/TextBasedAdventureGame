package Game;

import Items.*;

/**
 * Room.java
 * 
 * Class to model a room in the game.
 *
 * @author Drew Smith, Marshall Kirk and Joel Penney
 * 
 */

public class Room {

	/**
	 * Stores the adjacent rooms so the room knows its neighbors
	 */
	private Room north, south, east, west;

	/**
	 * Array of items in the room
	 */
	private Item[] items = new Item[2];

	/**
	 * If the room has the tech to move onto the next planet, separate from
	 * items to make sure planets can't be
	 */
	private Tech tech;

	/**
	 * The planet level the room is in
	 */
	private int level;

	/**
	 * The enemy, if there is one, that is in the room
	 */
	private Enemy monster;

	/**
	 * A description of this rooms elements stored in an array
	 */
	private String[] descrip = new String[5];

	/**
	 * The possible descriptions of each room and the subarrays that are each
	 * planets description
	 */
	private static String[][] descriptionArray = {
			{ "A grassy field", "A mountainous range", "A deserted city", "A beach by the ocean", "A cliffside",
					"A vast desert", "A swampy marsh", "A grassy field", "A mountainous range", "A deserted city",
					"A beach by the ocean", "A cliffside", "A vast desert", "A swampy marsh", "A field",
					"The foothills of the mountains", "A tropical forest", "A thick forest", "A tundra", "A rainforest",
					"A deserted cemetary" },
			{ "A Dome-Like Structure", "An air concentration facility", "A strange platform", "A dark cave",
					"A Dome-Like Structure", "An air concentration facility", "A strange excess of air",
					"A strange platform", "A fake town", "A lifeform study lab", "A secret facility", "A fake town",
					"A lifeform study lab", "A secret facility", "An air concentration facility",
					"A Dome-Like Structure", "A dark cave", "A strange platform", "A lifeform study lab",
					"A secret facility", "A chemical and toxin study center" },
			{ "A water supply room", "A geography mapping room", "A sand farm", "A satelite dish", "An oasis",
					"A Red Desert", "A Desert Village", "A Rock Formation", "A mirage",
					"An Unusually Large Amount of Sand", "A Desert Village", "An Unusually Large Amount of Sand",
					"An oasis", "A geography mapping room", "A Rock Formation", "A water supply room", "A mirage",
					"A Red Desert", "A ton of sand", "An unsettling amount of sand", "A sand farm" },
			{ "A vision testing room", "An art gallery", "A shooting range", "A scenic park",
					"A house with a view of the ocean", "An art gallery", "A theater with no artificial lighting",
					"A vision testing room", "A theater with no artificial lighting",
					"A house with a view of the ocean", "A shooting range", "A scenic park", "An art gallery",
					"A vision testing room", "A house with a view of the ocean",
					"A theater with no artificial lighting", "A scenic park", "A tower with a telescope",
					"An art gallery", "A theater with no artificial lighting", "A house with a view of the ocean" },
			{ "A collapsed skyscraper", "A flooded hotel", "A rusting statue", "An abandoned mall",
					"A Destroyed suburb", "A large crater", "A decrepit research facility",
					"A decrepit research facility", "A Destroyed suburb", "A large crater", "An abandoned prison",
					"A rusting statue", "An abandoned mall", "A collapsed skyscraper", "An abandoned prison",
					"A Destroyed suburb", "A large crater", "A flooded hotel", "An abandoned mall", "A rusting statue",
					"A decrepit research facility" } };

	/**
	 * Builds the rooms description based on which randomly selected
	 * description, if a item is made based on the spawn rate and if there is a
	 * monster based on the spawn rate
	 * 
	 * @param the planet that this room is on
	 */
	public Room(int level) {
		int temp = (int) (Math.random() * 20);
		descrip[0] = descriptionArray[level - 1][temp].toLowerCase();

		if (((int) (Math.random() * 100)) <= 45) // The spawn rate for food
			creator(1, items[0] = new Food()); // creates the food and adds it to the room in the creator method and adds it to the item array
		else
			descrip[1] = "NA"; // If it doesn't spawn the no item description is added to the description array

		if (((int) (Math.random() * 100)) <= 30)// Same as above but for weapons
			creator(2, items[1] = new Weapon(level));
		else
			descrip[2] = "NA";

		if (((int) (Math.random() * 100)) <= 45) // same as above but for monster
			monsterCreator(this.monster = new Enemy(level));
		else
			descrip[3] = "NA";

		descrip[4] = "NA";
		this.level = level; // sets the level
	}

	/**
	 * Sets the descriptor for the description array
	 * 
	 * @param The place to insert this item in the description array
	 * @param item that has been created and is in the room
	 */
	private void creator(int i, Item item) {
		if (isVowel(item.getItem())) // Checks to see whether a or an should be printed
			descrip[i] = " and there is an " + item.getItem(); // adds the item to the description array with the proper description
		else
			descrip[i] = " and there is a " + item.getItem();
	}

	/**
	 * Sets the descriptor for the description array
	 * 
	 * @param monster to add to the room
	 */
	private void monsterCreator(Enemy monster) {
		if (isVowel(monster.getName()))// Same as item but for monster
			descrip[3] = " and there is an " + monster.getName();
		else
			descrip[3] = " and there is a " + monster.getName();
	}

	/**
	 * used to grammatically set descriptors
	 * 
	 * @param the string to check
	 * @return if the item begins with a vowel
	 */
	private boolean isVowel(String item) {
		String temp = item.substring(0, 0); // string of first character
		if (temp.equals("a") || temp.equals("e") || temp.equals("i") || temp.equals("o") || temp.equals("u")) // if it is a vowel
			return true;
		else
			return false;
	}

	/**
	 * Sets the northern room for travel
	 * 
	 * @param the room to the north
	 */
	public void setNorth(Room north) {
		this.north = north;
	}

	/**
	 * Sets the southern room for travel
	 * 
	 * @param the room to the south
	 */
	public void setSouth(Room south) {
		this.south = south;
	}

	/**
	 * Sets the eastern room for travel
	 * 
	 * @param the room to the east
	 */
	public void setEast(Room east) {
		this.east = east;
	}

	/**
	 * Sets the western room for travel
	 * 
	 * @param the room to the west
	 */
	public void setWest(Room west) {
		this.west = west;
	}

	/**
	 * Turns the description stored in the array into a string for display
	 * 
	 * @return the description pulled form the array in a string
	 */
	public String getDescription() {
		String temp = "";// Holds the description
		for (int i = 0; i < 5; i++) { // runs through the array
			if (!descrip[i].equals("NA")) { // If theres something in that array slot ("NA" is no item)
				temp = temp + descrip[i]; // Add it to the string
			}
		}
		return temp; // return the string
	}

	/**
	 * Methods to determine the rooms to which the northern door -- if it
	 * exists -- leads.
	 * 
	 * @return the northern room
	 */
	public Room getNorth() {
		return north;
	}

	/**
	 * Methods to determine the rooms to which the southern door -- if it
	 * exists -- leads.
	 * 
	 * @return the southern room
	 */
	public Room getSouth() {
		return south;
	}

	/**
	 * Methods to determine the rooms to which the eastern door -- if it exists --
	 * leads.
	 * 
	 * @return the eastern room
	 */
	public Room getEast() {
		return east;
	}

	/**
	 * Methods to determine the rooms to which the western door -- if it exists --
	 * leads.
	 * 
	 * @return the western room
	 */
	public Room getWest() {
		return west;
	}

	/**
	 * Used to take items from room and give them to players as well as delete
	 * them from the room and delete their description
	 * 
	 * @return the item being taken
	 */
	public Item transfer() {
		if (!descrip[1].equals("NA") && descrip[2].equals("NA")) //If item 1 is present
			return nullifyer(1);
		else
			return nullifyer(2);
	}

	/**
	 * deletes the item from the array and returns an equal value to pass to the player array
	 * as well as deleting the description
	 * 
	 * @param the element to delete
	 * @return the items value
	 */
	private Item nullifyer(int num) {
		Item temp = items[num - 1];
		items[num - 1] = null;
		descrip[num] = "NA";
		return temp;
	}

	/**
	 * Adds the special tech item, or item that allows one to progress through the game
	 */
	public void addTech() {
		this.tech = new Tech(level - 1); //Which tech to spawn and it creates the tech
		if (isVowel(tech.getItem())) //Adds the proper description to the array
			descrip[4] = " and there is an " + tech.getItem();
		else
			descrip[4] = " and there is a " + tech.getItem();
	}

	/**
	 * Accessor for tech
	 * 
	 * @return the tech in the room
	 */
	public Tech getTech() {
		descrip[4] = "NA";
		return tech;
	}

	/**
	 * Accessor for the enemy 
	 * 
	 * @return the enemy in the room
	 */
	public Enemy getEnemy() {
		if (!descrip[3].equals("NA"))
			return monster;
		else
			return null;
	}

	/**
	 * Kills the monster and obliterates it from existence
	 */
	public void kill() {
		monster = null;
		descrip[3] = "NA";
	}

	/**
	 * Returns whether or not the room has basic items
	 * 
	 * @return if the room has items
	 */
	public boolean hasItems() {
		if (items[0] != null || items[1] != null) //Array contains items 
			return true;
		return false;
	}

	/**
	 * Returns whether the room has tech
	 * 
	 * @return if the room has tech
	 */
	public boolean hasTech() {
		if (!descrip[4].equals("NA"))
			return true;
		return false;
	}
}
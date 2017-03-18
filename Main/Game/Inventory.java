package Game;

import java.util.ArrayList;

import Items.*;
import Items.Weapon;

/**
 * Inventory.java
 * 
 * Class to hold the items a player has
 *
 * @author Drew Smith, Marshall Kirk, Joel Penney
 */

public class Inventory {

	/**
	 * An array list holding the inventory
	 */
	private ArrayList<Item> inventory; 
	
	/**
	 * The index of the best weapon a player has
	 */
	private int index; 

	/**
	 * creates the array list 
	 */
	public Inventory() {
		inventory = new ArrayList<Item>();
		Item weapon = new Weapon("Fist",5);
		inventory.add(weapon); 
		index = inventory.indexOf(weapon); 
	}

	/**
	 * Adds an item to the inventory
	 * 
	 * @param the item picked up
	 */
	public void addItem(Item grabed) {
		inventory.add(grabed);
	}

	/**
	 * Checks to see if the player has the specific tech
	 * 
	 * @param which tech are we checking to see if he has
	 * @return does he have it
	 */
	public boolean hasTech(int i) {
		String[] techs = { "Oxygen Extraction Device", "Heat-Resistant Suit", "Helmet Light",
				"Radiation-Resistant Suit", "YE FLASK OF LEGEND" };//List of techs
		if (contains(techs[i]) == -1) //constins returns -1 if it does not contain it
			return false;
		else
			return true;
	}

	/**
	 * Prints out the current inventory in a nice pretty way
	 */
	public void getInventory() {
		for (int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i).getItem().equalsIgnoreCase("Ye flask of legend"))
				System.out.println((i+1) + ": " + inventory.get(i).getItem() + " (The mission objective)");
			else{
				System.out.print((i+1) + ": " + inventory.get(i).getItem() + " (" + inventory.get(i).getType().toLowerCase());
				if (inventory.get(i).getType().toLowerCase().equals("nourishment")) 
					System.out.println(" --> hp: " + inventory.get(i).heal()+")");
				else if (inventory.get(i).getType().toLowerCase().equals("weapon")) 
					System.out.println(" --> damage: " + inventory.get(i).damage()+")");
				else
					System.out.println(")");
			}
		}
	}

	/**
	 * If the inventory is holding a certain Item
	 * 
	 * @param the name of the item to return
	 * @return whether it contains the item
	 */
	public int contains(String name) {
		for (int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i).getItem().equals(name))
				return i;
		}
		return -1;
	}

	/**
	 * If the inventory has food and returns the first index of it
	 * 
	 * @return the index of the food, -1 if no such item
	 */
	private int hasFood() {
		for (int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i).isFood())
				return i;
		}
		return -1;
	}

	/**
	 * scours the arraylist to see what the best damage is
	 * 
	 * @return the best damage as an int of that damage
	 */
	public int bestWepDamage() {
		for (int i = 0; i < inventory.size(); i++) { 
			if (inventory.get(index).damage()<inventory.get(i).damage()){ 
				System.out.print("Hey a new weapon, and its better than your " + inventory.get(index).getItem() + " and ");
				inventory.remove(index);
				index = i-1; 
				break; 
			}else if (inventory.get(i).isWep()&&i!=index){
				System.out.print("Shame though, it's not as good as your " + inventory.get(index).getItem() +" so you drop it and ");
				inventory.remove(i); 
			}
		}
		return inventory.get(index).damage(); 
	}

	/**
	 * Gets the health of a specific food item
	 * 
	 * @param the name of the food the player wants to eat
	 * @return the health the food heals for
	 */
	public int heal(String food) {
		int location = contains(food);//returns the index of that food
		return healHelper(location); 
	}

	/**
	 * Heals an amount of health based on the first food you have
	 * 
	 * @return the health the food heals for
	 */
	public int healRandom() { //same as above
		int location = hasFood();
		return healHelper(location); 
	}

	/**
	 * Used to simplify the heal command
	 * 
	 * @param the location of the food
	 * @return the amount it heals
	 */
	private int healHelper(int location){
		if (location != -1) { //if it is contained
			int heal = inventory.get(location).heal(); // stores the heal value (the get(location).heal calls the foods accesor method for health) 
			inventory.remove(location); //removes the item from the array list
			return heal; //returns the health
		}
		return 0;
	}
}

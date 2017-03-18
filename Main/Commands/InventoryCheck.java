package commands;

import game.Player;

/**
 * InventoryCheck.java
 * 
 * Class for checking the player's inventory
 * 
 * @author Joel Penney, Drew Smith, Marshall Kirk
 */
public class InventoryCheck implements Command {

	/**
	 * Print the contents of the inventory
	 * @param fullCommand Unused. The string representing the entire command
	 */
	public void execute(String fullCommand) {
		System.out.println("You look in your inventory.");
		Player.getInstance().inventory(); //accesses player's inventory and prints its contents to the screen
	}

}

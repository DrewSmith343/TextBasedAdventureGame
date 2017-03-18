package commands;

import game.Player;

/**
 * Stats.java
 * 
 * Class for displaying stats.
 * 
 * @author Joel Penney, Drew Smith, Marshall Kirk
 */
public class Stats implements Command {

	/**
	 * Print out the player's health and damage
	 * @param fullCommand Unused. The string representing the entire command
	 */
	public void execute(String fullCommand) {
		Player.getInstance().status();
	}

}

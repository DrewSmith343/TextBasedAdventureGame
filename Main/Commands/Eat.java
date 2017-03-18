package Commands;

import Game.Player;

/**
 * Eat.java
 * 
 * Class for eating items.
 * 
 * @author Joel Penney, Drew Smith, Marshall Kirk
 */
public class Eat implements Command {

	/**
	 * If a specific item is given, eat it (if it exists).
	 * Otherwise, eat a random item.
	 * @param fullCommand The string with the item to be eaten
	 */
	public void execute(String fullCommand) { 
		if (fullCommand.toLowerCase().trim().equals("eat")) { //if the player enters 'eat' on the command line
			Player.getInstance().eatRandom(); //eats an item in the players inventory
		} else {
			Player.getInstance().eat(fullCommand.substring(fullCommand.indexOf(' ') + 1)); 
		}

	}

}

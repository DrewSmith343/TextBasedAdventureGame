package Commands;

import Game.*;

/**
 * West.java
 * 
 * Class for attempted movement west
 * 
 * @author Joel Penney, Drew Smith, Marshall Kirk
 */

public class West implements Command {

	/**
	 * If possible, move west
	 * @param fullCommand Unused. The string representing the entire command
	 */
	public void execute(String fullCommand) {
		if (Game.getGame().getCurrentRoom().getEnemy() == null) {
			Room nextRoom = Game.getGame().getCurrentRoom().getWest();
			if (nextRoom == null)
				System.out.println("There are only cliffs in that direction.");
			else
				Game.getGame().setCurrentRoom(nextRoom);
		} else
			System.out.println("You can't run, you can only fight");
	}

}
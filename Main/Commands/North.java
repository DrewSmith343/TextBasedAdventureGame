package Commands;

import Game.*;

/**
 * North.java
 * 
 * Class for attempted movement north
 * 
 * @author Joel Penney, Drew Smith, Marshall Kirk
 */

public class North implements Command {

	/**
	 * If possible, move north
	 * @param fullCommand Unused. The string representing the entire command
	 */
	public void execute(String fullCommand) {
		if (Game.getGame().getCurrentRoom().getEnemy() == null) {
			Room nextRoom = Game.getGame().getCurrentRoom().getNorth();
			if (nextRoom == null)
				System.out.println("There are only cliffs in that direction.");
			else
				Game.getGame().setCurrentRoom(nextRoom);
		} else
			System.out.println("You can't run, you can only fight");
	}

}
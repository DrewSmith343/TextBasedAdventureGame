package Commands;

import Game.*;

/**
 * South.java
 * 
 * Class for attempted movement south
 * 
 * @author Joel Penney, Drew Smith, Marshall Kirk
 */

public class South implements Command {

	/**
	 * If possible, move south
	 * @param fullCommand Unused. The string representing the entire command
	 */
	public void execute(String fullCommand) {
		if (Game.getGame().getCurrentRoom().getEnemy() == null) {
			Room nextRoom = Game.getGame().getCurrentRoom().getSouth();
			if (nextRoom == null)
				nextRoom = Game.getGame().addRoom("south");
			Game.getGame().setCurrentRoom(nextRoom);
		} else
			System.out.println("You can't run, you can only fight");
	}

}
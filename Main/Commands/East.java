package Commands;

import Game.*;

/**
 * East.java
 * 
 * Class for attempted movement east
 * 
 * @author Joel Penney, Drew Smith, Marshall Kirk
 */

public class East implements Command {

	/**
	 * If possible, move east
	 * @param fullCommand Unused. The string representing the entire command
	 */
	public void execute(String fullCommand) {
		if (Game.getGame().getCurrentRoom().getEnemy() == null) {
			Room nextRoom = Game.getGame().getCurrentRoom().getEast();
			if (nextRoom == null){
				nextRoom =Game.getGame().addRoom("east");	
			}
			Game.getGame().setCurrentRoom(nextRoom);
		} else
			System.out.println("You can't run, you can only fight");
	}

}
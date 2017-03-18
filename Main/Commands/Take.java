package commands;

import game.*;
import item.Item;

/**
 * Take.java
 * 
 * Class for taking items from a room.
 * 
 * @author Joel Penney, Drew Smith, Marshall Kirk
 */
public class Take implements Command {

	/**
	 * Take an item, if it exists.
	 * @param fullCommand Unused. The string representing the entire command
	 */
	public void execute(String fullCommand) {

		if (Game.getGame().getCurrentRoom().hasItems()) {
			Item temp = Game.getGame().getCurrentRoom().transfer();
			Player.getInstance().addItem(temp);
			
			if (temp.isWep()){
				Player.getInstance().update();
			}else System.out.println("Some nourishiment, always helpful after a tough fight");
		}
		else if (Game.getGame().getCurrentRoom().hasTech()) {
			Item tech = Game.getGame().getCurrentRoom().getTech();
			Player.getInstance().addItem(tech);
			System.out.println("Ah, this will help on the next planet, maybe keep you from dying too quickly");
		}
		else
			System.out.println("No items here, can't pick up nothing");
	}

}
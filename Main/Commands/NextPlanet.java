package Commands;

import Game.Game;
import Game.Player;

/**
 * NextPlanet.java
 * 
 * Class for planet movement
 * 
 * @author Joel Penney, Drew Smith, Marshall Kirk
 */
public class NextPlanet implements Command {

	/**
	 * Advance to the next planet, if possible
	 * @param fullCommand Unused. The string representing the entire command
	 */
	public void execute(String fullCommand) {
		if (Game.getGame().atRocket()) { //if the player is at the rocket
			if (Player.getInstance().hasTech(Game.getGame().getCurrPlanet())) //if the player has the required technology
				Game.getGame().nextPlanet(); //player moves to the next planet
			else
				System.out.println("You need the proper tech to survive on the next planet");
		} else
			System.out.println("You can't leave the planet without your rocket");
	}

}

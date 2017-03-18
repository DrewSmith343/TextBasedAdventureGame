package Commands;

import Game.*;

/**
 * Attack.java
 * 
 * Class for combat.
 * 
 * @author Joel Penney, Drew Smith, Marshall Kirk
 */
public class Attack implements Command {

	/**
	 * Attack the enemy if there is one
	 * @param fullCommand Unused. The string representing the entire command
	 */
	public void execute(String fullCommand) {
		if (Game.getGame().getCurrentRoom().getEnemy() != null) {
			
			if (Game.getGame().getCurrentRoom().getEnemy().takeDamage(Player.getInstance().getDamage())) {
				Player.getInstance().takeDamage(Game.getGame().getCurrentRoom().getEnemy().getDamage());
			} else {
				System.out.println("Enemy has died");
				Game.getGame().getCurrentRoom().kill();
				System.out.println("You have : " + Player.getInstance().getHealth() + " of health remaining");
			}

		} else {
			System.out.println("There are no enemies in room");

		}

	}

}

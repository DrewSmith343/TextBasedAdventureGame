package commands;

/**
 * Help.java
 * 
 * Class for displaying the help guide.
 * 
 * @author Joel Penney, Drew Smith, Marshall Kirk
 */
public class Help implements Command {

	/**
	 * Display the help guide
	 * @param fullCommand Unused. The string representing the entire command
	 */
	public void execute(String fullCommand) {
		System.out.println("=======  Help Guide/Command List!!!  =======");
		System.out.println("help: prints the help guide. But you probably figured that out.");
		System.out.println("quit: exit the game");
		System.out.println("stats: show health and damage");
		System.out.println("eat *: eat the item given; if none is given eat a random item");
		System.out.println("take: if these items are in the room, takes the food then the weapon");
		System.out.println("inventory: look at the items in your inventory");
		System.out.println("next: try to advance to the next planet (you'll need a rocket and proper tech)");
		System.out.println("attack: attacks an enemy in the same room");
	}
}
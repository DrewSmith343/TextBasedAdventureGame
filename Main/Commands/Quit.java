package Commands;

/**
 * Quit.java
 * 
 * Class quitting the game.
 * 
 * @author Joel Penney, Drew Smith, Marshall Kirk
 */
public class Quit implements Command {

	/**
	 * End the program.
	 * @param fullCommand Unused. The string representing the entire command
	 */
	public void execute(String fullCommand) {
		System.out.println("Quitting.");
		System.exit(0);
	}
}
package Commands;

/**
 * Command.java
 * Interface for invoking commands
 * 
 * @author Joel Penney, Drew Smith, Marshall Kirk
 */
public interface Command {

	/**
	 * Execute the command
	 * @param fullCommand The string representing the entire command
	 */
	public void execute(String fullCommand);
}
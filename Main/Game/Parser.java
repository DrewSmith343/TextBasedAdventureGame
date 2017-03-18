package Game;

/**
 * Parser.java
 * 
 * Class to interpret the user's commands
 *
 * @author Thomas VanDrunen, Joel Penney, Drew Smith, Marshall Kirk
 * Wheaton College, CS 245, Spring 2007
 * Lab 5
 * Feb 8, 2007
 */

import java.util.Scanner;

import java.util.HashMap;
import Commands.*;

public class Parser {

	/**
	 * For user input from the keyboard.
	 */
	private Scanner keyboard;

	/**
	 * All the possible commands
	 */
	private HashMap<String, Command> commandList;

	/**
	 * Constructor; gets all the commands ready
	 */
	public Parser() {
		keyboard = new Scanner(System.in);

		// List of all commands for invocation
		commandList = new HashMap<>();
		commandList.put("quit", new Quit());
		commandList.put("help", new Help());
		commandList.put("inventory", new InventoryCheck());
		commandList.put("eat", new Eat());
		commandList.put("stats", new Stats());
		commandList.put("take", new Take());
		commandList.put("next", new NextPlanet());
		commandList.put("attack", new Attack());
		commandList.put("north", new North());
		commandList.put("south", new South());
		commandList.put("east", new East());
		commandList.put("west", new West());
	}

	/**
	 * Let the user make one "turn" at this game. Give the user a description of
	 * the room, prompt for a command, and interpret the command.
	 * 
	 * @param game A reference to the object representing the game.
	 */
	public void executeTurn(Game game) {
		// The room that the user is in.
		Room room = game.getCurrentRoom();

		System.out.println("You are in " + room.getDescription());

		if (Game.getGame().atRocket())
			System.out.println("This is where your rocket is.");

		System.out.print("Enter command--> ");
		String command = keyboard.nextLine().toLowerCase(); // user's command

		// gets first word, which defines which command was made
		String commandCall = command;
		if (command.indexOf(' ') != -1) // if extra words need to be accounted for
			commandCall = command.substring(0, command.indexOf(' '));
		Command called = commandList.get(commandCall);

		if (called != null)
			called.execute(command);
		else
			System.out.println("I do not know how to " + command + ".");
	}

}
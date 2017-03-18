package Game;

import Planets.*;
import java.util.HashMap;

/**
 * Game.java
 * 
 * Class to model the game as a collection of rooms. The rooms are organized as
 * a graph, and the Room objects are nodes in the graph.
 *
 * @author Thomas VanDrunen Wheaton College, CS 245, Spring 2007 Lab 5 Feb 8, 2007
 * @author Drew Smith, Marshall Kirk, Joel Penney
 */

public class Game {

	/**
	 * Holds the instance of the game
	 */
	private static Game instanceGame;

	/**
	 * The current room the user is in. This serves to purposes-- it is our only
	 * permanent connection to the rooms in this game (the other rooms are
	 * reachable by traversing this room's "doors"-- and it maintains the state
	 * by representing the user's current location.
	 */
	private Room currentRoom; 

	/**
	 * Keeps track of whether this game is over or not.
	 */
	private boolean over; 

	/**
	 * variable for the planet the player is currently on
	 */
	private Planet currentPlanet;

	/**
	 * variable for the current planet's number
	 */
	private int planetNum;
	
	/**
	 * array to hold planets
	 */
	private Planet[] planets;
	
	/**
	 * multidimensional array for the rooms on each planet
	 */
	private HashMap<Tuple,Room> rooms;

	/**
	 * Return the room in which the user is currently.
	 */
	public Room getCurrentRoom() { 
		return currentRoom;
	}

	/**
	 * Constructor to set up the game.
	 */
	private Game() { 
		over = false;

		// the planets to be traveled to
		// the order can be changed
		planets = new Planet[5];
		planets[0] = new StartPlnt();
		planets[1] = new LowOxyPlnt();
		planets[2] = new HighTempPlnt();
		planets[3] = new NoLightPlnt();
		planets[4] = new PostImpctEarth();

		planetNum = -1; // so we can call nextPlanet and start at 0
		nextPlanet();
	}

	/**
	 * Static constructor, creates the only instance of Game.
	 */
	static {
		instanceGame = new Game();
	}

	/**
	 * Is this game over or not?
	 */
	public boolean isOver() {
		return over;
	}

	/**
	 * Move into a different current room.
	 */
	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}

	/**
	 * Advance to the next planet. Ends the game if the after the last planet
	 */
	public void nextPlanet() {
		if (planetNum >= 4) {
			finishGame();
			return;
		}
		if (planetNum != -1)
			System.out.println("You managed to leave the planet");
		currentPlanet = planets[++planetNum];
		rooms = currentPlanet.getRoom();
		currentRoom = rooms.get(new Tuple(2,2));
		System.out.println(currentPlanet.getDescription());
	}

	/**
	 * Indicate that the game is now over.
	 */
	public void finishGame() {
		over = true;
	}

	/**
	 * Method to get current planet
	 * @return current planet's number
	 */
	public int getCurrPlanet() {
		return planetNum;
	}

	/**
	 * Method to get game instance
	 * @return instance of game
	 */
	public static Game getGame() {
		return instanceGame;
	}
	
	/**
	 * Method to check whether player is at rocket
	 * @return true if player is in room with rocket, false otherwise
	 */
	public boolean atRocket() {
		if (currentRoom == rooms.get(new Tuple(2,2)))
			return true;
		return false;
	}
	
	public Room addRoom(String direction){
		int x = currentRoom.getX();
		int y = currentRoom.getY();
		Room temp = null;
		
		if (direction.equalsIgnoreCase("East"))
			x++;
		if (direction.equalsIgnoreCase("West"))
			x--;
		if (direction.equalsIgnoreCase("North"))
			y++;
		if (direction.equalsIgnoreCase("South"))
			y--;	
		rooms.put(new Tuple(x, y), temp = new Room(planetNum+1, x, y));
		temp.setEast(rooms.get(new Tuple(x+1,y)));
		temp.setNorth(rooms.get(new Tuple(x,y+1)));
		temp.setSouth(rooms.get(new Tuple(x,y-1)));
		temp.setWest(rooms.get(new Tuple(x-1,y)));
		return temp; 
	}

}
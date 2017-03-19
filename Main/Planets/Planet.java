package Planets;

import Game.Room;
import Items.Item;

import java.util.HashMap;


public abstract class Planet {

	protected String description, status;    //variables for descriptions and status of planet
	protected HashMap<Tuple, Room> landscape;
	private int x, y; 
          //array for multiple landscapes on each planet

	protected Planet(int level) {
		landscape = new HashMap <Tuple, Room>(); 
		
		for (int x = 0; x < 5; x++) { 
			for (int y = 0; y < 5; y++) {
				landscape.put(new Tuple(x,y) , new Room(level, x, y)); 
			}
		}
		
		for (int x = 0; x < 5; x++) {
			for (int y = 0; y < 5; y++) {
				if (x != 0) { //if there is nothing north of the room
					landscape.get(new Tuple(x,y)).setNorth(landscape.get(new Tuple(x,y+1))); //sets north room
				}
				if (y != 0) { //if there is nothing east of the room
					landscape.get(new Tuple(x,y)).setEast(landscape.get(new Tuple(x+1,y))); //sets east room
				}
				if (x < 4) { //if there is nothing south of the room
					landscape.get(new Tuple(x,y)).setSouth(landscape.get(new Tuple(x,y-1))); //sets south room
				}
				if (y < 4) { //if there is nothing west of the room
					landscape.get(new Tuple(x,y)).setWest(landscape.get(new Tuple(x-1,y))); //sets west room
				}

			}
		}
	}

	/**
	 * Method outlining the each planets state method.
	 */
	public abstract String getModifier();

	/**
	 * Method outlining each planet's description method.
	 */
	public abstract String getDescription();
	

	/**
	 * Gets room.
	 * @return
	 */
	public HashMap<Tuple,Room> getRoom() {
		return landscape;
	}

}
package map;

import game.Room; 

public abstract class Planet {

	protected String description, status;    //variables for descriptions and status of planet
	protected Room[][] landscape;            //array for multiple landscapes on each planet

	protected Planet(int level) {
		landscape = new Room[5][5];  //sets landscape
		for (int i = 0; i < 5; i++) {  
			for (int j = 0; j < 5; j++) {
				landscape[i][j] = new Room(level); //generates a room at this location of array
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (i != 0) { //if there is nothing north of the room
					landscape[i][j].setNorth(landscape[i - 1][j]); //sets north room
				}
				if (j != 0) { //if there is nothing east of the room
					landscape[i][j].setEast(landscape[i][j - 1]); //sets east room
				}
				if (i < 4) { //if there is nothing south of the room
					landscape[i][j].setSouth(landscape[i + 1][j]); //sets south room
				}
				if (j < 4) { //if there is nothing west of the room
					landscape[i][j].setWest(landscape[i][j + 1]); //sets west room
				}

			}
		}
		// to make sure the tech isn't too close to the rocket
		// each digit is one index of the room array
		int[] randList = { 00, 01, 03, 04, 10, 14, 30, 34, 40, 41, 43, 44 };
		int location = (int) (Math.random() * 12);
		landscape[randList[location] / 10][randList[location] % 10].addTech(); //sets location of tech
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
	public Room[][] getRoom() {
		return landscape;
	}

}
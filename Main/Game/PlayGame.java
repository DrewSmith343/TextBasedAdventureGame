package Game;

/**
 * PlayGame.java
 * 
 * Program to control the playing of this game.
 *
 * @author Thomas VanDrunen Wheaton College, CS 245, Spring 2007 Lab 5 Feb 8, 2007
 */

public class PlayGame {

	public static void main(String[] args) {
		System.out.println("Welcome, archeology major.\n" + 
		"Your goal is to get a legendary artifact from the planet Eart.\n" +
		"Go from each planet to the next, getting what you need to survive.\n" +
		"Enter help for help guide/list of commands.");

		Game game = Game.getGame(); // reference to the game object
		Parser parser = new Parser();
		
        while (!game.isOver())
            parser.executeTurn(game);
        
        if (!Player.getInstance().isAlive())
            System.out.println("Game over.");
        else {
            System.out.println("You escaped the planet alive, carrying the legendary artifact.");
            System.out.println("Congradulations, you win!!!");
        }
    }
}
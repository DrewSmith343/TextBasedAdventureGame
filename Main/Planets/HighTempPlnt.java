package Planets;



public class HighTempPlnt extends Planet {
	public String description, status; //variables for planet description and status

	public HighTempPlnt() {
		super(3); //passes difficulty of planet
		status = "Severely high temperature";
		description = "You arrive on a barren desert planet. Its close proximity to the local sun has given it an oven-like temperature. To survive, the wildlife has adapted a much higher body temperature than ususal.";
	}

	/**
	 * Method for getting status of planet
	 */
	public String getModifier() {
		return status;  //returns state of planet
	}

	/**
	 * Method for getting description of planet
	 */
	public String getDescription() {
		return description;  //returns description of planet
	}

}

package Planets;

public class StartPlnt extends Planet {

	private String description, status; //variables for planet description and status

	public StartPlnt() {
		super(1); //passes difficulty level of planet
		status = "None";
		description = "You arrive on a normal planet, perliminary readings show only basic lifeforms can survive.";
	}

	/**
	 * Method for getting status of planet
	 */
	public String getModifier() { //returns state of planet
		return status;
	}

	/**
	 * Method for getting description of planet
	 */
	public String getDescription() { //returns description of planet
		return description;
	}

}
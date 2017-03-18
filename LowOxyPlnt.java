package map;



public class LowOxyPlnt extends Planet {
	private String description, status; //variables for planet description and status

	public LowOxyPlnt() {
		super(2); //passes difficulty level of planet
		status = "Low Oxygen Levels"; //status of planet
		description = "You arrive on a planet whose atmosphere has a far lower oxygen concentration than normal. The wildlife has adapted to only require a minimal oxygen intake to survive. "; //description of planet
	}

	/**
	 * Method for getting status of planet
	 */
	public String getModifier() {
		return status;  //returns status of planet
	}
	
	/**
	 * Method for getting description of planet
	 */
	public String getDescription() {
		return description;  //returns description of planet
	}
}
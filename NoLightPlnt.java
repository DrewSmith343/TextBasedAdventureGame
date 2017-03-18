package map;

public class NoLightPlnt extends Planet {
	private String description, status; //variables for planet description and status

	public NoLightPlnt() {
		super(4); //passes planet's difficulty level
		status = "No Light";
		description = "You arrive on a planet which shares an orbit around the sun with a far larger planet. This puts it in a continual state of eclipse, where no light reaches it. The local wildlife has adapted in various ways, such as using ecolocation and infrared vision.";
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

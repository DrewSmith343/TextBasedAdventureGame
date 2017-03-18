package map;

public class PostImpctEarth extends Planet {
	public String status, description; //variables for planet description and status

	public PostImpctEarth() {
		super(5); //passes difficulty level of planet

	}

	public void stateEffect() {
		status = "Highly Irradiated";
		description = "You arrive on a planet which was once home to a thriving civilization. But now, only the ruins of their strange box-shaped buildings remain. Due to some apocalyptic event, this planet contains lethal levels of cosmic radiation. ";
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

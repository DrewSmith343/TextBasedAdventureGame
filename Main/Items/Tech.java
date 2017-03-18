package Items;

public class Tech extends Item{

	private static String[] random = { "Oxygen Extraction Device", "Heat-Resistant Suit", "Helmet Light",
			"Radiation-Resistant Suit", "YE FLASK OF LEGEND" };

	/**
	 * Constructor for tech.
	 * @param input
	 */
	public Tech(int input) {
		super(random[input]);
	}

	/**
	 * Method for checking whether item is tech.
	 */
	@Override
	public boolean isTech() {
		return true;
	}

	/**
	 * Method for getting type of item tech is.
	 */
	public String getType() {
		return "Neccesary Survival Gear";
	}

}

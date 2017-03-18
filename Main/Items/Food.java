package Items;

public class Food extends Item{

	/**
	 * The health this item returns
	 */
	private int heal = 5;
	
	/**
	 * an array of food items that can spawn
	 */
	private static String[] random = { "Pizza", "Mushroom", "Apple", "Pasta", "Wasabi", "Burrito", "Alien Apple",
			"Alien Thing", "Bottle Water", "Unknown", "Mysterious Gloop", "Bannana", "Fish", "Radioactive Fish",
			"Alien Fish", "Meat", "Suspicous Meat", "Mystery meat", "Weirdly round meat", "Itallian quisine",
			"Tenderloin Steak", "Soda", "Pop", "MTN DO IT", "Liver", "Sweet Bread", "A bag of Gummy bears",
			"Bagged water", "Bagged milk", "An energy Drink", "Pepsi Cola", "Rations", "Rotten Rations", "Fine liver",
			"Orange", "Blue (a blue orange)", "Canadian bacon", "Ham", "Sliced ham", "Alien water", "Warm milk",
			"Soggy bread", "Slimy bread", "Dry Chicken", "Health thing", "Pure energy", "Pain killers",
			"Non Alcholic beverages", "Tea", "DR Pepper" };
	/**
	 * A constructor for Food
	 * @param input
	 * @param HP
	 */
	public Food(String input, int HP) {
		super(input); //passes input for food
		heal = HP; 
	}

	/**
	 * Method for setting amount of health food heals
	 */
	public Food() {
		super(random[(int) (Math.random() * 50)].toLowerCase()); 
		heal = ((int) (Math.random() * 10))+1; //sets amount food heals to random value
	}

	

	@Override
	/**
	 * Checks whether item is food
	 */
	public boolean isFood() {
		return true;
	}

	/**
	 * Method for healing player
	 */
	@Override
	public int heal() {
		return heal;
	}

	/**
	 * Gets type of item food is
	 */
	@Override
	public String getType() {
		return "Nourishment";
	}

}

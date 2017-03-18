package item;

public abstract class Item {

	protected String thing;

	public Item(String input) {
		thing = input;
	}

	/**
	 * Method for getting an item.
	 */
	public String getItem() {
		return thing;
	}

	/**
	 * Checks whether item is a weapon.
	 */
	public boolean isWep() {
		return false;
	}

	/**
	 * Checks whether item is tech.
	 */
	public boolean isTech() {
		return false;
	}

	/**
	 * Checks whether item is food.
	 */
	public boolean isFood() {
		return false;
	}

	/**
	 * Method for getting damage of item.
	 */
	public int damage() {
		return 0;
	}
	
	/**
	 * Method for getting healing value of item.
	 */
	public int heal() {
		return 0;
	}

	/**
	 * Method for getting type of item.
	 */
	public abstract String getType();
}

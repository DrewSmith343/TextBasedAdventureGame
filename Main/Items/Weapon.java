package item;

public class Weapon extends Item{

	private int damage = 5;
	private static String[] random = { "Sword", "Axe", "Pistol", "Knife", "Knife", "Brass knuckles",
			"2x4 with a lotta nails", "Boxing Gloves", "Sledgehammer", "Taser", "Spear", "Shotgun", "Assualt Rile",
			"Pepper Spray", "Bladded Shoes", "Explosive Crossbow", "Morning Star", "Maul", "Super Strength",
			"Heavy Machine Gun", "Light Machine Gun", "50 Caliber Sniper Rifle", "Handgernades", "A really big gun",
			"Flamethrower", "Lightsaber" };
	/**
	 * Constructor for Weapon.
	 * @param input
	 * @param dam
	 */
	public Weapon(String input, int dam) {
		super(input);
		damage = dam;
	}

	/**
	 * Method for setting amount of damage weapon does.
	 * @param level
	 */
	public Weapon(int level) {
		super(random[(int) (Math.random() * (level * 5))].toLowerCase());
		damage = (int) (Math.random() * (10 * level));
	}

	/**
	 * Constructor for Weapon.
	 * @param input
	 */
	public Weapon(String input) {
		super(input);
	}

	/**
	 * Method for checking whether item is weapon.
	 */
	@Override
	public boolean isWep() {
		return true;
	}

	/**
	 * Method for returning the amount of damage a weapon does.
	 */
	@Override
	public int damage() {
		return damage;
	}

	/**
	 * Method for getting the type of item a weapon is.
	 */
	@Override
	public String getType() {
		return "weapon";
	}

}

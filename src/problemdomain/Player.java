package problemdomain;

public class Player {
	private String name;
	private int age;
	private StartingWeapon startingWeapon;
	private int level = 15;
	private int lifePoints = 100;
	private int meleeStrength = 0;
	private int magicStrength = 0;
	private int rangedStrength = 0;
	private int meleeDefence = 10;
	private int magicDefence = 10;
	private int rangedDefence = 10;

	public Player(String name, int age, StartingWeapon startingWeapon) {
		setName(name);
		setAge(age);
		setWeapon(startingWeapon);
	}

	public Player() {

	}

	public int getLevel() { return level; }
	public int getLifePoints() { return lifePoints; }
	public int getMeleeStrength() { return startingWeapon.getMeleeStrength(); }
	public int getMagicStrength() { return startingWeapon.getMagicStrength(); }
	public int getRangedStrength() { return startingWeapon.getRangedStrength(); }
	public int getMeleeDefence()  { return meleeDefence; }
	public int getMagicDefence()  { return magicDefence; }
	public int getRangedDefence() { return rangedDefence; }

	public void takeDamage(int damage) {
		lifePoints -= damage;

		if (lifePoints < 0) {
			lifePoints = 0;
		}
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		if (name == null || !name.matches("[A-Za-z ]+")) {
			throw new IllegalArgumentException();
		}
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		if (age < 13) {
			throw new IllegalArgumentException();
		}
		this.age = age;
	}

	public StartingWeapon getWeapon() {
		return startingWeapon;
	}

	public void setWeapon(StartingWeapon startingWeapon) {
		if (startingWeapon == null) {
			throw new IllegalArgumentException();
		}
		this.startingWeapon = startingWeapon;
	}

	@Override
	public String toString() {
		return "Character Level: " + getLevel() +
				"\nLifepoints: " + getLifePoints() +
				"\nMelee Strength: " + getMeleeStrength() +
				"\nMagic Strength: " + getMagicStrength() +
				"\nRanged Strength: " + getRangedStrength() +
				"\nMelee Defence: " + getMeleeDefence() +
				"\nMagic Defence: " + getMagicDefence() +
				"\nRanged Defence: " + getRangedDefence();
	}

}

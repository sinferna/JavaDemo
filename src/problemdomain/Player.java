package problemdomain;

public class Player {
	private String name;
	private int age;
	private Weapon weapon;
	private int lifePoints;
	private int attackLevel;

	public Player(String name, int age, Weapon weapon) {
		setName(name);
		setAge(age);
		setWeapon(weapon);
	}

	public Player() {

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

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		if (weapon == null) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public String toString() {
		return name + ", " + age;
	}

}

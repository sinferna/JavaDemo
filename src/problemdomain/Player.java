package problemdomain;

public class Player {
	private String name;
	private int age;

	public Player(String name, int age) {
		super();
		setName(name);
		setAge(age);
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
			throw new IllegalArgumentException("Name must only contain letters (A-Z)");
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
	
	@Override
	public String toString() {
		return name + ", " + age;
	}

}

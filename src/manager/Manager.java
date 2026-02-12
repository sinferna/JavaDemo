package manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import problemdomain.Player;
import problemdomain.Weapon;

public class Manager {
	private String name;
	private int age;
	private Weapon.Type type;
	private Scanner input;
	private ArrayList<Player> players;
	
	public Manager() {
		initializeCharacter();
		monsterEncounter();
	}
	
	private void initializeCharacter() {
		try {
			players = new ArrayList<Player>();
			input = new Scanner(System.in);
			Player player = new Player();

			boolean running = true;

			while (running) {
				boolean gettingName = true;

				while (gettingName) {
					System.out.print("Greetings adventurer, what is your name? ");
					name = input.nextLine().trim();
					try {
						player.setName(name);
						gettingName = false;
					} catch (IllegalArgumentException e) {
						System.out.println("Invalid input. Please use letters (A-Z)");
					}
//					String line = input.nextLine().trim();
//					if (line.matches("[A-Za-z]+")) {
//						name = line;
//						gettingName = false;
//					} else {
//						System.out.println("Invalid input. Please use letters (A-Z).");
//					}
				}

				boolean gettingAge = true;

				while (gettingAge) {
					System.out.print("Nice to meet you, " + name + ", how old are you? ");
					// input.hasNextInt() evaluates to true
					if (input.hasNextInt()) {
						age = input.nextInt();
						input.nextLine();
						try {
							player.setAge(age);
							gettingAge = false;
							System.out.println("\nWelcome to Zyrith!\n");
							initializeGear();
						} catch (IllegalArgumentException e) {
							System.out.println("\nPlayer must be at least 13 years old.\n");
							break;
						}
					} else {
						System.out.println("Invalid input. Please use numbers (1-9).");
					}
				}

				// display added user in array
//				Player player = new Player(name, age);
//				Player player2 = new Player("123", 8);
//				players.add(player);
//				players.add(player2);
//				System.out.println(player);
//				players.add(new Player(name, age));
//				for (Player p : players) {
//					System.out.println(p);
//				}

				running = false;
			}
		}
		catch (NullPointerException e) {
			System.out.println("Invalid entry.");
		}
	}

	public void initializeGear() {
		boolean gettingWeapon = true;
		Weapon weapon = new Weapon();

		while (gettingWeapon) {
			System.out.print("Choose a weapon (Sword, Staff or Bow): ");

			try {
				String weaponInput = input.nextLine().trim().toUpperCase();
				type = Weapon.Type.valueOf(weaponInput);
				weapon.setType(type);

				if (type == Weapon.Type.SWORD) {
					System.out.println("\nYou hold the sword and gain +10 attack strength.");
				} else if (type == Weapon.Type.STAFF) {
					System.out.println("\nYou hold the staff and gain +10 magic strength.");
				} else if (type == Weapon.Type.BOW) {
					System.out.println("\nYou hold the bow and gain +10 ranged strength.");
				}
				gettingWeapon = false;
			} catch (IllegalArgumentException e) {
				System.out.println("Invalid weapon type selected.");
			}
		}
	}

	public void monsterEncounter() {
		System.out.println("An Evil Imp appears...");
		System.out.println("1 - Attack it! I can take it on.");
		System.out.println("2 - Run away. I don't need this right now.");
		System.out.println("Choose an option: ");

		int encounterChoice = input.nextInt();

		if (encounterChoice == 1) {
			System.out.println("Ok");
		}
	}

}


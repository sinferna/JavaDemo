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
						try {
							player.setAge(age);
							gettingAge = false;
							System.out.println("\nWelcome to Zyrith!");
						} catch (IllegalArgumentException e) {
							System.out.println("\nPlayer must be at least 13 years old.\n");
							break;
						}
					} else {
						System.out.println("Invalid input. Please use numbers (1-9).");
						input.nextLine();
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
				boolean gettingWeapon = true;
				Weapon weapon = new Weapon();

				while (gettingWeapon) {
					System.out.println("Choose your weapon: ");
					System.out.println("Sword");
					System.out.println("Staff");
					System.out.println("Bow");

					String weaponInput = input.nextLine().trim().toUpperCase();

					try {
						type = Weapon.Type.valueOf(weaponInput);
						weapon.setType(type);
						gettingWeapon = false;
					} catch (IllegalArgumentException e) {
						System.out.println("Invalid weapon type selected.");
					}
				}
				running = false;
			}

		}
		
		catch (NullPointerException e) {
			System.out.println("Invalid entry.");
		}
	}

}

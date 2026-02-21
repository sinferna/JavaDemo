package manager;

import java.util.ArrayList;
import java.util.Scanner;

import problemdomain.Player;
import problemdomain.Weapon;

public class StartGame {
	private String name;
	private int age;
	private Weapon.Type type;
	private Scanner input;
	private ArrayList<Player> players;
	
	public StartGame() {
		initializeCharacter();
	}
	
	private void initializeCharacter() {
		try {
			players = new ArrayList<Player>();
			input = new Scanner(System.in);
			Player player = new Player();

			boolean gettingName = true;

			while (gettingName) {
				System.out.print("Greetings adventurer, what is your name? ");
				name = input.nextLine().trim();
				try {
					player.setName(name);
					gettingName = false;
				} catch (IllegalArgumentException e) {
					System.out.println(">> Invalid input. Please use letters (A-Z)");
				}
			}

			boolean gettingAge = true;

			while (gettingAge) {
				System.out.print("Nice to meet you, " + name + ", how old are you? ");
				String userInput = input.nextLine().trim();
				// input.hasNextInt() evaluates to true
				try {
					age = Integer.parseInt(userInput);
					player.setAge(age);
					gettingAge = false;
					System.out.println("\nWELCOME TO ZYRIFT! ( ◠‿◠ )\n");
					initializeGear();
				} catch (NumberFormatException e) {
					System.out.println(">> Invalid input. Please use numbers (1-9).");
				} catch (IllegalArgumentException e) {
					System.out.println("Player must be at least 13 years old.");
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
		}
		catch (NullPointerException e) {
			System.out.println(">> Invalid entry.");
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
					System.out.println("You hold the sword and gain +10 attack strength.\n\nYou are now level 15.");
				} else if (type == Weapon.Type.STAFF) {
					System.out.println("You hold the staff and gain +10 magic strength.\n\nYou are now level 15.");
				} else if (type == Weapon.Type.BOW) {
					System.out.println("You hold the bow and gain +10 ranged strength.\n\nYou are now level 15.");
				}
				gettingWeapon = false;
				firstMonsterEncounter();
			} catch (IllegalArgumentException e) {
				System.out.println(">> Invalid weapon type selected.");
			}
		}
	}

	public void firstMonsterEncounter() {
		boolean firstMonsterEncountered = true;

		while (firstMonsterEncountered) {
			System.out.println("\nAn Evil Imp (level 10) appears...");
			System.out.println("1 - Attack it! I can take it on.");
			System.out.println("2 - Run away. I don't need this right now.");
			System.out.print("Choose an option: ");
			String userInput = input.nextLine();

			try {
				int encounterChoice = Integer.parseInt(userInput);

				if (encounterChoice == 1) {
					// TODO: input fight logic here
					System.out.println(".");
					firstMonsterEncountered = false;
				} else if (encounterChoice == 2) {
					System.out.println("You manage to get away... for now...");
					firstMonsterEncountered = false;
				} else {
					System.out.println(">> Invalid input. Please choose 1 or 2.");
				}
			} catch (NumberFormatException e) {
				System.out.println(">> Invalid input. Please use numbers (1-2).");
			}
		}
	}

}


package manager;

import java.util.ArrayList;
import java.util.Scanner;

import problemdomain.AttackRoll;
import problemdomain.EvilImp;
import problemdomain.Player;
import problemdomain.StartingWeapon;

public class StartGame {
	private String name;
	private int age;
	private StartingWeapon.Type type;
	private Scanner input;
	private ArrayList<Player> players;
	Player player = new Player();
	
	public StartGame() {
		initializeCharacter();
	}
	
	private void initializeCharacter() {
		try {
			players = new ArrayList<Player>();
			input = new Scanner(System.in);

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
					System.out.println("\nWELCOME TO ZYRIFT! ( ◠‿◠ )");
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
		StartingWeapon startingWeapon = new StartingWeapon();

		while (gettingWeapon) {
			System.out.print("Choose a weapon (Sword, Staff or Bow): ");

			try {
				String weaponInput = input.nextLine().trim().toUpperCase();
				StartingWeapon.Type selectedType = StartingWeapon.Type.valueOf(weaponInput);
				startingWeapon.setType(selectedType);
				player.setWeapon(startingWeapon);

				System.out.println("\nYou equip the " + selectedType + "!");
				System.out.println(player);
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
			System.out.println("1: Attack it! I can take it on.");
			System.out.println("2: Run away. I'm scared!");
			System.out.print("Choose an option: ");
			String userInput = input.nextLine();

			try {
				int encounterChoice = Integer.parseInt(userInput);

				if (encounterChoice == 1) {
					AttackRoll battle = new AttackRoll();
					EvilImp imp = new EvilImp();

					System.out.println("THE FIGHT BEGINS!");

					while (imp.getLifePoints() > 0 && player.getLifePoints() > 0) {
						battle.conductBattle(player, imp);

						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println("\nYou are victorious! The Evil Imp turns into dust." +
							"\nIt drops 100 coins. You pick them up." +
							"\n\nYou make your way to Kossor, the capital of Zyrift...");
					firstMonsterEncountered = false;
				} else if (encounterChoice == 2) {
					System.out.println("You manage to get away... for now...\n" +
							"You make your way to Kossor, the capital of Zyrift.");
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


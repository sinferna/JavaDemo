package manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import problemdomain.Player;

public class Manager {
	private String name;
	private int age;
	private Scanner input;
	private ArrayList<Player> players;
	
	public Manager() {
		printName();
	}
	
	private void printName() {
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

				running = false;

				boolean gettingWeapon = true;

				while (gettingWeapon) {

				}
			}
		}
		
		catch (NullPointerException e) {
			System.out.println("Invalid entry.");
		}
	}
}

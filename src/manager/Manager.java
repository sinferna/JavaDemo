package manager;

import java.util.ArrayList;
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
			boolean running = true;
			
			while (running) {
				System.out.print("Greetings adventurer, what is your name? ");
				input = new Scanner(System.in);
				name = input.next();
				
				System.out.print("Nice to meet you, " + name + ", how old are you? ");
				age = input.nextInt();
				
				if (age < 13) {
					System.out.println("You must be at least 13 years old to play.");
				}
				else if (age >= 13) {
					System.out.println("Welcome to Zyrith!");
				}
				
				players.add(new Player(name, age));
				System.out.println();
				
				running = false;
			}
		}
		
		catch (NullPointerException e) {
			System.out.println("Invalid entry.");
		}
	}
}

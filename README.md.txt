# Zyrift – Text-Based RPG (Java)

## Overview
**Zyrift** is a console-based, text-driven RPG built in **Java**.  
It was created as a learning project to strengthen my understanding of:

- Object-Oriented Programming (OOP)  
- Interfaces & abstraction  
- Exception handling  
- Combat logic design  
- Scalable architecture  
- Clean code practices  

The game currently allows a player to:

- Create a character (with name and age validation)  
- Choose a starting weapon (Sword, Staff, or Bow)  
- Encounter and battle an enemy (**Evil Imp**)  
- Experience turn-based combat with stat-based damage calculations  
- Receive loot upon victory  

---

## Project Goals

As a beginner-to-intermediate developer, this project was built with three main goals:

### 1. Strengthen Core OOP Principles
The project demonstrates:

- **Encapsulation** (private fields with getters/setters)  
- **Interfaces** (`Enemy`)  
- **Polymorphism-ready design**  
- Clear separation of concerns across packages  

The "Enemy" interface allows future enemies (e.g., Goblins, Dragons, Bosses) to be added without modifying combat logic, improving scalability.

### 2. Practice Exception Handling
Input validation was implemented using:

- `IllegalArgumentException`  
- `NumberFormatException`  
- Defensive programming patterns  

Examples include:
- Name validation (letters only)  
- Minimum age requirement  
- Weapon selection validation  
- Numeric input handling  

This ensures:
- The program does not crash from invalid input  
- The game remains stable and user-friendly  

### 3. Build a Scalable Combat System
The combat system is **stat-based** and designed to be expandable.  
Each combat round uses the following formula:
Damage = (20 × strength × random(0.05–0.10)) − (5 × defence × random(0.05–0.10))

## Security & Defensive Programming Considerations
Even as a console-based application, the project implements:

- Strict input validation  
- Try/catch blocks for user input  
- Prevention of negative health values  
- Null checking where appropriate  

These practices reflect **production-level defensive thinking** and reduce runtime instability.

## Future Improvements
Planned enhancements include:

- XP and leveling system  
- Multiple enemy types  
- Inventory system  
- Potion usage mechanics  
- Critical hit system  
- Player death handling  
- Save/load functionality  
- Refactoring into a shared `Character` base class  

Long-term, this project could evolve into:

- A GUI-based RPG  
- A REST-based multiplayer system  
- A small game engine framework  

---

## What I Learned
Through this project I improved:

- Writing cleaner switch-based logic  
- Designing interface-driven systems  
- Structuring multi-package Java projects  
- Handling user input safely  
- Thinking about scalability early  
- Debugging compile-time type issues  

Most importantly, this project reflects my growth from writing small procedural scripts to designing **structured, extensible systems**.

---

## How to Run
1. Clone the repository  
2. Open in **IntelliJ** or **Eclipse**  
3. Run:

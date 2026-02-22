package problemdomain;

public class AttackRoll {

    public void conductBattle(Player player, Enemy enemy) {
        // get random multiplier between 0.05 and 0.1
        double playerRoll = 0.05 + (Math.random() * 0.05);
        double enemyRoll = 0.05 + (Math.random() * 0.05);

        // determine stats based on equipped weapon type
        StartingWeapon weapon = player.getWeapon();

        int playerStrength = 0;
        int playerDefence = 0;

        int enemyStrength = 0;
        int enemyDefence = 0;

        switch (weapon.getType()) {
            case SWORD:
                playerStrength = weapon.getMeleeStrength();
                playerDefence = player.getMeleeDefence();

                enemyStrength = enemy.getMeleeStrength();
                enemyDefence = enemy.getMeleeDefence();
                break;

            case STAFF:
                playerStrength = weapon.getMagicStrength();
                playerDefence = player.getMagicDefence();

                enemyStrength = enemy.getMagicStrength();
                enemyDefence = enemy.getMagicDefence();
                break;

            case BOW:
                playerStrength = weapon.getRangedStrength();
                playerDefence = player.getRangedDefence();

                enemyStrength = enemy.getRangedStrength();
                enemyDefence = enemy.getRangedDefence();
                break;
        }
        // Player damage calculation
        int playerDamage = (int) ((20 * (playerStrength * playerRoll))
                - (5 * (enemyDefence * enemyRoll)));

        if (playerDamage < 0) playerDamage = 0;

        // Enemy damage calculation
        int enemyDamage = (int) ((20 * (enemyStrength * enemyRoll))
                - (5 * (playerDefence * playerRoll)));

        if (enemyDamage < 0) enemyDamage = 0;

        // Apply damage
        enemy.takeDamage(playerDamage);
        player.takeDamage(enemyDamage);

        // Print combat result
        System.out.println(
                "You do " + playerDamage + " damage and receive "
                        + enemyDamage + " damage! You have "
                        + player.getLifePoints() + " lifepoints left. The "
                        + enemy.getName() + " has "
                        + enemy.getLifePoints() + " left."
        );
    }

}

package problemdomain;

public interface Enemy {
    // basic info
    String getName();
    int getLifePoints();
    void takeDamage(int damage);

    // attack stats
    int getMeleeStrength();
    int getMagicStrength();
    int getRangedStrength();

    // defense stats
    int getMeleeDefence();
    int getMagicDefence();
    int getRangedDefence();
}
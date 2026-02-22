package problemdomain;

public class EvilImp implements Enemy {
    private String name = "Evil Imp";
    private int lifePoints = 50;
    private int meleeStrength = 5;
    private int magicStrength = 5;
    private int rangedStrength = 5;
    private int meleeDefence = 0;
    private int magicDefence = 0;
    private int rangedDefence = 0;

    public int getLifePoints() {
        return lifePoints;
    }

    public void takeDamage(int damage) {
        lifePoints -= damage;
        if (lifePoints < 0) {
            lifePoints = 0;
        }
    }

    @Override
    public int getMeleeStrength() {
        return meleeStrength;
    }

    @Override
    public int getMagicStrength() {
        return magicStrength;
    }

    @Override
    public int getRangedStrength() {
        return rangedStrength;
    }

    @Override
    public int getMeleeDefence() {
        return meleeDefence;
    }

    @Override
    public int getMagicDefence() {
        return magicDefence;
    }

    @Override
    public int getRangedDefence() {
        return rangedDefence;
    }

    @Override
    public String getName() {
        return name;
    }

}

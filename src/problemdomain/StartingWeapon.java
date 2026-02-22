package problemdomain;

public class StartingWeapon {

    public enum Type {
        Sword,
        Staff,
        Bow
    }
    private int meleeStrength;
    private int magicStrength;
    private int rangedStrength;

    private Type type;

    public StartingWeapon() { }

    public StartingWeapon(Type type) {
        setType(type);
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        if (type == null) {
            throw new IllegalArgumentException("Weapon type cannot be null.");
        }
        this.type = type;

        // reset all strengths
        this.meleeStrength = 0;
        this.magicStrength = 0;
        this.rangedStrength = 0;

        switch (type) {
            case Sword:
                meleeStrength = 10;
                break;
            case Staff:
                this.magicStrength = 10;
                break;
            case Bow:
                this.rangedStrength = 10;
                break;
        }
    }

    public int getMeleeStrength() {
        return meleeStrength;
    }

    public int getMagicStrength() {
        return magicStrength;
    }

    public int getRangedStrength() {
        return rangedStrength;
    }

    public String toString() {
        return type.toString();
    }

}

package problemdomain;

public class Weapon {
    public enum Type {
        SWORD,
        STAFF,
        BOW
    }

    private Type type;

    public Weapon() {

    }

    public Weapon(Type type) {
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
    }

    public String toString() {
        return type.toString();
    }

}

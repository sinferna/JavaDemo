package problemdomain;

public class Weapon {
    public enum Type {
        SWORD,
        STAFF,
        BOW
    };

    private Type type;

    public Weapon() {

    }

    public Weapon(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
    //    private String type;
//
//    public Weapon() {
//
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }

}

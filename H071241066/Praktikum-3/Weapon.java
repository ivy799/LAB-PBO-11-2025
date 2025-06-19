package DeadRails;

public class Weapon {
    String namaSenjata;

    public Weapon() {
        this.namaSenjata = "Shovel";
    }

    public Weapon(String name) {
        this.namaSenjata = name;
    }

    public String getName() {
        return namaSenjata;
    }

    public int hitungDamage(String target) {
        if (namaSenjata.equalsIgnoreCase("Rifle")) {
            return target.equalsIgnoreCase("Head") ? 100 : 50;
        } else if (namaSenjata.equalsIgnoreCase("Shotgun")) {
            return target.equalsIgnoreCase("Head") ? 60 : 40;
        } else if (namaSenjata.equalsIgnoreCase("Revolver")) {
            return target.equalsIgnoreCase("Head") ? 50 : 30;
        } else {
            return target.equalsIgnoreCase("Head") ? 40 : 20;
        }
    }
}

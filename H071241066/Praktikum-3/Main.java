package DeadRails;

public class Main {
    public static void main(String[] args) {
        Weapon senjata = new Weapon("Rifle");

        Character orang = new Character("Cowboy", 100, senjata);
        Character zombie = new Character("Zombie", 100);

        orang.showStatus();
        zombie.showStatus();

        System.out.println("=== Pertarungan Dimulai ===");
        orang.serang(zombie, "Head");
        zombie.serang(orang, "Body");

        orang.showStatus();
        zombie.showStatus();
    }
}

package GameApp;

public class Hero {
    String name;
    int health;
    int attackPower;

    // Konstruktor Hero 
    public Hero(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }
 
    // Method serang (dapat di override oleh subclass)
    public void attack() {
        System.out.println(name + " menyerang dengan kekuatan " + attackPower);
    }
}


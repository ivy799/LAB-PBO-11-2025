
public class Hero {
    String name;
    int health, attackPower;

    public Hero(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public void Serang() {
        System.out.printf("%s menyerang dengan kekuatan %s!", this.name, this.attackPower);
    }
}

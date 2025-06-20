public class Zombie {
    String nama;
    int health;
    int damage;

    public Zombie(String nama, int health, int damage) {
        this.nama = nama;
        this.health = health;
        this.damage = damage;
    }

    public void serang(PrimisMember target) {
        if (this.health > 0 && target.health > 0) {
            System.out.println(this.nama + " menyerang " + target.nama + " (Damage: " + damage + ")");
            target.health -= damage;
            if (target.health < 0) target.health = 0;
            System.out.println("Sisa health " + target.nama + ": " + target.health + "\n");
        }
    }

    public boolean isDead() {
        return health <= 0;
    }
}
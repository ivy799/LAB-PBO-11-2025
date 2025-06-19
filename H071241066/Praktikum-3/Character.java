package DeadRails;

public class Character {
    String role;
    int health;
    Weapon weapon;

    public Character() {
        this.role = "None";
        this.health = 100;
        this.weapon = new Weapon();
    }

    public Character(String role, int health, Weapon weapon) {
        this.role = role;
        this.health = health;
        this.weapon = weapon;
    }

    public Character(String role, int health) {
        this.role = role;
        this.health = health;
        this.weapon = null;
    }

    public void showStatus() {
        System.out.println("===== STATUS KARAKTER =====");
        System.out.println("Peran  : " + role);
        System.out.println("Nyawa  : " + health);
        System.out.println("Senjata: " + (weapon != null ? weapon.getName() : "Tidak punya"));
        System.out.println();
    }

    public void serang(Character enemy, String target) {
        if (this.weapon == null) {
            System.out.println(this.role + " tidak memiliki senjata dan tidak bisa menyerang!");
            return;
        }

        System.out.printf("%s menyerang %s ke arah %s menggunakan %s!\n",
                this.role, enemy.role, target, weapon.getName());

        int damage = weapon.hitungDamage(target);
        enemy.health = enemy.health - damage;

        System.out.printf("%s terkena serangan sebesar %d damage. Sisa nyawa: %d\n",
                enemy.role, damage, Math.max(enemy.health, 0));

        if (enemy.health <= 0) {
            System.out.printf("%s telah dikalahkan!\n", enemy.role);
        }

        System.out.println();
    }
}

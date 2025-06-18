public class PrimisMember {
    String nama;
    int health;
    Senjata senjata;
    Perk perk;

    public PrimisMember() {
    }

    public PrimisMember(String nama, int health, Senjata senjata, Perk perk) {
        this.nama = nama;
        this.health = health;
        this.senjata = senjata;
        this.perk = perk;
        aktifkanEfekPerk();
    }

    private void aktifkanEfekPerk() {
        switch (perk.namaPerk.toLowerCase()) {
            case "juggernog":
                this.health += 50;
                break;
            case "double tap":
                this.senjata.damage *= 2;
                break;
            case "electric cherry":
                this.senjata.damage += 5;
                break;
        }
    }

    public void tembak(Zombie musuh) {
        if (this.health > 0) {
            System.out.println(this.nama + " menembak " + musuh.nama + " dengan " + senjata.namaSenjata + " (Damage: " + senjata.damage + ")");
            musuh.health -= senjata.damage;
            if (musuh.health < 0) musuh.health = 0;
            System.out.println("Sisa health " + musuh.nama + ": " + musuh.health + "\n");
        } else {
            System.out.println(this.nama + " sudah KO dan tidak bisa menyerang.\n");
        }
    }

    public void status() {
        System.out.println();
        System.out.println("==== STATUS ====");
        System.out.println(nama + " [HP: " + health + "]");
        System.out.println("Senjata: " + senjata.namaSenjata + " (" + senjata.jenis + ") | Perk: " + perk.namaPerk);
    }

    public boolean isDead() {
        return health <= 0;
    }
}
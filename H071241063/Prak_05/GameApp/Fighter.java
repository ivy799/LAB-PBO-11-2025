package GameApp;

public class Fighter extends Hero {
    // Konstruktor Fighter
    public Fighter(String name, int health, int attackPower) {
        super(name, health, attackPower); // memanggil konstruktor Hero menggunakan super()
    }

    public Fighter(){
        this("Petarung", 120, 30);
    }

    @Override
    public void attack() {
        System.out.println(name + " menyerang dengan pukulan keras dengan kekuatan " + attackPower);
    }
}

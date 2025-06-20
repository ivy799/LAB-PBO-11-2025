package GameApp;

public class Wizard extends Hero {
    // Konstruktor Wizard
    public Wizard() {
        super("Wizard", 80, 20); // memanggil konstruktor Hero menggunakan super()
    }

    @Override
    public void attack() {
        System.out.println(name + " melemparkan sihir dengan kekuatan " + attackPower);
    }
}

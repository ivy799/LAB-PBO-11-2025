public class Wizard extends Hero {

    public Wizard(String name) {
        super(name, 60, 20);
    }

    @Override
    public void attack() {
        System.out.println(name + " menyerang dengan sihir, damage " + attackPower + "!");
    }
}
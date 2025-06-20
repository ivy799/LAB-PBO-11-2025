public class Fighter extends Hero {

    public Fighter() {
        this("Unknown Fighter");
    }

    public Fighter(String name) {
        super(name, 120, 18);
    }

    @Override
    public void attack() {
        System.out.println(name + " menyerang dengan tangan kosong, damage " + attackPower + "!");
    }
}
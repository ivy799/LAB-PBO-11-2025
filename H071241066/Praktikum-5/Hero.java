public class Hero {
    protected String name;
    protected int health;
    protected int attackPower;
    
    public Hero(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }
    
    public void attack() {
        System.out.println(name + " menyerang dengan kekuatan " + attackPower + "!");
    }
    public String getName() {
        return name;
    }
    
    public int getHealth() {
        return health;
    }
    
    public int getAttackPower() {
        return attackPower;
    }
}
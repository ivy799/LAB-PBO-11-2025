package TP3_1_H071241010;

public class Player{
    String name;
    int health;
    int level;
    Weapon equippedWeapon;
    Armor equippedArmor;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getHealth() {
        return health;
    }
    
    public void setHealth(int health) {
        this.health = health;
    }
    
    public int getLevel() {
        return level;
    }
    
    public void setLevel(int level) {
        this.level = level;
    }
 

    public Player(){
        this.name = "Player";
        this.health = 100;
        this.level = 1;
        this.equippedWeapon = new Weapon();
        this.equippedArmor = new Armor();
    }

    public Player(String name, int health, int level){
        this.name = name;
        this.health = health;
        this.level  = level;
        this.equippedWeapon = new Weapon();
        this.equippedArmor = new Armor();
    }

    public Player(String name, int health, int level, Weapon weapon,int damage, Armor armor, int defense){
        this.name = name;
        this.health = health + defense;
        this.level  = level;
        this.equippedWeapon = weapon;
        this.equippedArmor = armor;
    }

    public void equipWeapon(Weapon weapon){
        this.equippedWeapon = weapon;
        System.out.println(this.name + " has equipped " + weapon.getName() +" for "+ weapon.getDamage() +" damage");
        System.out.println();    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public void equipArmor(Armor armor){
        this.equippedArmor = armor;
        this.health += armor.getDefense();
        System.out.println(this.name + " has equipped " + armor.getName() +" for "+ armor.getDefense());
        System.out.println();
    }

    public Armor getEquippedArmor() {
        return equippedArmor;
    }

    

    public void attack(Player enemy){
        int damage = this.equippedWeapon.getDamage() * this.level;
        System.out.println(enemy.getName() + " get dameged for " + damage + " damage");
        enemy.takeDamage(damage);
        System.out.println();
    }


    public void takeDamage(int damage){
        this.health -= damage;
        if (this.health <= 0){
            System.out.println(this.name + " is dead");
        }
    }

    public void levelUp(){
        this.level++;
        this.health += 25;
        System.out.println(this.name + " level up to level " + this.level);
    }
    
    public void result(){
        System.out.println("\n========= RESULT =========");
        System.out.println("Final Stats for " + getName() + ":");
        System.out.println("Level\t: " + getLevel());
        System.out.println("Health\t: " + getHealth());
        System.out.println("Weapon\t: " + getEquippedWeapon().getName());
        System.out.println("Damage\t: " + getEquippedWeapon().getDamage());
        System.out.println("Armor\t: " + getEquippedArmor().getName());
        System.out.println("Defense\t: " + getEquippedArmor().getDefense()); 
        System.out.println();
    }
}


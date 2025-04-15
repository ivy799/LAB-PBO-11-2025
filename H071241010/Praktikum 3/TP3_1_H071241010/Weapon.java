package TP3_1_H071241010;

public class Weapon {
    String name;
    int damage;
    
    
    public Weapon(){
        this.name = "fist";
        this.damage = 5;
    }
    
    public Weapon(String name, int damage) {
        this.name= name;
        this.damage = damage;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getDamage(){
        return this.damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void upgrade(){
        this.damage += 5;
        System.out.println(this.name + " has been upgraded to " + this.damage + " damage");
    }
}

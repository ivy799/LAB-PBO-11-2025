package TP3_1_H071241010;

public class Armor {
    String name;
    int defense;
    
    public Armor(){
        this.name = "T-Shirt";
        this.defense =0;
    }
    public Armor(String name, int defense){
        this.name = name;
        this.defense = defense;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public void setDefense(int defense){
        this.defense = defense;
    }
    
    public int getDefense(){
        return this.defense;
    }

    public void upgrade(){
        this.defense += 10;
        System.out.println(this.name + " has been upgraded to " + this.defense + " defense.");
    }
}
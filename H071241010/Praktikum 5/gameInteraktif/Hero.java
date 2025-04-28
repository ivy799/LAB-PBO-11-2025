package gameInteraktif;

public class Hero {
    protected String name;
    protected int health;
    protected int attackPower;

    public Hero(String name, int health, int attackPower){
        this.name = name;
        this.health =health;
        this.attackPower = attackPower;
    }

    public void attack(){
        System.out.println(this.name + " menyerang dengan kekuatan "+ this.attackPower+"!");
    }

}
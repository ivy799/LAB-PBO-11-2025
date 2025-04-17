package TP3_1_H071241010;

public class Main {
    public static void main(String[] args) {
        Player hero = new Player("Liebert si jago", 150, 99);
        Player enemy1 = new Player("Goblin Warrior", 80, 1);
        Player sidekick = new Player();

        Weapon necroSword = new Weapon("Necro Sword", 999);
    
        Armor dragonScale = new Armor("Dragon Scale Armor", 200);
    
         hero.equipWeapon(necroSword);
         hero.equipArmor(dragonScale);

         enemy1.attack(hero);
         hero.attack(enemy1);

         necroSword.upgrade();
         dragonScale.upgrade();

        hero.result();
        sidekick.result();
    }
}

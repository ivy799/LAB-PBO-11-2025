public class Pickaxe {
    String material;
    int durability;

    public Pickaxe(String material, int durability){
        this.material = material;
        this.durability = durability;
    }

    public int getMiningLevel() {
        return switch (material.toLowerCase()) {
            case "wood" -> 1;
            case "stone" -> 2;
            case "iron" -> 3;
            case "diamond" -> 4;
            case "netherite" -> 5;
            default -> 0;
        };
    }

    public boolean canMine(Ore ore){
        return getMiningLevel() >= ore.mininglevel;
    }

    public void use(){
        durability --;
    
    }

    public boolean isBroken(){
        return durability <= 0;

    }
}   
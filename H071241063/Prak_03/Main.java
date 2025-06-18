public class Main {
    public static void main(String[] args) {
        Miner steve = new Miner("Stive", new Pickaxe("iron", 50));
        Miner alex = new Miner("alex", new Pickaxe("stone", 30));

        Ore diamond = new Ore("diamond ore", 25, 3);
        Ore coal = new Ore("coal ore", 5, 1);
        Ore obsidian = new Ore("obsidian", 50, 5);

        steve.mine(diamond);
        steve.mine(obsidian);
        steve.mine(coal);
        steve.checkStatus();

        alex.mine(coal);
        alex.mine(diamond);
        alex.checkStatus();

        
    }
 }

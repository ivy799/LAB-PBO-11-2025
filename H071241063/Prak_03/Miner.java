import java.util.List;
import java.util.ArrayList;

public class Miner {
    String name;
    Pickaxe pickaxe;
    List<String> inventory = new ArrayList<>();

    public Miner(String name, Pickaxe pickaxe) {
        this.name = name;
        this.pickaxe = pickaxe;
    }

    public void mine(Ore ore) {
        System.out.println(name + " mencoba menambang " + ore.type + " dengan " + pickaxe.material + " Pickaxe");

        if (pickaxe.isBroken()) {
            System.out.println("Gagal! Pickaxe sudah rusak.");
            return;
        }

        if (!pickaxe.canMine(ore)) {
            System.out.println("Gagal menambang! " + pickaxe.material + " Pickaxe tidak cukup kuat untuk " + ore.type);
            return;
        }

        inventory.add(ore.getDrop());
        pickaxe.use();
        System.out.println("Berhasil menambang! Mendapatkan " + ore.getDrop());
        System.out.println("Durability pickaxe sekarang: " + pickaxe.durability);
        System.out.println();
    }

    public void checkStatus() {
        System.out.println("=================================");
        System.out.println("     Status Miner: " + name + "");
        System.out.println("=================================");
        System.out.println("Alat: " + pickaxe.material + " Pickaxe (Durability: " + pickaxe.durability + ")");
        System.out.println("Inventory: " + (inventory.isEmpty() ? "Kosong" : inventory));
        System.out.println();
    }
}
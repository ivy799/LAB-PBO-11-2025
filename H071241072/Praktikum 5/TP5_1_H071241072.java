import java.util.Scanner;

// Kelas induk (superclass)
class Hero {
    protected String name;
    protected int health;
    protected int attackPower;
    
    // Konstruktor
    public Hero(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }
    
    // Method untuk menyerang
    public void attack() {
        System.out.println(name + " menyerang dengan kekuatan " + attackPower);
    }
}

// Kelas turunan Archer
class Archer extends Hero {
    // Konstruktor dengan memanggil konstruktor superclass
    public Archer() {
        super("Archer", 100, 15);
    }
    
    // Override method attack dari kelas Hero
    @Override
    public void attack() {
        System.out.println(name + " menembakkan panah dengan kekuatan " + attackPower);
    }
}

// Kelas turunan Wizard
class Wizard extends Hero {
    // Konstruktor dengan memanggil konstruktor superclass
    public Wizard() {
        super("Wizard", 80, 20);
    }
    
    // Override method attack dari kelas Hero
    @Override
    public void attack() {
        System.out.println(name + " menyerang dengan sihir berkekuatan " + attackPower);
    }
}

// Kelas turunan Fighter
class Fighter extends Hero {
    // Konstruktor dengan memanggil konstruktor superclass
    public Fighter() {
        super("Fighter", 150, 18);
    }
    
    // Override method attack dari kelas Hero dengan menggunakan this()
    @Override
    public void attack() {
        System.out.println(this.name + " menyerang dengan pukulan berkekuatan " + this.attackPower);
    }
}
// Kelas utama untuk menjalankan game=
public class tp5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hero selectedHero = null;
        
        System.out.println("=== GAME PETUALANGAN PAHLAWAN ===");
        System.out.println("Pilih karakter:");
        System.out.println("1. Pemanah (Archer)");
        System.out.println("2. Penyihir (Wizard)");
        System.out.println("3. Petarung (Fighter)");
        System.out.print("Masukkan pilihan (1-3): ");
        
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1:
                selectedHero = new Archer();
                break;
            case 2:
                selectedHero = new Wizard();
                break;
            case 3:
                selectedHero = new Fighter();
                break;
            default:
                System.out.println("Pilihan tidak valid!");
                System.exit(0);
        }
        
        boolean running = true;
        while (running) {
            System.out.println("\n=== Menu Aksi ===");
            System.out.println("1. Serang");
            System.out.println("2. Keluar");
            System.out.print("Pilih aksi (1-2): ");
            
            int action = scanner.nextInt();
            
            switch (action) {
                case 1:
                    selectedHero.attack();
                    break;
                case 2:
                    System.out.println("Terima kasih telah bermain!");
                    running = false;
                    break;
                default:
                    System.out.println("Aksi tidak valid!");
            }
        }
        scanner.close();
    }
}
package Praktikum_5;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        Hero user = null;

        System.out.println("Pilih Karakter: ");
        System.out.println("1. Archer ");
        System.out.println("2. Wizard ");
        System.out.println("3. Fighter ");
        System.out.print("Pilihan: ");
        int pilihkarakter = x.nextInt();

        switch (pilihkarakter) {
            case 1:
                user = new Archer ("Archer", 110, 20);
                break;
            case 2:
                user = new Wizard ("Wizard", 100, 25);
                break;
            case 3:
                user = new Fighter ("Fighter", 120, 15);
                break;
            default:
                System.out.println("Pilihan tidak Valid");
                System.exit(0);
        }

        while (true) {
            System.out.println("\nMenu");
            System.out.println("1. Serang");
            System.out.println("2. Keluar");
            System.out.print("Pilihan: ");
            int menu = x.nextInt();


            switch (menu) {
                case 1:
                    user.attack();
                    break;
                case 2:
                    System.out.println("Program selesai.");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid");
                    break;
            }
        } 
    // x.close();
    }
    
}

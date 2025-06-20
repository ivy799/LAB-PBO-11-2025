package GameApp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Pilih Karakter:");
        System.out.println("1. Archer");
        System.out.println("2. Wizard");
        System.out.println("3. Fighter");
        System.out.print("Masukkan pilihan: ");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline character

        Hero hero = null;

        // Pilih karakter berdasarkan input pengguna
        switch (choice) {
            case 1:
                
                hero = new Archer();
                break;
            case 2:
             
                hero = new Wizard();
                break;
            case 3:
         
                hero = new Fighter();
                break;
            default:
                System.out.println("Pilihan tidak valid!");
                return;
        }

        // Menu interaktif
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Serang");
            System.out.println("2. Keluar");
            System.out.print("Pilih aksi: ");
            int action = sc.nextInt();

            if (action == 1) {
                hero.attack(); // Menampilkan serangan karakter
            } else if (action == 2) {
                System.out.println("Game selesai!");
                break;
            } else {
                System.out.println("Pilihan tidak valid!");
            }
        }

        sc.close();
    }
}

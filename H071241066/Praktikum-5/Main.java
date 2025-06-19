import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Hero selectedHero;

    public static void main(String[] args) {
        selectCharacter();

        boolean gameRunning = true;
        while (gameRunning) {
            displayMainMenu();
            int choice = getValidInput(1, 2);

            if (choice == 1) {
                selectedHero.attack();
            } else if (choice == 2) {
                System.out.println("Keluar dari game...");
                gameRunning = false;
            }

            if (gameRunning) {
                System.out.println();
            }
        }

        scanner.close();
    }

    private static void selectCharacter() {
        System.out.println("Pilih hero:");
        System.out.println("1. Archer");
        System.out.println("2. Wizard");
        System.out.println("3. Fighter");
        System.out.print("Masukkan pilihan (1-3): ");

        int choice = getValidInput(1, 3);

        if (choice == 1) {
            selectedHero = new Archer("Archer");
        } else if (choice == 2) {
            selectedHero = new Wizard("Wizard");
        } else if (choice == 3) {
            selectedHero = new Fighter("Fighter");
        }

        System.out.println("Hero " + selectedHero.getName() + " siap bertarung!");
        System.out.println();
    }

    private static void displayMainMenu() {
        System.out.println("Pilih aksi untuk " + selectedHero.getName() + ":");
        System.out.println("1. Serang");
        System.out.println("2. Keluar");
        System.out.print("Masukkan pilihan (1-2): ");
    }

    private static int getValidInput(int min, int max) {
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice >= min && choice <= max) {
                    break;
                } else {
                    System.out.print("Input tidak valid! Masukkan angka " + min + "-" + max + ": ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Input harus berupa angka! Masukkan angka " + min + "-" + max + ": ");
            }
        }
        return choice;
    }
}
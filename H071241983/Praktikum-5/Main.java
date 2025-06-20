import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Archer archer = new Archer("Pemanah", 100, 15);
        Wizard wizard = new Wizard("Penyihir", 100, 20);
        Fighter fighter = new Fighter("Petarung", 100, 18);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("Pilih Karakter:");
            System.out.println("1. Archer");
            System.out.println("2. Wizard");
            System.out.println("3. Fighter");
            System.out.print("Masukkan Pilihan: ");
            int karakter = scanner.nextInt();
            System.out.println();

            if (karakter < 1 || karakter > 3) {
                System.out.println("Pilihan tidak valid");
                continue;
            }
            while (true) {
                System.out.println("Menu:");
                System.out.println("1. Serang");
                System.out.println("2. Keluar");
                System.out.print("Pilih Aksi: ");
                int aksi = scanner.nextInt();

                if (aksi < 1 || aksi > 2) {
                    System.out.println("Aksi tidak valid");
                    continue;
                }

                if (aksi == 2) {
                    break;
                }

                switch (karakter) {
                    case 1:
                        archer.Serang();
                        break;
                    case 2:
                        wizard.Serang();
                        break;
                    case 3:
                        fighter.SerangLawan();
                        break;
                }
                
                System.out.println();
            }
            scanner.close();
            System.out.println("Terima kasih telah bermain!");
            break;
        }
        
    }
}
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Library library = new Library();

    private static void printMenu() {
        System.out.println("\n=== Menu Perpustakaan ===");
        System.out.println("1. Tambah Item");
        System.out.println("2. Tambah Anggota");
        System.out.println("3. Pinjam Item");
        System.out.println("4. Kembalikan Item");
        System.out.println("5. Lihat Status Perpustakaan");
        System.out.println("6. Lihat Log Aktivitas");
        System.out.println("7. Lihat Item yang Dipinjam Anggota");
        System.out.println("8. Keluar");
    }

    public static void main(String[] args) {
        int choice;
        do {
            printMenu();
            System.out.print("Pilih opsi: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                tambahItem();
            } else if (choice == 2) {
                tambahAnggota();
            } else if (choice == 3) {
                pinjamItem();
            } else if (choice == 4) {
                kembalikanItem();
            } else if (choice == 5) {
                System.out.println(library.getLibraryStatus());
            } else if (choice == 6) {
                System.out.println(library.getAllLogs());
            } else if (choice == 7) {
                lihatItemAnggota();
            } else if (choice == 8) {
                System.out.println("Terima kasih!");
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        } while (choice != 8);
    }

    private static void tambahItem() {
        System.out.print("Jenis item (1: Buku, 2: DVD): ");
        int pilihan = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Judul: ");
        String title = scanner.nextLine();
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (library.isItemIdExist(id)) {
            System.out.println("ID item sudah ada. Gunakan ID yang berbeda.");
            return;
        }
        if (pilihan == 1) {
            System.out.print("Penulis: ");
            String author = scanner.nextLine();
            library.addItem(new Book(title, id, author));
            System.out.println("Item berhasil ditambahkan");
        } else if (pilihan == 2) {
            System.out.print("Durasi (menit): ");
            int duration = scanner.nextInt();
            scanner.nextLine();
            library.addItem(new DVD(title, id, duration));
            System.out.println("Item berhasil ditambahkan");
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }

    private static void tambahAnggota() {
        System.out.print("Nama anggota: ");
        String name = scanner.nextLine();
        System.out.print("ID anggota: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (library.isMemberIdExist(id)) {
            System.out.println("ID anggota sudah ada. Gunakan ID yang berbeda.");
            return;
        }
        Member member = new Member(name, id);
        library.addMember(member);
        library.getLogger().logActivity(String.format("Anggota \"%s\" berhasil ditambahkan", member.name));
        System.out.println("Anggota berhasil ditambahkan");
    }

    private static void pinjamItem() {
        try {
            System.out.print("ID anggota: ");
            int memberId = scanner.nextInt();
            scanner.nextLine();
            Member member = library.getMembers().stream()
                    .filter(m -> m.memberId == memberId)
                    .findFirst()
                    .orElseThrow(() -> new NoSuchElementException("Anggota dengan ID ini tidak ditemukan."));

            System.out.print("ID item: ");
            int itemId = scanner.nextInt();
            scanner.nextLine();
            LibraryItem item = library.findItemById(itemId);

            System.out.print("Jumlah hari pinjam: ");
            int days = scanner.nextInt();
            scanner.nextLine();

            String result = member.borrow(item, days);
            System.out.println(result);

            String jenis = item instanceof Book ? "Buku" : "DVD";
            library.getLogger().logActivity(String.format("%s: %s dipinjam oleh %s", jenis, item.tittle, member.name));

        } catch (Exception e) {
            System.out.println("Gagal meminjam: " + e.getMessage());
        }
    }

    private static void kembalikanItem() {
        try {
            System.out.print("ID anggota: ");
            int memberId = scanner.nextInt();
            scanner.nextLine();
            Member member = library.getMembers().stream()
                    .filter(m -> m.memberId == memberId)
                    .findFirst()
                    .orElseThrow(() -> new NoSuchElementException("Anggota dengan ID tersebut tidak ditemukan."));

            System.out.print("ID item: ");
            int itemId = scanner.nextInt();
            scanner.nextLine();
            LibraryItem item = library.findItemById(itemId);

            System.out.print("Hari keterlambatan: ");
            int late = scanner.nextInt();
            scanner.nextLine();

            String result = member.returnItem(item, late);
            System.out.println(result);

            String jenis = item instanceof Book ? "Buku" : "DVD";
            library.getLogger()
                    .logActivity(String.format("%s: %s dikembalikan oleh %s", jenis, item.tittle, member.name));

        } catch (Exception e) {
            System.out.println("Gagal mengembalikan: " + e.getMessage());
        }
    }

    private static void lihatItemAnggota() {
        System.out.print("ID anggota: ");
        int memberId = scanner.nextInt();
        scanner.nextLine();
        Member member = library.getMembers().stream()
                .filter(m -> m.memberId == memberId)
                .findFirst().orElse(null);
        if (member != null) {
            member.getBorrowedItems();
        } else {
            System.out.println("Anggota tidak ditemukan.");
        }
    }
}

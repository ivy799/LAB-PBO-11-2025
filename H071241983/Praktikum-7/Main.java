import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Library library = new Library(new LibraryLogger());

    public static void main(String[] args) {
        tampilkanMenu();
    }

    public static void tampilkanMenu() {
        while (true) {
            System.out.println("\n=================================");
            System.out.println("Sistem Manajemen Perpustakaan");
            System.out.println("=================================");
            System.out.println("1. Tambah Item");
            System.out.println("2. Tambah Anggota");
            System.out.println("3. Pinjam Item");
            System.out.println("4. Kembalikan Item");
            System.out.println("5. Lihat Status Perpustakaan");
            System.out.println("6. Lihat Log Aktivitas");
            System.out.println("7. Lihat Item yang Dipinjam Anggota");
            System.out.println("8. Keluar");
            System.out.println("=================================");
            System.out.print("Pilih opsi: ");

            int pilihan;
            try {
                pilihan = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opsi Tidak Valid");
                continue;
            }

            switch (pilihan) {
                case 1:
                    tambahItem();
                    break;
                case 2:
                    tambahAnggota();
                    break;
                case 3:
                    pinjamItem();
                    break;
                case 4:
                    kembalikanItem();
                    break;
                case 5:
                    lihatStatusPerpustakaan();
                    break;
                case 6:
                    lihatLogAktivitas();
                    break;
                case 7:
                    lihatItemDipinjamAnggota();
                    break;
                case 8:
                    System.out.println("Terima kasih telah menggunakan sistem.");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih 1-8.");
            }
        }
    }

    private static void tambahItem() {
        System.out.print("Jenis Item (1: Buku, 2: DVD): ");

        int pilihan = 0;
        try {
            pilihan = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Opsi Tidak Valid");
        }

        String title;
        int itemId;
        String log;

        switch (pilihan) {
            case 1:
                System.out.print("Judul: ");
                title = scanner.nextLine();
                System.out.print("ID Item: ");
                itemId = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Penulis: ");
                String author = scanner.nextLine();
                Book book = new Book(itemId, title, author);
                log = library.addItem(book);
                library.logger.logActivity(log);
                System.out.println(log);
                break;
            case 2:
                System.out.print("Judul: ");
                title = scanner.nextLine();
                System.out.print("ID Item: ");
                itemId = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Durasi: ");
                int duration = scanner.nextInt();
                scanner.nextLine();
                DVD dvd = new DVD(title, itemId, duration);
                log = library.addItem(dvd);
                library.logger.logActivity(log);
                System.out.println(log);
                break;
            default:
                System.out.println("Opsi Tidak Valid");
                break;
        }
    }

    private static void tambahAnggota() {
        try {
            System.out.print("Nama Anggota: ");
            String nama = scanner.nextLine();
            System.out.print("ID Anggota: ");
            String memberId = scanner.nextLine();
            System.out.println(library.addMember(nama, memberId));
        } catch (Exception e) {
            System.err.println(e);
            tambahAnggota();
        }
    }

    private static void pinjamItem() {
        try {
            System.out.print("ID Anggota: ");
            String memberId = scanner.nextLine();
            Member member = library.findMemberById(memberId);
            System.out.print("ID Item: ");
            int itemId = scanner.nextInt();
            scanner.nextLine();
            LibraryItem libraryItem = library.findItemById(itemId);

            System.out.print("Jumlah hari peminjaman: ");
            int days = scanner.nextInt();
            scanner.nextLine();

            System.out.println(member.borrow(libraryItem, days));

            libraryItem.isBorrowed = true;

            String itemType;

            if (libraryItem instanceof Book) {
                itemType = "Buku";
            } else {
                itemType = "DVD";
            }

            library.logger.logBorrowActivity(itemType, libraryItem.title, member.name);
        } catch (Exception e) {
            System.err.println(e);
            pinjamItem();
        }
    }

    private static void kembalikanItem() {
        try {
            System.out.print("ID Anggota: ");
            String memberId = scanner.nextLine();
            Member member = library.findMemberById(memberId);
            System.out.print("ID Item: ");
            int itemId = scanner.nextInt();
            scanner.nextLine();
            LibraryItem libraryItem = library.findItemById(itemId);

            System.out.print("Jumlah hari keterlambatan: ");
            int daysLate = scanner.nextInt();
            scanner.nextLine();

            libraryItem.isBorrowed = false;

            String itemType;

            System.out.println(member.returnItem(libraryItem, daysLate));

            if (libraryItem instanceof Book) {
                itemType = "Buku";
            } else {
                itemType = "DVD";
            }

            library.logger.logBorrowActivity(itemType, libraryItem.title, member.name);

            library.logger.logReturnActivity("Buku", libraryItem.title, member.name);
        } catch (Exception e) {
            System.err.println(e);
            pinjamItem();
        }
    }

    private static void lihatStatusPerpustakaan() {
        library.getLibraryStatus();
    }

    private static void lihatLogAktivitas() {
        System.out.println(library.logger.getLogs());
    }

    private static void lihatItemDipinjamAnggota() {
        try {
            System.out.print("ID Anggota: ");
            String memberId = scanner.nextLine();

            library.showBorrowedItemsByMember(memberId);
        } catch (Exception e) {
            System.err.println(e);
            lihatItemDipinjamAnggota();
        }
    }
}
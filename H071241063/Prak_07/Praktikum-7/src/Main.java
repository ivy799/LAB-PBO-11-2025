import java.lang.IllegalStateException;
import java.util.InputMismatchException;
import java.util.Scanner;

import items.*;
import library.*;
import user.*;

public class Main {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            showMenu();
            int choice = 0;
            boolean valid = false;

            while (!valid) {
                System.out.print("Pilih menu (1-8): ");
                try {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    if (choice >= 1 && choice <= 8) {
                        valid = true;
                    } else {
                        System.out.println("Masukkan angka 1-8!");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Input harus angka!");
                    scanner.nextLine();
                }
            }

            try {
                switch (choice) {
                    case 1:
                        addItem();
                        break;
                    case 2:
                        addMember();
                        break;
                    case 3:
                        borrowItem();
                        break;
                    case 4:
                        returnItem();
                        break;
                    case 5:
                        library.getLibraryStatus();
                        break;
                    case 6:
                        showLogs();
                        break;
                    case 7:
                        showMemberBorrowedItems();
                        break;
                    case 8:
                        System.out.println("Terima kasih!");
                        return;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n=== Sistem Manajemen Perpustakaan ===");
        System.out.println("1. Tambah Item");
        System.out.println("2. Tambah Anggota");
        System.out.println("3. Pinjam Item");
        System.out.println("4. Kembalikan Item");
        System.out.println("5. Lihat Status Perpustakaan");
        System.out.println("6. Lihat Log Aktivitas");
        System.out.println("7. Lihat Item yang Dipinjam Anggota");
        System.out.println("8. Keluar");
    }

    private static void addItem() {
        int type = 0;
        while (true) {
            System.out.print("Jenis item (1: Book, 2: DVD): ");
            try {
                type = scanner.nextInt();
                scanner.nextLine();
                if (type == 1 || type == 2)
                    break;
                else
                    System.out.println("Masukkan 1 atau 2!");
            } catch (InputMismatchException e) {
                System.out.println("Input harus angka 1 atau 2!");
                scanner.nextLine();
            }
        }

        System.out.print("Judul: ");
        String title = scanner.nextLine();

        int itemId = 0;
        while (true) {
            System.out.print("ID Item: ");
            try {
                itemId = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("ID harus berupa angka!");
                scanner.nextLine();
            }
        }

        if (type == 1) {
            System.out.print("Author: ");
            String author = scanner.nextLine();
            Book book = new Book(title, itemId, author);
            System.out.println(library.addItem(book));
            library.logger.logActivity(title + " berhasil ditambahkan");
        } else {
            int duration = 0;
            while (true) {
                System.out.print("Durasi (menit): ");
                try {
                    duration = scanner.nextInt();
                    scanner.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Durasi harus angka!");
                    scanner.nextLine();
                }
            }
            DVD dvd = new DVD(title, itemId, duration);
            System.out.println(library.addItem(dvd));
            library.logger.logActivity(title + " berhasil ditambahkan");
        }
    }

    private static void addMember() {
        System.out.print("Nama: ");
        String name = scanner.nextLine();

        int memberId = 0;
        while (true) {
            System.out.print("ID Anggota: ");
            try {
                memberId = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("ID harus angka!");
                scanner.nextLine();
            }
        }

        for (Member existingMember : library.members) {
            if (existingMember.memberId == memberId) {
                throw new IllegalArgumentException("Anggota dengan ID " + memberId + " sudah ada");
            }
        }

        Member member = new Member(name, memberId);
        library.members.add(member);
        System.out.println("Anggota berhasil ditambahkan");
        library.logger.logActivity("Anggota " + name + " ditambahkan");
    }

    private static void borrowItem() {
        int memberId = 0, itemId = 0, days = 0;
        Member member = new Member(null, memberId);
        Book book = new Book(null, itemId, null);
        DVD dvd = new DVD(null, itemId, 0);

        while (true) {
            System.out.print("ID Anggota: ");
            try {
                memberId = scanner.nextInt();
                member = findMemberById(memberId);
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("ID harus angka!");
                scanner.nextLine();
            }
        }

        while (true) {
            System.out.print("ID Item: ");
            try {
                itemId = scanner.nextInt();
                LibraryItem item = library.findItemById(itemId);
                if (item instanceof Book) {
                    book = (Book) item;
                } else {
                    dvd = (DVD) item;
                }
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("ID harus angka!");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                throw new IllegalStateException(e.getMessage());

            }
        }

        while (true) {
            System.out.print("Jumlah hari peminjaman: ");
            try {
                days = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Harus angka!");
                scanner.nextLine();
            }
        }
        String logMessage;
        String result = "";
        if (book.title != null) {
            result = member.borrow(book, days);
            logMessage = "Buku: " + book.title + " oleh " + book.author + ", ID: " + book.itemId + " dipinjam oleh "
                    + member.name;
        } else {
            result = member.borrow(dvd, days);
            logMessage = "DVD: " + dvd.title + ", ID: " + dvd.itemId + " dipinjam oleh " + member.name;
        }

        System.out.println(result);

        library.logger.logActivity(logMessage);
    }

    private static void returnItem() {
        int memberId = 0, itemId = 0, daysLate = 0;

        while (true) {
            System.out.print("ID Anggota: ");
            try {
                memberId = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("ID harus angka!");
                scanner.nextLine();
            }
        }

        while (true) {
            System.out.print("ID Item: ");
            try {
                itemId = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("ID harus angka!");
                scanner.nextLine();
            }
        }

        while (true) {
            System.out.print("Jumlah hari keterlambatan: ");
            try {
                daysLate = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Harus angka!");
                scanner.nextLine();
            }
        }

        Member member = findMemberById(memberId);
        LibraryItem item = library.findItemById(itemId);

        String result = member.returnItem(item, daysLate);
        System.out.println(result);

        String logMessage;
        if (item instanceof Book) {
            Book book = (Book) item;
            logMessage = "Buku: " + book.title + ", ID: " + book.itemId + " dikembalikan oleh " + member.name;
        } else if (item instanceof DVD) {
            DVD dvd = (DVD) item;
            logMessage = "DVD: " + dvd.title + ", ID: " + dvd.itemId + " dikembalikan oleh " + member.name;
        } else {
            logMessage = "Item: " + item.title + ", ID: " + item.itemId + " dikembalikan oleh " + member.name;
        }

        library.logger.logActivity(logMessage);
    }

    private static void showLogs() {
        String logs = library.getAllLogs();
        if (logs.isEmpty()) {
            System.out.println("Tidak ada log aktivitas");
        } else {
            System.out.println("=== Log Aktivitas ===");
            System.out.print(logs);
        }
    }

    private static void showMemberBorrowedItems() {
        int memberId = 0;

        while (true) {
            System.out.print("Member ID: ");
            try {
                memberId = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Harus angka!");
                scanner.nextLine();
            }
        }

        Member member = findMemberById(memberId);
        member.getBorrowedItems();
    }

    private static Member findMemberById(int memberId) {
        for (Member member : library.members) {
            if (member.memberId == memberId) {
                return member;
            }
        }
        throw new IllegalArgumentException("Member dengan ID " + memberId + " tidak ditemukan");
    }
}

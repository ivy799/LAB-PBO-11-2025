package tp7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\n== Sistem Manajemen Perpustakaan ==");
            System.out.println("1. Tambah Item");
            System.out.println("2. Tambah Anggota");
            System.out.println("3. Pinjam Item");
            System.out.println("4. Kembalikan Item");
            System.out.println("5. Lihat Status Perpustakaan");
            System.out.println("6. Lihat Log Aktivitas");
            System.out.println("7. Lihat Item yang Dipinjam Anggota");
            System.out.println("8. Keluar");
            System.out.print("Pilih menu: ");

            int pilihan;
            try {
                pilihan = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Masukkan angka 1-8.");
                continue;
            }

            switch (pilihan) {
                case 1 -> {
                    System.out.print("Masukkan jenis item (1 = Buku, 2 = DVD): ");
                    String jenis = scanner.nextLine();
                    try {
                        System.out.print("Judul: ");
                        String judul = scanner.nextLine();
                        System.out.print("ID: ");
                        int id = Integer.parseInt(scanner.nextLine());

                        if (jenis.equals("1")) {
                            System.out.print("Penulis: ");
                            String author = scanner.nextLine();
                            LibraryItem item = new Book(judul, id, author);
                            System.out.println(library.addItem(item));
                        } else if (jenis.equals("2")) {
                            System.out.print("Durasi (menit): ");
                            int durasi = Integer.parseInt(scanner.nextLine());
                            LibraryItem item = new DVD(judul, id, durasi);
                            System.out.println(library.addItem(item));
                        } else {
                            System.out.println("Jenis item tidak dikenali.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Input angka tidak valid.");
                    }
                }
                case 2 -> {
                    try {
                        System.out.print("Nama Anggota: ");
                        String nama = scanner.nextLine();
                        System.out.print("ID Anggota: ");
                        int memberId = Integer.parseInt(scanner.nextLine());
                        Member member = new Member(nama, memberId);
                        library.registerMember(member);
                        System.out.println("Anggota berhasil ditambahkan.");
                        library.getLogger().logActivity(nama + " berhasil ditambahkan sebagai anggota");
                    } catch (NumberFormatException e) {
                        System.out.println("ID Anggota harus berupa angka.");
                    }
                }
                case 3 -> {
                    try {
                        System.out.print("ID Anggota: ");
                        int memberId = Integer.parseInt(scanner.nextLine());
                        Member member = library.findMemberById(memberId);
                        if (member == null){
                            System.out.println("Belum daftar");
                            continue;
                        }
                        System.out.print("ID Item: ");
                        int itemId = Integer.parseInt(scanner.nextLine());
                        LibraryItem item = library.findItemById(itemId);
                        System.out.print("Jumlah hari pinjam: ");
                        int days = Integer.parseInt(scanner.nextLine());

                        String result = member.borrow(item, days);
                        String detailItem;
                        if (item instanceof Book book) {
                            detailItem = "Buku: " + book.getTitle() + " oleh " + book.getAuthor() + ", ID: "
                                    + book.getItemId();
                        } else if (item instanceof DVD dvd) {
                            detailItem = "DVD: " + dvd.getTitle() + ", Durasi: " + dvd.getDuration() + " menit, ID: "
                                    + dvd.getItemId();
                        } else {
                            detailItem = "Item: " + item.getTitle() + ", ID: " + member.getMemberId();
                        }

                        library.getLogger().logActivity(detailItem + " dipinjam oleh " + member.getName());
                        System.out.println(result);
                    } catch (Exception e) {
                        System.out.println("Terjadi kesalahan: " + e.getMessage());
                    }
                }
                case 4 -> {
                    try {
                        System.out.print("ID Anggota: ");
                        int memberId = Integer.parseInt(scanner.nextLine());
                        System.out.print("ID Item: ");
                        int itemId = Integer.parseInt(scanner.nextLine());
                        System.out.print("Jumlah hari keterlambatan: ");
                        int daysLate = Integer.parseInt(scanner.nextLine());

                        Member member = library.findMemberById(memberId);
                        LibraryItem item = library.findItemById(itemId);

                        String result = member.returnItem(item, daysLate);
                        String detailItem;
                        if (item instanceof Book book) {
                            detailItem = "Buku: " + book.getTitle() + " oleh " + book.getAuthor() + ", ID: "
                                    + book.getItemId();
                        } else if (item instanceof DVD dvd) {
                            detailItem = "DVD: " + dvd.getTitle() + ", Durasi: " + dvd.getDuration() + " menit, ID: "
                                    + dvd.getItemId();
                        } else {
                            detailItem = "Item: " + item.getTitle() + ", ID: " + member.getMemberId();
                        }

                        library.getLogger().logActivity(detailItem + " dikembalikan oleh " + member.getName());
                        System.out.println(result);
                    } catch (Exception e) {
                        System.out.println("Terjadi kesalahan: " + e.getMessage());
                    }
                }
                case 5 -> System.out.println(library.getLibraryStatus());
                case 6 -> System.out.println(library.getAllLogs());
                case 7 -> {
                    try {
                        System.out.print("ID Anggota: ");
                        int memberId = Integer.parseInt(scanner.nextLine());
                        Member member = library.findMemberById(memberId);
                        member.getBorrowedItems();
                    } catch (Exception e) {
                        System.out.println("Terjadi kesalahan: " + e.getMessage());
                    }
                }
                case 8 -> {
                    System.out.println("Terima kasih telah menggunakan sistem.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Opsi tidak valid");
            }
        }
    }
}
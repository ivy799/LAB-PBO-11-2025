package Praktikum_7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Menu Perpustakaan ===");
            System.out.println("1. Tambah Item");
            System.out.println("2. Tambah Anggota");
            System.out.println("3. Pinjam Item");
            System.out.println("4. Kembalikan Item");
            System.out.println("5. Lihat Status Perpustakaan");
            System.out.println("6. Lihat Log Aktivitas");
            System.out.println("7. Lihat Item yang Dipinjam Anggota");
            System.out.println("8. Keluar");
            System.out.print("\nPilih: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); 

            try {
                switch (pilihan) {
                    case 1:
                        System.out.println("\nPilih tipe item:");
                        System.out.println("1. Buku");
                        System.out.println("2. DVD");
                        System.out.print("Pilihan: ");
                        int tipe = scanner.nextInt();
                        scanner.nextLine(); 

                        if (tipe == 1) {
                            System.out.print("\nJudul Buku: ");
                            String judulBuku = scanner.nextLine();
                            System.out.print("ID Buku: ");
                            int idBuku = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Penulis: ");
                            String author = scanner.nextLine();
                            Book buku = new Book(judulBuku, idBuku, author);
                            System.out.println(library.addItem(buku));
                        } else if (tipe == 2) {
                            System.out.print("\nJudul DVD: ");
                            String judulDVD = scanner.nextLine();
                            System.out.print("ID DVD: ");
                            int idDVD = scanner.nextInt();
                            System.out.print("Durasi (menit): ");
                            int durasi = scanner.nextInt();
                            DVD dvd = new DVD(judulDVD, idDVD, durasi);
                            System.out.println(library.addItem(dvd));
                        } else {
                            System.out.println("Tipe item tidak valid.");
                        }
                        break;

                    case 2:
                        System.out.print("Nama Member: ");
                        String nama = scanner.nextLine();
                        System.out.print("ID Member: ");
                        int idMember = scanner.nextInt();
                        Member member = new Member(nama, idMember);
                        library.addMember(member);
                        System.out.println("Member berhasil ditambahkan.");
                        break;

                    case 3:
                        System.out.print("ID Member: ");
                        int mIdPinjam = scanner.nextInt();
                        System.out.print("ID Item: ");
                        int iIdPinjam = scanner.nextInt();
                        System.out.print("Lama pinjam (hari): ");
                        int hari = scanner.nextInt();
                        Member mPinjam = library.findMemberById(mIdPinjam);
                        LibraryItem iPinjam = library.findItemById(iIdPinjam);
                        String hasilPinjam = mPinjam.borrow(iPinjam, hari);
                        library.getLogger().logActivity(iPinjam.getTitle() + " dipinjam oleh " + mPinjam.getName());
                        System.out.println(hasilPinjam);
                        break;

                    case 4:
                        System.out.print("ID Member: ");
                        int mIdKembali = scanner.nextInt();
                        System.out.print("ID Item: ");
                        int iIdKembali = scanner.nextInt();
                        System.out.print("Hari keterlambatan: ");
                        int telat = scanner.nextInt();
                        Member mKembali = library.findMemberById(mIdKembali);
                        LibraryItem iKembali = library.findItemById(iIdKembali);
                        String hasilKembali = mKembali.returnItem(iKembali, telat);
                        library.getLogger().logActivity(iKembali.getTitle() + " dikembalikan oleh " + mKembali.getName());
                        System.out.println(hasilKembali);
                        break;

                    case 5:
                        System.out.println(library.getLibraryStatus());
                        break;

                    case 6:
                        System.out.println("--- Log Aktivitas ---");
                        System.out.println(library.getAllLogs());
                        break;

                    case 7:
                        System.out.print("Masukkan ID Member: ");
                        int memberId = scanner.nextInt();
                        scanner.nextLine();
                        try {
                            Member memberPinjam = library.findMemberById(memberId);
                            memberPinjam.getBorrowedItems();
                        } catch (Exception e) {
                            System.out.println("Member tidak ditemukan.");
                        }
                        break;

                    case 8:
                        System.out.println("Terima kasih!");
                        return;

                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }
}

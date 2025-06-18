// package Tugas.Lab_pekan_2;

public class no2 {
    public String id;
    public String nama;
    public int stok;
    public int harga;

    public void tampilkanData() {
        System.out.println("ID Produk : " + id);
        System.out.println("Nama      : " + nama);
        System.out.println("Stok      : " + stok);
        System.out.println("Harga     : " + harga);
    }

    public void tersedia() {
        if (stok > 0) {
            System.out.println("Status    : Tersedia");
        } else {
            System.out.println("Status    : Kosong");
        }
    }

    public static void main(String[] args) {
        no2 produk1 = new no2();
        produk1.id = "P001";
        produk1.nama = "Kemeja";
        produk1.stok = 15;
        produk1.harga = 100000;

        no2 produk2 = new no2();
        produk2.id = "P002";
        produk2.nama = "Celana";
        produk2.stok = 0;
        produk2.harga = 150000;

        System.out.println("--- Produk 1 ---");
        produk1.tampilkanData();
        produk1.tersedia();

        System.out.println("\n--- Produk 2 ---");
        produk2.tampilkanData();
        produk2.tersedia();
    }
}
import java.text.NumberFormat;
import java.util.Locale;

public class TP2_2_H071241010 {
    private String id;
    private String nama;
    private int stok;
    private double harga;

    public TP2_2_H071241010(String id, String nama, int stok, double harga) {
        this.id = id;
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public boolean isTersedia() {
        return stok > 0;
    }

    public void tampilkanDataProduk() {
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        String hargaFormatted = formatRupiah.format(harga);

        System.out.println("ID Produk: " + id);
        System.out.println("Nama Produk: " + nama);
        System.out.println("Stok: " + stok);
        System.out.println("Harga: " + hargaFormatted);
        System.out.println("Tersedia: " + (isTersedia() ? "Ya" : "Tidak"));
    }

    public static void main(String[] args) {
        TP2_2_H071241010 produk1 = new TP2_2_H071241010("P001", "Laptop", 10, 12000000);
        TP2_2_H071241010 produk2 = new TP2_2_H071241010("P002", "Mouse", 0, 150000);
        TP2_2_H071241010 produk3 = new TP2_2_H071241010("P003", "Keyboard", 5, 200000);

        produk1.tampilkanDataProduk();
        System.out.println();
        produk2.tampilkanDataProduk();
        System.out.println();
        produk3.tampilkanDataProduk();
    }
}
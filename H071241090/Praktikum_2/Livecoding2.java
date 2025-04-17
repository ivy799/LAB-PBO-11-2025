package Praktikum_2;

public class Livecoding2 {
    int id;
    String nama;
    int stok;
    int harga;

    public int getId() {
        return id;
    }
    public void setId(int id) {
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
    public int getHarga() {
        return harga;
    }
    public void setHarga(int harga) {
        this.harga = harga;
    }

    public void cekStok(){
        if (stok==0) {
            System.out.println("Produk tidak tersedia");
        } else {
            System.out.println("Produk tersedia");
        }
    }

    public static void main(String[] args) {
        Livecoding2 barang1 = new Livecoding2();
        barang1.setNama("Oreo");
        barang1.setHarga(10000);
        barang1.setId(1234);
        barang1.setStok(0);
        
        System.out.println("harga " + barang1.getHarga());
        System.out.println("id " + barang1.getId());
        System.out.println("nama " + barang1.getNama());
        System.out.println("stok " + barang1.getStok());
        barang1.cekStok();
    }
}


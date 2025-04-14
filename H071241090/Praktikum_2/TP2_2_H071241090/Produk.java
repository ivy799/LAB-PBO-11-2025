
public class Produk {
    int nomorID;
    String nama;
    boolean stok;
    int harga;

    public void setID (int setID) {
        nomorID = setID;
    }

    public void setNama (String setNama) {
        nama = setNama;
    }

    public void setStock (boolean setStock) {
        stok = setStock;
    }

    public void setHarga (int setHarga) {
        harga = setHarga;
    }

    public void tampilkanInfo () {
        System.out.println("ID: " + nomorID);
        System.out.println("Nama: " + nama);
        if (stok) {
        System.out.println("Stok: Tersedia" );
        } else {
            System.out.println("Stok: Tidak Tersedia" );
        }
        System.out.println("Harga: " + harga);
    }

    public static void main(String[] args) {

        Produk barang1 = new Produk();
        barang1.setID(3447);
        barang1.setNama("Hibiscus Ice Tea");
        barang1.setStock(true);
        barang1.setHarga(80000);
        System.out.println();
        barang1.tampilkanInfo();
    }
}


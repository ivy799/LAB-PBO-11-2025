class Produk{
    String id;
    String nama;
    int stok;
    double harga;

    String getId(){
        return id;
    }

    String getNama(){
        return nama;
    }

    int getStok(){
        return stok;
    }

    double getHarga(){
        return harga;
    }

    String status(){
        return (stok > 0) ? "Stok Tersedia" : "Stok Habis";
    }

    void getInfo(){
        System.out.println("Nama Produk = " + nama);
        System.out.println("ID = " + id);
        System.out.println("Stok = " + stok);
        System.out.printf("Harga = %.0f%n", harga);
        System.out.println("Status stok = " + status() + "\n");

    }

    
}

public class Soal2 {
    public static void main(String[] args) {
        Produk telur = new Produk();
        telur.id = "F01";
        telur.nama = "Telur";
        telur.stok = 50;
        telur.harga = 3000;

        Produk beras = new Produk();
        beras.id = "F02";
        beras.nama = "Beras";
        beras.stok = 0;
        beras.harga = 14000;

        Produk sabun = new Produk();
        sabun.id = "T01";
        sabun.nama = "Sabun";
        sabun.stok = 21;
        sabun.harga = 12500;

        telur.getInfo();
        beras.getInfo();
        sabun.getInfo();
    }
}

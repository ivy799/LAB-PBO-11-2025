package Praktikum_3;

public class Tiket {
    String jenisTiket;
    int harga;
    int jumlah;

    public Tiket() {}

    public Tiket(String jenisTiket, int jumlah) {
        this.jenisTiket = jenisTiket;
        this.jumlah = jumlah;

        if (jenisTiket.equalsIgnoreCase("Reguler")) {
            this.harga = 2500000;
        } else if (jenisTiket.equalsIgnoreCase("VIP")) {
            this.harga = 5000000;
        } else if (jenisTiket.equalsIgnoreCase("Backstage")) {
            this.harga = 15000000;
        } else {
            this.harga = 0;
        }
    }
}

package Praktikum_3;

public class Artis {
    String nama;
    String genre;
    int jumlahLaguHits;

    public Artis() {}

    public Artis(String nama, String genre, int jumlahLaguHits) {
        this.nama = nama;
        this.genre = genre;
        this.jumlahLaguHits = jumlahLaguHits;
    }

    public String getNama() {
        return nama;
    }

    public String getGenre() {
        return genre;
    }

    public int getJumlahLaguHits() {
        return jumlahLaguHits;
    }

}

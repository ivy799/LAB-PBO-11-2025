package Praktikum_2.TP2_4_H071241090;

class Mahasiswa {
    String nama;
    String nim;
    Alamat alamat; 

    String getNama() {
        return nama;
    }

    String getNim() {
        return nim;
    }

    String getAlamat() {
        return alamat.jalan + ", " + alamat.kota; 
    }
}

class Alamat {
    String jalan;
    String kota;
}

public class DataMahasiswa {
    
    public static void main(String[] args) {
        Alamat alamat = new Alamat();
        alamat.jalan = "Tamalanrea Indah";
        alamat.kota = "Makassar";

        System.out.println();

        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.alamat = alamat;
        mahasiswa.nama = "Ferrari Meilani";
        mahasiswa.nim = "H071241090";

        System.out.println("Nama: " + mahasiswa.getNama());
        System.out.println("Nim: " + mahasiswa.getNim());
        System.out.println("Alamat: " + mahasiswa.getAlamat());

    }
}


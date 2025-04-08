class Alamat {
    String jalan;
    String kota;

    public String getJalan() {
        return jalan;
    }

    public String getKota() {
        return kota;
    }
}

class Mahasiswa {
    String nama;
    String nim;
    Alamat alamat; 

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public String getAlamat() {
        return alamat.getJalan() + ", " + alamat.getKota(); 
    }
}

public class TP2_4_H071241010 {
    public static void main(String[] args) {
        Alamat alamat = new Alamat();
        alamat.jalan = "Jl. Bumi Tamalanrea Permai";
        alamat.kota = "Makassar";

        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.alamat = alamat;
        mahasiswa.nama = "Ahmad Farel Algifhari";
        mahasiswa.nim = "H071241010";

        System.out.println("Nama: " + mahasiswa.getNama());
        System.out.println("Nim: " + mahasiswa.getNim());
        System.out.println("Alamat: " + mahasiswa.getAlamat());
    }
}
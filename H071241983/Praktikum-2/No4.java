class Alamat {
    String jalan, kota;
}

class Mahasiswa {
    Alamat alamat;
    String nama, nim;

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public String getAlamat() {
        return alamat.jalan + ", " + alamat.kota;
    }

}

public class No4 {
    public static void main(String[] args) {
        Alamat alamat = new Alamat();
        alamat.jalan = "Nuri Baru";
        alamat.kota = "Makassar";

        Mahasiswa mahasiswa = new Mahasiswa();

        mahasiswa.alamat = alamat;
        mahasiswa.nama = "Moch Syech Yusuf M";
        mahasiswa.nim = "H071241093";

        System.out.println("Nama: " + mahasiswa.getNama());
        System.out.println("Nim: " + mahasiswa.getNim());
        System.out.println("Nim: " + mahasiswa.getAlamat());
    }
}

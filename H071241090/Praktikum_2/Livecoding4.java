package Praktikum_2;

public class Livecoding4 {
     public String jalan;
    public String kota;
}

 class Mahasiswa { 
    String nama;
    String nim;
    Livecoding4 alamat;
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getNim() {
        return nim;
    }
    public void setNim(String nim) {
        this.nim = nim;
    }
    public String getAlamat() {
        return alamat.jalan + ", " + alamat.kota;
    }
    public void setAlamat(Livecoding4 alamat) {
        this.alamat = alamat;
    }
}

    class Main {
        public static void main(String[] args) {
            Livecoding4 alamat = new Livecoding4();
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

package Praktikum_3;

import java.util.ArrayList;

public class Coachella {
    String namaFestival;
    int tahun;
    String jadwalMulai;
    int kapasitas;
    Artis artisUtama = new Artis();
    Tiket tiketFestival = new Tiket();
    int jumlahArtis;
    ArrayList<Artis> daftarArtis = new ArrayList<Artis> ();

    public Coachella() {}

    public Coachella(String namaFestival, int tahun, String jadwalMulai,int kapasitas) {
        this.namaFestival = namaFestival;
        this.tahun = tahun;
        this.kapasitas = kapasitas;
        this.jadwalMulai = jadwalMulai;
    }

    public void addArtis(Artis artisutama) {
        daftarArtis.add(artisutama);
        jumlahArtis++;
    }

    public void tukarJadwal (Coachella lain) {
        String tanggal = this.jadwalMulai;
        this.jadwalMulai = lain.jadwalMulai;
        lain.jadwalMulai = tanggal;

    }

    public void tampilkanLineUp() {
        System.out.println("\n===== Festival Line Up =====");
        System.out.println("Festival: " + namaFestival + " (" + tahun + ")");
        System.out.println("Jadwal Mulai: " + jadwalMulai);
        System.out.println("Kapasitas: " + kapasitas);
        System.out.println("Daftar artis: ");
        for (Artis artis : daftarArtis) {
            System.out.println("- " + artis.nama);
        }
        System.out.println("Jumlah artis yang tampil: " + jumlahArtis);
    }

    public void tampilkanDetailTiket() {
        System.out.println("\n== Detail Tiket ==");
        System.out.println("Festival: " + this.namaFestival);
        if (tiketFestival.harga==0){
            System.out.println("Jenis tiket tidak dikenali.");
        } else {
        System.out.println("Jenis Tiket: " + tiketFestival.jenisTiket);
        System.out.println("Jumlah: " + tiketFestival.jumlah);
        System.out.println("Harga per tiket: Rp " + tiketFestival.harga);
        System.out.println("Total Harga: Rp " + (tiketFestival.harga * tiketFestival.jumlah));
        }
    }       
}



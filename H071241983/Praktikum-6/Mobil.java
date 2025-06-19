package pbo25.week_6;

import java.util.Calendar;
import java.util.Date;

public class Mobil extends Kendaraan implements IBergerak, IServiceable {

    protected double kecepatan = 0.0;
    private boolean sedangBerjalan = false;

    protected int jumlahPintu;
    protected double kapasitasMesin;

    protected int harga, tahunDibeli;

    protected int jumlahKursi;
    protected String bahanBakar;

    private boolean kondisiBaik = true;
    private Date waktuServisTerakhir;
    private int kilometerTerakhir = 0;
    private int kilometerSekarang = 0;

    public Mobil(String merek, String model, int kilometerAwal, String tipeKendaraan) {
        this.merek = merek;
        this.model = model;
        this.kilometerSekarang = kilometerAwal;
        waktuServisTerakhir = new Date();
        this.tipeKendaraan = tipeKendaraan;
    }

    public int getJumlahPintu() {
        return jumlahPintu;
    }

    public double getKapasitasMesin() {
        return kapasitasMesin;
    }

    public int getJumlahKursi() {
        return jumlahKursi;
    }

    public void setJumlahKursi(int jumlahKursi) {
        this.jumlahKursi = jumlahKursi;
    }

    public String getBahanBakar() {
        return bahanBakar;
    }

    public void setBahanBakar(String bahanBakar) {
        this.bahanBakar = bahanBakar;
    }

    @Override
    public double hitungPajak() {
        // Asumsi NJKB = harga kendaraan saat baru
        // Nilai Jual Kendaraan Bermotor
        double njkb = this.harga;

        // Hitung usia kendaraan (tahun sekarang - tahun dikeluarkan)
        int tahunSekarang = java.time.Year.now().getValue();
        int usiaKendaraan = tahunSekarang - this.tahunDibeli;

        // Penyusutan NJKB: 10% per tahun (maksimal 10 tahun)
        for (int i = 0; i < usiaKendaraan && i < 10; i++) {
            njkb *= 0.9; // Mengurangi 10% setiap tahun
        }

        // Hitung PKB (1.5% untuk mobil kecil, 2% untuk mobil besar)
        double tarifPkb = (this.kapasitasMesin <= 1500) ? 0.015 : 0.02;
        double pkb = njkb * tarifPkb;

        // Sumbangan Wajib Dana Kecelakaan Lalu Lintas Jalan
        // SWDKLLJ (mobil pribadi = Rp 143.000)
        double swdkllj = 143000;

        // Total pajak = PKB + SWDKLLJ
        return pkb + swdkllj;
    }

    @Override
    public String getTipeKendaraan() {
        return this.tipeKendaraan;
    }

    @Override
    public boolean mulai() {
        if (!sedangBerjalan) {
            sedangBerjalan = true;
            kecepatan = 15.0; // kecepatan awal
            System.out.println("Mobil mulai bergerak.");
            return true;
        }
        System.out.println("Mobil sudah berjalan.");
        return false;
    }

    @Override
    public boolean berhenti() {
        if (sedangBerjalan) {
            sedangBerjalan = false;
            kecepatan = 0.0;
            System.out.println("Mobil berhenti.");
            return true;
        }
        System.out.println("Mobil sudah berhenti.");
        return false;
    }

    @Override
    public double getKecepatan() {
        return this.kecepatan;
    }

    @Override
    public void setKecepatan(double kecepatan) {
        if (sedangBerjalan) {
            this.kecepatan = kecepatan;
            System.out.println("Kecepatan diubah menjadi " + kecepatan + " km/jam");
        } else {
            System.out.println("Mobil belum mulai, tidak bisa ubah kecepatan.");
        }
    }

    @Override
    public boolean periksaKondisi() {
        int jarakTempuh = kilometerSekarang - kilometerTerakhir;
        if (jarakTempuh >= 10000) {
            kondisiBaik = false;
        } else {
            kondisiBaik = true;
        }
        return kondisiBaik;
    }

    @Override
    public void lakukanServis() {
        if (!periksaKondisi()) {
            kilometerTerakhir = kilometerSekarang;
            waktuServisTerakhir = new Date();
            kondisiBaik = true;
            System.out.println("Servis telah dilakukan.");
        } else {
            System.out.println("Kondisi masih baik. Servis belum diperlukan.");
        }
    }

    @Override
    public Date getWaktuServisBerikutnya() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(waktuServisTerakhir);
        cal.add(Calendar.MONTH, 6);
        return cal.getTime();
    }

    @Override
    public double hitungBiayaServis() {
        if (!kondisiBaik) {
            return 750_000.0;
        }
        return 0.0;
    }

    public void updateKilometer(int kilometerBaru) {
        this.kilometerSekarang = kilometerBaru;
    }
}

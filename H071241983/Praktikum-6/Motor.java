package pbo25.week_6;

import java.util.Calendar;
import java.util.Date;

public class Motor extends Kendaraan implements IBergerak, IServiceable {
    protected String jenisMotor, tipeSuspensi;
    protected double kapasitasTangki;
    protected double kapasitasMesin;

    protected double kecepatan = 0.0;
    private boolean sedangBerjalan = false;

    private boolean kondisiBaik = true;
    private Date waktuServisTerakhir;
    private int kilometerTerakhir = 0;
    private int kilometerSekarang = 0;

    protected int harga, tahunDibeli;

    public Motor(String merek, String model, String tipeKendaraan) {
        this.merek = merek;
        this.model = model;
        this.tipeKendaraan = tipeKendaraan;
    }

    public String getJenisMotor() {
        return jenisMotor;
    }

    public void setJenisMotor(String jenisMotor) {
        this.jenisMotor = jenisMotor;
    }

    public void setTipeKendaraan(String tipeKendaraan) {
        this.tipeKendaraan = tipeKendaraan;
    }

    public double getKapasitasTangki() {
        return kapasitasTangki;
    }

    public void setKapasitasTangki(double kapasitasTangki) {
        this.kapasitasTangki = kapasitasTangki;
    }

    public String getTipeSuspensi() {
        return tipeSuspensi;
    }

    public void setTipeSuspensi(String tipeSuspensi) {
        this.tipeSuspensi = tipeSuspensi;
    }

    @Override
    public double hitungPajak() {
        // Asumsi NJKB = harga kendaraan saat baru
        double njkb = this.harga;

        // Hitung usia kendaraan
        int tahunSekarang = java.time.Year.now().getValue();
        int usiaKendaraan = tahunSekarang - this.tahunDibeli;

        // Penyusutan NJKB: 10% per tahun (maksimal 10 tahun)
        for (int i = 0; i < usiaKendaraan && i < 10; i++) {
            njkb *= 0.9;
        }

        // Hitung PKB (1% untuk motor kecil, 2% untuk motor besar)
        double tarifPkb = (this.kapasitasMesin <= 250) ? 0.01 : 0.02; // Motor ≤250cc tarif 1%
        double pkb = njkb * tarifPkb;

        // SWDKLLJ motor = Rp 35.000 (pribadi)
        double swdkllj = 35000;

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
            kecepatan = 10.0; // kecepatan awal
            System.out.println("Motor mulai bergerak.");
            return true;
        }
        System.out.println("Motor sudah berjalan.");
        return false;
    }

    @Override
    public boolean berhenti() {
        if (sedangBerjalan) {
            sedangBerjalan = false;
            kecepatan = 0.0;
            System.out.println("Motor berhenti.");
            return true;
        }
        System.out.println("Motor sudah berhenti.");
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
            System.out.println("Motor belum mulai, tidak bisa ubah kecepatan.");
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

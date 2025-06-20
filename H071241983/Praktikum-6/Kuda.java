package pbo25.week_6;

public class Kuda extends Kendaraan implements IBergerak {
    private String jenisKuda; // Misalnya: "Kuda Pacu", "Kuda Beban"
    private double kecepatan = 0.0; // Kecepatan kuda (dalam km/jam)
    private boolean sedangBerjalan = false;

    public Kuda(String id, String merek, String model, String warna, int tahunProduksi, String jenisKuda) {
        this.id = id;
        this.merek = merek;
        this.model = model;
        this.warna = warna;
        this.tahunProduksi = tahunProduksi;
        this.jenisKuda = jenisKuda;
        this.tipeKendaraan = "Hewan";
    }

    public String getJenisKuda() {
        return jenisKuda;
    }

    public void setJenisKuda(String jenisKuda) {
        this.jenisKuda = jenisKuda;
    }

    @Override
    public double hitungPajak() {
        return 0.0;
    }

    @Override
    public String getTipeKendaraan() {
        return tipeKendaraan;
    }

    @Override
    public boolean mulai() {
        if (!sedangBerjalan) {
            sedangBerjalan = true;
            kecepatan = 3.0; // Kecepatan awal kuda (misalnya 10 km/jam)
            System.out.println("Kuda mulai bergerak.");
            return true;
        }
        System.out.println("Kuda sudah mulai bergerak.");
        return false;
    }

    @Override
    public boolean berhenti() {
        if (sedangBerjalan) {
            sedangBerjalan = false;
            kecepatan = 0.0;
            System.out.println("Kuda berhenti.");
            return true;
        }
        System.out.println("Kuda sudah berhenti.");
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
            System.out.println("Kecepatan kuda diubah menjadi " + kecepatan + " km/jam");
        } else {
            System.out.println("Kuda belum mulai berjalan, tidak bisa ubah kecepatan.");
        }
    }
}

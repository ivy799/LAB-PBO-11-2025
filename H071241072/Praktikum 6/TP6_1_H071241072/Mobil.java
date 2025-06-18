import java.util.Date;

class Mobil extends Kendaraan implements IBergerak, IServiceable {
    int jumlahPintu;
    double kapasitasMesin;
    int jumlahKursi;
    String bahanBakar;
    double kecepatan;

    public Mobil(String merek, String model, double kecepatan) {
        super(merek, model);
        this.kecepatan = kecepatan;
    }


    public int getJumlahPintu() {
        return jumlahPintu;
    }

    public void setJumlahPintu(int jumlahPintu) {
        this.jumlahPintu = jumlahPintu;
    }

    public double getKapasitasMesin() {
        return kapasitasMesin;
    }

    public void setKapasitasMesin(double kapasitasMesin) {
        this.kapasitasMesin = kapasitasMesin;
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

    public double hitungPajak() {
        return kapasitasMesin * 1000000;
    }

    public String getTipeKendaraan() {
        return "Mobil";
    }

    public boolean mulai() {
        System.out.println("Mobil dinyalakan");
        return true;
    }

    public boolean berhenti() {
        System.out.println("Mobil dihentikan");
        return true;
    }

    public double getKecepatan() {
        return kecepatan;
    }

    public void setKecepatan(double kecepatan) {
        this.kecepatan = kecepatan;
    }

    public boolean periksaKondisi() {
        return true;
    }

    public void lakukanServis() {
        System.out.println("Mobil sedang diservis");
    }

    public Date getWaktuServisBerikutnya() {
        return new Date(System.currentTimeMillis() + 30 * 24 * 60 * 60 * 1000);
    }

    public double hitungBiayaServis() {
        return 500000;
    }
}
import java.util.Date;

class Motor extends Kendaraan implements IBergerak, IServiceable {
    String jenisMotor;
    double kapasitasTangki;
    String tipeSuspensi;
    double kecepatan;

    public Motor(String merek, String model, double kecepatan) {
        super(merek, model);
        this.kecepatan = kecepatan;
    }

    public String getJenisMotor() {
        return jenisMotor;
    }

    public void setJenisMotor(String jenisMotor) {
        this.jenisMotor = jenisMotor;
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

    public double hitungPajak() {
        return kapasitasTangki * 80;
    }

    public String getTipeKendaraan() {
        return "Motor";
    }

    public boolean mulai() {
        System.out.println("Motor dinyalakan");
        return true;
    }

    public boolean berhenti() {
        System.out.println("Motor dihentikan");
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
        System.out.println("Motor sedang diservis");
    }

    public Date getWaktuServisBerikutnya() {
        return new Date(System.currentTimeMillis() + 60 * 24 * 60 * 60 * 1000);
    }

    public double hitungBiayaServis() {
        return 200000;
    }
}
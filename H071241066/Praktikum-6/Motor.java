import java.util.Date;

public class Motor extends Kendaraan implements IBergerak, IServicable {
    private String jenisMotor;
    private double kapasitasTangki;
    private String tipeSuspensi;
    private double kecepatan;

    public Motor(String merek, String model) {
        super(merek, model);
    }

    public String getJenisMotor() {
        return jenisMotor;
    }

    public void setJenisMotor(String jenis) {
        this.jenisMotor = jenis;
    }

    public double getKapasitasTangki() {
        return kapasitasTangki;
    }

    public void setKapasitasTangki(double kapasitas) {
        this.kapasitasTangki = kapasitas;
    }

    public String getTipeSuspensi() {
        return tipeSuspensi;
    }

    public void setTipeSuspensi(String tipe) {
        this.tipeSuspensi = tipe;
    }

    @Override
    public String getTipeKendaraan() {
        return "Motor";
    }

    @Override
    public boolean mulai() {
        System.out.println("motor dinyalakan");
        return true;
    }

    @Override
    public boolean berhenti() {
        System.out.println("motor dimatikan");
        return true;
    }

    @Override
    public double getKecepatan() {
        return kecepatan;
    }

    @Override
    public void setKecepatan(double kecepatan) {
        this.kecepatan = kecepatan;
    }

    @Override
    public boolean periksaKondisi() {
        return true;
    }

    @Override
    public void lakukanServis() {
        System.out.println("motor diservis");
    }

    @Override
    public Date getWaktuServisBerikutnya() {
        return new Date(System.currentTimeMillis() + 15L * 24 * 60 * 60 * 1000);
    }

    @Override
    public double hitungBiayaServis() {
        return 250_000;
    }

    @Override
    public double hitungPajak() {
        return kapasitasTangki * 50_000;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }
}
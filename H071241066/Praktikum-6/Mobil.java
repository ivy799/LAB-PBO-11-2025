import java.util.Date;

public class Mobil extends Kendaraan implements IBergerak, IServicable {
    private int jumlahPintu;
    private double kapasitasMesin;
    private int jumlahKursi;
    private String bahanBakar;
    private double kecepatan;

    public Mobil(String merek, String model) {
        super(merek, model);
    }

    public int getJumlahPintu() {
        return jumlahPintu;
    }

    public void setJumlahPintu(int jumlah) {
        this.jumlahPintu = jumlah;
    }

    public double getKapasitasMesin() {
        return kapasitasMesin;
    }

    public void setKapasitasMesin(double kapasitas) {
        this.kapasitasMesin = kapasitas;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public int getJumlahKursi() {
        return jumlahKursi;
    }

    public void setJumlahKursi(int jumlah) {
        this.jumlahKursi = jumlah;
    }

    public String getBahanBakar() {
        return bahanBakar;
    }

    public void setBahanBakar(String bahanBakar) {
        this.bahanBakar = bahanBakar;
    }

    @Override
    public boolean mulai() {
        System.out.println("Mobil mulai bergerak.");
        return true;
    }

    @Override
    public boolean berhenti() {
        System.out.println("Mobil berhenti.");
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
        System.out.println("Mobil sedang diservis.");
    }

    @Override
    public Date getWaktuServisBerikutnya() {
        return new Date(System.currentTimeMillis() + 30L * 24 * 60 * 60 * 1000); // +30 hari
    }

    @Override
    public double hitungBiayaServis() {
        return 500_000;
    }

    @Override
    public double hitungPajak() {
        return kapasitasMesin * 700_000;
    }
}

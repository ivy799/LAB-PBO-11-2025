import java.util.Date;
import java.util.Calendar;

public class Mobil extends Kendaraan implements IBergerak, IServiceable {
    private int jumlahPintu;
    private double kapasitasMesin;
    private int jumlahKursi;
    private String bahanBakar;
    private double kecepatan;
    private Date waktuServisTerakhir;

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
    public double hitungPajak() {

        double njkb = 10000000 + (kapasitasMesin * 100000);

        double pkb = 0.015 * njkb;

        double swdkllj = 143000;

        double pajakBahanBakar = bahanBakar.equalsIgnoreCase("solar") ? 200_000 : 0;

        long now = System.currentTimeMillis();
        long lastService = waktuServisTerakhir.getTime();
        long selisihHari = (now - lastService) / (1000 * 60 * 60 * 24);
        double dendaServis = selisihHari > 365 ? 500000 : 0;

        return pkb + swdkllj + pajakBahanBakar + dendaServis;
    }

    @Override
    public String getTipeKendaraan() {
        return "Mobil";
    }

    public boolean mulai() {
        return true;
    }

    public boolean berhenti() {
        kecepatan = 0;
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
        waktuServisTerakhir = new Date();
    }

    public Date getWaktuServisBerikutnya() {
        if (waktuServisTerakhir == null)
            return null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(waktuServisTerakhir);
        cal.add(Calendar.MONTH, 6);
        return cal.getTime();
    }

    public double hitungBiayaServis() {
        return 500000;
    }
}

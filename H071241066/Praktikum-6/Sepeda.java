import java.util.Date;

public class Sepeda extends Kendaraan implements IServicable, IBergerak {
    private String jenisSepeda;
    private int jumlahGear;
    private int ukuranRoda;
    private double kecepatan;

    public Sepeda(String merek, String model) {
        super(merek, model);
    }

    public String getJenisSepeda() {
        return jenisSepeda;
    }

    public void setJenisSepeda(String jenisSepeda) {
        this.jenisSepeda = jenisSepeda;
    }

    public int getJumlahGear() {
        return jumlahGear;
    }

    public void setJumlahGear(int jumlah) {
        this.jumlahGear = jumlah;
    }

    public int getUkuranRoda() {
        return ukuranRoda;
    }

    public void setUkuranRoda(int ukuran) {
        this.ukuranRoda = ukuran;
    }

    @Override
    public double hitungPajak() {
        return 0;
    }

    @Override
    public boolean mulai() {
        System.out.println("Sepeda mulai dikayuh.");
        return true;
    }

    @Override
    public boolean berhenti() {
        System.out.println("Sepeda berhenti.");
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
        System.out.println("Sepeda diservis.");
    }

    @Override
    public Date getWaktuServisBerikutnya() {
        return new Date(System.currentTimeMillis() + 90L * 24 * 60 * 60 * 1000); // +90 hari
    }

    @Override
    public double hitungBiayaServis() {
        return 75_000;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }
}

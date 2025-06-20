import java.util.Date;

class Sepeda extends Kendaraan implements IBergerak, IServiceable {
    String jenisSepeda;
    int jumlahGear;
    int ukuranRoda;
    double kecepatan;

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

    public void setJumlahGear(int jumlahGear) {
        this.jumlahGear = jumlahGear;
    }

    public int getUkuranRoda() {
        return ukuranRoda;
    }

    public void setUkuranRoda(int ukuranRoda) {
        this.ukuranRoda = ukuranRoda;
    }

    public double hitungPajak() {
        return 0;
    }

    public String getTipeKendaraan() {
        return "Sepeda";
    }

    public boolean mulai() {
        System.out.println("Mulai mengayuh sepeda");
        return true;
    }

    public boolean berhenti() {
        System.out.println("Sepeda berhenti");
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
        System.out.println("Sepeda diservis");
    }

    public Date getWaktuServisBerikutnya() {
        return new Date(System.currentTimeMillis() + 90 * 24 * 60 * 60 * 1000);
    }

    public double hitungBiayaServis() {
        return 100000;
    }
}
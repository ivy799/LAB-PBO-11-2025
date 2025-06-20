public class SepedaListrik extends Kendaraan implements IBergerak {
    private double kapasitasMuatan;
    private double kecepatan;

    public SepedaListrik(String merek, String model) {
        super(merek, model);
    }

    public double getKapasitasMuatan() {
        return kapasitasMuatan;
    }

    public void setKapasitasMuatan(double kapasitas) {
        this.kapasitasMuatan = kapasitas;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    @Override
    public boolean mulai() {
        System.out.println("Skuter listrik mulai berjalan.");
        return true;
    }

    @Override
    public boolean berhenti() {
        System.out.println("Skuter listrik berhenti.");
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
    public double hitungPajak() {
        return kapasitasMuatan * 0;
    }
}

public class Kuda extends Kendaraan implements IBergerak {
    double kecepatan;
    String Kelamin;

    public Kuda(String merek, String model) {
        super(merek, model);
    }

    @Override
    public boolean mulai() {
        return true;

    }

    @Override
    public boolean berhenti() {
        kecepatan = 0;
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
        return 0;
    }

    @Override
    public String getTipeKendaraan() {
        return "Kuda";
    }

    public void setKelamin(String kelamin) {
        Kelamin = kelamin;
    }

    public String getKelamin() {
        return Kelamin;
    }

}
package Praktikum_6;

public class Pesawat extends Kendaraan implements IBergerak {
    private int harga;
    private int jumlahMesin;
    private double panjangSayap;
    private double kecepatan;

    public Pesawat(String merek, String model) {
        super(merek, model);
        this.kecepatan = 0;
    }

    public int getJumlahMesin() {
        return jumlahMesin;
    }
    public void setJumlahMesin(int jumlahMesin) {
        this.jumlahMesin = jumlahMesin;
    }
    public double getPanjangSayap() {
        return panjangSayap;
    }
    public void setPanjangSayap(double panjangSayap) {
        this.panjangSayap = panjangSayap;
    }
    public int getHarga() {
        return harga;
    }
    public void setHarga(int harga) {
        this.harga = harga;
    }

    //Implementasi Kendaraan
    @Override
    public double hitungPajak() {
        return 0.3 * harga; 
    }
    
    @Override
    public String getTipeKendaraan() {
        return "Pesawat";
    }

    //Implementasi IBergerak
    @Override
    public boolean mulai() {
        System.out.println("Pesawat mulai lepas landas.");
        kecepatan = 300;
        return true;
    }

    @Override
    public boolean berhenti() {
        System.out.println("Pesawat mendarat dan berhenti.");
        kecepatan = 0;
        return true;
    }

    @Override
    public double getKecepatan() {
        System.out.println("Kecepatan Pesawat adalah " + kecepatan + " Km/h");
        return kecepatan;
    }

    @Override
    public void setKecepatan(double kecepatan) {
        this.kecepatan = kecepatan;
    }

}

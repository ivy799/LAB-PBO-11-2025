package Praktikum_6;
import java.util.Date;

public class Sepeda extends Kendaraan implements IBergerak, IServicable {
    private int harga;
    private double kecepatan;
    private String jenisSepeda;
    private int jumlahGear;
    private int ukuranRoda;
    private Date waktuServisBerikutnya;

    public Sepeda (String merek, String model){
        super(merek, model);
        this.kecepatan = 0;
        this.waktuServisBerikutnya = new Date(); 
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
    public int getHarga() {
        return harga;
    }
    public void setHarga(int harga) {
        this.harga = harga;
    }
     
    //Implementasi Kendaraan
    public double hitungPajak(){
        return 0.1 * harga;
    }

    @Override
    public String getTipeKendaraan() {
        return "Sepeda";
    }

    //Implementasi IBergerak
    @Override
    public boolean mulai(){
        System.out.println("Sepeda mulai bergerak.");
        kecepatan = 10;
        return true;
    }

    @Override
    public boolean berhenti() {
        System.out.println("Sepeda berhenti.");
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

    //Implementasi IServicable
    @Override
    public boolean periksaKondisi() {
        System.out.println("Sepeda sedang diperiksa");
        return true;
    }

    @Override
    public void lakukanServis() {
        System.out.println("Servis dilakukan.");
        waktuServisBerikutnya = new Date();
    }
    @Override
    public Date getWaktuServisBerikutnya() {
        return waktuServisBerikutnya;
    }

    public void setWaktuServisBerikutnya(Date waktuServisBerikutnya) {
        this.waktuServisBerikutnya = waktuServisBerikutnya;
    }

    @Override
    public double hitungBiayaServis() {
        return 150000; 
    }

}

package Praktikum_6;
import java.util.Date;


public class Mobil extends Kendaraan implements IBergerak, IServicable {
    private int harga;
    private int jumlahPintu;
    private double kapasitasMesin;
    private int jumlahKursi;
    private double kecepatan;
    private String bahanBakar;
    private Date waktuServisBerikutnya;

    public Mobil (String merek, String model){
        super(merek, model);
        this.kecepatan = 0;
        this.waktuServisBerikutnya = new Date(); 
    }
    public int getJumlahPintu() {
        return jumlahPintu;
    }
    public void setJumlahPintu(int jumlahPintu) {
        this.jumlahPintu = jumlahPintu;
    }
    public double getKapasitasMesin() {
        return kapasitasMesin;
    }
    public void setKapasitasMesin(double kapasitasMesin) {
        this.kapasitasMesin = kapasitasMesin;
    }
    public int getJumlahKursi() {
        return jumlahKursi;
    }
    public void setJumlahKursi(int jumlahKursi) {
        this.jumlahKursi = jumlahKursi;
    }
    public String getBahanBakar() {
        return bahanBakar;
    }
    public void setBahanBakar(String bahanBakar) {
        this.bahanBakar = bahanBakar;
    }
    public int getHarga() {
        return harga;
    }
    public void setHarga(int harga) {
        this.harga = harga;
    }
    
    // Implement abstract methods
    @Override
    public double hitungPajak() {
        return 0.25 * harga; 
    }

    @Override
    public String getTipeKendaraan() {
        return "Mobil";
    }

    // Implement IBergerak
    @Override
    public boolean mulai() {
        System.out.println("Mobil mulai bergerak.");
        kecepatan = 30;
        return true;
    }

    @Override
    public boolean berhenti() {
        System.out.println("Mobil berhenti.");
        kecepatan = 0;
        return true;
    }

    @Override
    public double getKecepatan() {
        System.out.println("Kecepatan mobil: " + kecepatan);
        return kecepatan;
    }

    @Override
    public void setKecepatan(double kecepatan) {
        this.kecepatan = kecepatan;
    }

    // Implement IServicable
    @Override
    public boolean periksaKondisi() {
        System.out.println("Mobil sedang diperiksa");
        return kapasitasMesin > 0; 
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

    @Override
    public double hitungBiayaServis() {
        return 500000; 
    }

}

package Praktikum_6;
import java.util.Calendar;
import java.util.Date;

public class Motor extends Kendaraan implements IBergerak, IServicable {
   private String jenisMotor;
   private double kapasitasTangki;
   private String tipeSuspensi;
   private double kecepatan;
   private Date waktuServisBerikutnya;
   private int harga;

   public Motor (String merek, String model){
      super(merek, model);
      this.kecepatan = 0;
      this.waktuServisBerikutnya = new Date(); 
   }

   public String getJenisMotor() {
      return jenisMotor;
   }
   public void setJenisMotor(String jenisMotor) {
      this.jenisMotor = jenisMotor;
   }
   public double getKapasitasTangki() {
      return kapasitasTangki;
   }
   public void setKapasitasTangki(double kapasitasTangki) {
      this.kapasitasTangki = kapasitasTangki;
   }
   public String getTipeSuspensi() {
      return tipeSuspensi;
   }
   public void setTipeSuspensi(String tipeSuspensi) {
      this.tipeSuspensi = tipeSuspensi;
   }
   public void setWaktuServisBerikutnya(Date waktuServisBerikutnya) {
      this.waktuServisBerikutnya = waktuServisBerikutnya;
   }
   public int getHarga() {
      return harga;
   }
   public void setHarga(int harga) {
      this.harga = harga;
   }

   //implementasi Kendaraan
   @Override
   public double hitungPajak() {
      return 0.15 * harga;
   }

   @Override
   public String getTipeKendaraan() {
        return "Motor";
   }

    // Implementasi IBergerak
    @Override
    public boolean mulai() {
        System.out.println("Motor mulai bergerak.");
        kecepatan = 20;
        return true;
    }

    @Override
    public boolean berhenti() {
        System.out.println("Motor berhenti.");
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

    // Implementasi IServicable
    @Override
    public boolean periksaKondisi() {
      System.out.println("Motor sedang diperiksa");
        return kapasitasTangki > 0; 
    }

    @Override
    public void lakukanServis() {
        System.out.println("Servis motor dilakukan.");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 6); 
        waktuServisBerikutnya = c.getTime();
    }

    @Override
    public Date getWaktuServisBerikutnya() {
        return waktuServisBerikutnya;
    }

    @Override
    public double hitungBiayaServis() {
        return 250000; 
    }
}




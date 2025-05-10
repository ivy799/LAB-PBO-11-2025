import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Mobil extends Kendaraan implements IBergerak, IServiceable {
    private int jumlahPintu;
    private double kapasitasMesin;
    private int jumlahKursi;
    private String bahanBakar;


    private boolean mulai;
    private boolean berhenti;
    
    
    public Mobil(String merk, String model){
        super(merk,model);
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

    @Override
    public boolean mulai() {
        if (!mulai) {
            mulai = true;
            berhenti = false;
            System.out.println("Mobil dinyalakan.");
        }
        return mulai;
    }

    @Override
    public boolean berhenti() {
        if (!berhenti) {
            berhenti = true;
            mulai = false;
            kecepatan = 0;
            System.out.println("Mobil dihentikan.");
        }
        return berhenti;
    }

    @Override
    public void setKecepatan(int kecepatan) {
        if (mulai && !berhenti && kecepatan >= 0) {
            this.kecepatan = kecepatan;
            System.out.println("Kecepatan disetel ke " + kecepatan + " km/h.");
        } else {
            System.out.println("Mobil harus dinyalakan terlebih dahulu!");
        }
    }

    @Override
    public int getKecepatan() {
        return kecepatan;
    }

  
    @Override
    public boolean periksaKondisi() {
        boolean kondisiBaik = kapasitasMesin > 1.0 && bahanBakar != null;
        System.out.println("Pemeriksaan kondisi mobil: " + (kondisiBaik ? "Baik" : "Perlu perawatan"));
        return kondisiBaik;
    }

    @Override
    public void lakukanServis() {
        System.out.println("Servis dilakukan: mengganti oli, memeriksa rem, dan mengecek mesin.");
    }

    @Override
    public Date getWaktuServisBerikutnya() {
        Calendar kalender = Calendar.getInstance();
        kalender.add(Calendar.MONTH, 6); 
        return kalender.getTime();
    }

    @Override
    public double hitungBiayaServis() {
        double biaya = 500000 + (kapasitasMesin * 100000); 
        NumberFormat rupiah = NumberFormat.getCurrencyInstance(new Locale("in", "ID"));
        System.out.println("Biaya servis: " + rupiah.format(biaya));
        return biaya;
    }
    

    @Override
    public double hitungPajak() {
        double pajak = kapasitasMesin * 750000; 
        NumberFormat rupiah = NumberFormat.getCurrencyInstance(new Locale("in", "ID"));
        System.out.println("Pajak kendaraan: " + rupiah.format(pajak));
        return pajak;
    }

    @Override
    public String getTipeKendaraan() { 
        return "Mobil"; 
    }
}

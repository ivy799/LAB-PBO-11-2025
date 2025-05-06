import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Sepeda extends Kendaraan implements IBergerak, IServiceable {
    private String jenisSepeda;
    private int jumlahGear;
    private int ukuranRoda;
    private int kecepatan;

    private boolean mulai;
    private boolean berhenti;


    public Sepeda(String merek, String model) {
        super(merek, model);
    }

    public String getJenisSepeda() { 
        return jenisSepeda; 
    }
    public void setJenisSepeda(String jenis) {
         this.jenisSepeda = jenis; 
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
    public boolean mulai() {
        mulai = true;
        berhenti = false;
        System.out.println("Mulai mengayuh sepeda.");
        return mulai;
    }

    @Override
    public boolean berhenti() {
        berhenti = true;
        mulai = false;
        kecepatan = 0;
        System.out.println("Sepeda berhenti.");
        return berhenti;
    }

    @Override
    public int getKecepatan() { 
        return kecepatan; 
    }

    @Override
    public void setKecepatan(int kecepatan) {
        if (mulai && kecepatan >= 0) {
            this.kecepatan = kecepatan;
            System.out.println("Kecepatan sepeda disetel ke " + kecepatan + " km/h.");
        } else {
            System.out.println("Kamu harus mulai mengayuh dulu.");
        }
    }

    @Override
    public boolean periksaKondisi() {
        boolean kondisi = ukuranRoda >= 20 && jumlahGear > 0;
        System.out.println("Kondisi sepeda: " + (kondisi ? "Baik" : "Perlu pemeriksaan"));
        return kondisi;
    }

    @Override
    public void lakukanServis() {
        System.out.println("Servis sepeda: cek rantai, pompa ban, dan pelumas gear.");
    }

    @Override
    public Date getWaktuServisBerikutnya() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 2); 
        return cal.getTime();
    }

    @Override
    public double hitungBiayaServis() {
        double biaya = 100000 + jumlahGear * 10000;
        NumberFormat rupiah = NumberFormat.getCurrencyInstance(new Locale("in", "ID"));
        System.out.println("Biaya servis: " + rupiah.format(biaya));
        return biaya;
    }

    @Override
    public double hitungPajak() {
        System.out.println("Sepeda tidak dikenakan pajak.");
        return 0; 
    }

    @Override
    public String getTipeKendaraan() { 
        return "Sepeda"; 
    }
}

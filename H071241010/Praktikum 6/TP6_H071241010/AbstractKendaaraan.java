abstract class Kendaraan{
    protected String id;
    protected String merk;
    protected String model;
    protected int tahunProduksi;  
    protected String warna;
    protected int kecepatan;

    
    
    
    public Kendaraan(String merk, String model){
        this.merk = merk;
        this.model = model;
    }
    
    public String getId() {
        return id;
    }
    
    public String getModel() {
        return model;
    }
    
    public int getTahunProduksi() {
        return tahunProduksi;
    }
    
    public int getKecepatan() {
        return kecepatan;
    }

    public void setKecepatan(int kecepatan) {
        this.kecepatan = kecepatan;
    }
    
    public void setTahunProduksi(int tahunProduksi) {
        this.tahunProduksi = tahunProduksi;
    }
    
    public String getWarna() {
        return warna;
    }
    
    public void setWarna(String warna) {
        this.warna = warna;
    }

    public abstract double hitungPajak();

    public abstract String getTipeKendaraan();
}    

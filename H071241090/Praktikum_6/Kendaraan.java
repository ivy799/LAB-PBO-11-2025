package Praktikum_6;

abstract class Kendaraan  {
    protected String id;
    protected String model;
    protected String merek;
    protected String warna;
    protected int tahunProduksi;

    public Kendaraan(String merek, String model){
        this.merek = merek;
        this.model = model;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMerek() {
        return merek;
    }

    public void setMerek(String merek) {
        this.merek = merek;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public int getTahunProduksi() {
        return tahunProduksi;
    }

    public void setTahunProduksi(int tahunProduksi) {
        this.tahunProduksi = tahunProduksi;
    }

    public abstract double hitungPajak(); 

    public abstract String getTipeKendaraan();
}
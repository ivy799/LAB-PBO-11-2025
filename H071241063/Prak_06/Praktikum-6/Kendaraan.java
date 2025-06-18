public abstract class Kendaraan {
    String id;
    String merek;
    String model;
    int tahunProduksi;
    String warna;

    public Kendaraan(String merek, String model) {
        this.merek = merek;
        this.model = model;
    }

    public String getId() {
        return id;
    }

    public String getMerek() {
        return merek;
    }

    public String getModel() {
        return model;
    }

    public int getTahunProduksi() {
        return tahunProduksi;
    }

    public void setTahunProduksi(int tahun) {
        this.tahunProduksi = tahun;
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

package pbo25.week_6;

public abstract class Kendaraan {
    protected String id, merek, model, warna;
    protected int tahunProduksi;
    protected String tipeKendaraan;

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

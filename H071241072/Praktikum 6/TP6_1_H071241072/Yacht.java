class Yacht extends Kendaraan implements IBergerak {
    double panjang;
    int jumlahDek;
    double kecepatan;

    public Yacht(String merek, String model) {
        super(merek, model);
    }

    public double getPanjang() {
        return panjang;
    }

    public void setPanjang(double panjang) {
        this.panjang = panjang;
    }

    public int getJumlahDek() {
        return jumlahDek;
    }

    public void setJumlahDek(int jumlahDek) {
        this.jumlahDek = jumlahDek;
    }

    public double hitungPajak() {
        return panjang * 1500;
    }

    public String getTipeKendaraan() {
        return "Yacht";
    }

    public boolean mulai() {
        System.out.println("Yacht mulai berlayar");
        return true;
    }

    public boolean berhenti() {
        System.out.println("Yacht berhenti");
        return true;
    }

    public double getKecepatan() {
        return kecepatan;
    }

    public void setKecepatan(double kecepatan) {
        this.kecepatan = kecepatan;
    }
}
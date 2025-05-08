package Praktikum_6;

import java.util.Date;

public interface IServicable {
    public boolean periksaKondisi();
    public void lakukanServis();
    public Date getWaktuServisBerikutnya();
    public double hitungBiayaServis();
}
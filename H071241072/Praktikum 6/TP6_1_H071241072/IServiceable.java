import java.util.Date;

interface IServiceable {
    boolean periksaKondisi();

    void lakukanServis();

    Date getWaktuServisBerikutnya();

    double hitungBiayaServis();
}
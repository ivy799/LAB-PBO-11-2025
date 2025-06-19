import java.util.Date;

public interface IServicable {
    boolean periksaKondisi();

    void lakukanServis();

    Date getWaktuServisBerikutnya();

    double hitungBiayaServis();
}

// bahwa kelas yang mengimplementasikannya harus menyertakan semua metode di
// dalamnya.
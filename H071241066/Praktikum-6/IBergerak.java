public interface IBergerak {
    boolean mulai();

    boolean berhenti();

    double getKecepatan();

    void setKecepatan(double kecepatan);
}

// bahwa kelas yang mengimplementasikannya harus menyertakan semua metode di
// dalamnya.
import java.util.Scanner;//Tujuan kode ini adalah untuk memformat ulang tanggal dari format numerik (dd-mm-yy) menjadi format yang lebih mudah dibaca oleh manusia.

public class question3{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan tanggal dalam format dd-mm-yy: ");
        String date = input.nextLine();
        input.close();
        
        String[] listBulan = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"}; //// Array nama-nama bulan
        
        int tanggal = Integer.parseInt(date.substring(0, 2));
        int bulan = Integer.parseInt(date.substring(3, 5));
        int tahun = Integer.parseInt(date.substring(6, 8));
        
        tahun += (tahun >= 26) ? 1900 : 2000;   // Konversi tahun 2 digit ke 4 digit (19xx atau 20xx) Jika tahun >= 26, maka dianggap tahun 19xx, jika tidak maka tahun 20xx
        String namaBulan = listBulan[bulan - 1];
        System.out.println(tanggal + " " + namaBulan + " " + tahun);
    }
}
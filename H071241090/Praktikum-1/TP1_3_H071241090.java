import java.util.Scanner;

public class TP1_3_H071241090 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan tanggal : ");
        String input = scanner.nextLine();

        String hasil = konversiTanggal(input);
        if (hasil != null) {
            System.out.println("Output: " + hasil);
        } else {
            System.out.println("Format tanggal tidak valid.");
        }
        scanner.close();
    }
    
    public static String konversiTanggal(String waktu) {
        String[] namaBulan = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", 
        "Agustus", "September", "Oktober", "November", "Desember"};

        String[] array = waktu.split("-");
        if (array.length != 3) {
            return null;
        }

        int tanggal = Integer.parseInt(array[0]);
        int bulan = Integer.parseInt(array[1]);
        int tahun = Integer.parseInt(array[2]);

        if (tahun <= 25) {
            tahun += 2000;
        } else {
            tahun += 1900;
        }

        if (bulan < 1 || bulan > 12){
            return null;
        }
        return tanggal + " " + namaBulan[bulan-1] + " " + tahun;
    }
}

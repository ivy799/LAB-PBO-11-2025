import java.util.Scanner;

public class Soal3 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);

        System.out.print("Masukkan Tanggal (dd-mm-yy): ");
        String input = x.nextLine();

        try {
            String[] bagian = input.split("-");
            int hari = Integer.parseInt(bagian[0]);
            int bulan = Integer.parseInt(bagian[1]);
            int tahun = Integer.parseInt(bagian[2]); 

            if (tahun >= 0 && tahun <= 99) {
                if (tahun >= 25) {
                    tahun += 1900; 
                } else {
                    tahun += 2000; 
                }
            } else {
                System.out.println("Format tahun salah. Gunakan format yy (00-99).");
                return;
            }

            
            if (bulan < 1 || bulan > 12) {
                System.out.println("Bulan tidak valid. Harus antara 1 dan 12.");
                return;
            }

            
            if (!isValid(hari, bulan, tahun)) {
                System.out.println("Tanggal tidak valid.");
                return;
            }

            String[] namaBulan = {
                "Januari", "Februari", "Maret", "April", 
                "Mei", "Juni", "Juli", "Agustus", 
                "September", "Oktober", "November", "Desember"
            };
            String output = String.format("%d %s %d", hari , namaBulan[bulan - 1], tahun);
            System.out.println("Output: " + output);
        } catch (Exception e) {
            System.out.println("Format input salah. Pastikan mengikuti format dd-mm-yy.");
        } finally {
            x.close();
        }
    }

    public static boolean isValid(int hari, int bulan, int tahun) {
        int maxHari;

        switch (bulan) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                maxHari = 31;
                break;
            case 4: case 6: case 9: case 11:
                maxHari = 30;
                break;
            case 2:
                if ((tahun % 4 == 0 && tahun % 100 != 0) || (tahun % 400 == 0)) {
                    maxHari = 29; 
                } else {
                    maxHari = 28; 
                }
                break;
            default:
                return false; 
        }

        return hari >= 1 && hari <= maxHari;
    }
}
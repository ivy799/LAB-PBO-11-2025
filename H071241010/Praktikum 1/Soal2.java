import java.util.Scanner;

public class Soal2 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);

        int[][] angka = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        System.out.print("Masukkan angka yang ingin di cari= ");
            
        try{
        int cari = x.nextInt();
        boolean ditemukan = false;

        for (int i = 0; i < angka.length; i++) {
            for (int j = 0; j < angka[i].length; j++) {
                if (angka[i][j] == cari) {
                    System.out.println("Angka " + cari + " ditemukan di posisi [" + i + "][" + j + "]");
                        ditemukan = true;
                        break;
                }
            }
            if(ditemukan){
                break;
            }
        }
            if(!ditemukan){
            System.out.println("Angka "  + cari + " tidak ditemukan dalam array.");
            }
    
    } catch (Exception e) {
        System.out.println("Input tidak valid. Harap masukkan angka bulat.");
     } finally {
        x.close();
    }
}
}


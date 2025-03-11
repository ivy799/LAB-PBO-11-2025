import java.util.Random;
import java.util.Scanner;

public class TP1_2_H071241090 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int baris = 3, kolom = 3;
        int[][] nums = new int[baris][kolom];

        System.out.println ("Array 2D: ");
        for (int i = 0; i < baris ; i++) {
            for (int j = 0; j < kolom; j++) {
                nums [i][j] = random.nextInt(10);
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
        try {
            System.out.print("Masukkan angka yang ingin dicari: ");
            int target = scanner.nextInt();

            boolean found = false;
            for (int i = 0; i < baris; i++) {
                for (int j = 0; j < kolom; j++){
                    if (nums[i][j] == target) {
                        System.out.println("Found " + target + " at [" + i + "][" + j + "]");
                       found = true;
                        break;
                }
                if (found) break;
            }
            if (!found) {
                System.out.println(target + " tidak ditemukan dalam array.");
                }     
            }
        }       
        catch (Exception e){
        System.out.println("Input tidak valid.");
        }
        scanner.close();
    } 
}

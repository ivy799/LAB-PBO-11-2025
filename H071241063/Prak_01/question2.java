import java.util.Scanner; //Kode ini dibuat dengan tujuan untuk mencari sebuah bilangan dalam array dua dimensi. 

public class question2 {
    public static void main(String[] args) {
        int[][] nums = {{1,2,3},{4,5,6},{7,8,9}};// Deklarasi array 2D bernama nums dengan 3 sub-arra
        Scanner input = new Scanner(System.in);
        
        try {
            System.out.print("Input satu bilangan bulat: ");
            int bil = input.nextInt();
            boolean found = false;
            
            for (int i = 0; i < nums.length; i++) { // Loop baris array 2D
                for (int j = 0; j < nums[i].length; j++) {// Loop untuk menelusuri kolom dalam baris saat ini
                    if (nums[i][j] == bil) {// Memeriksa apakah elemen saat ini sama dengan bilangan yang dicari
                        System.out.println("Found " + bil + " at [" + i + "][" + j + "]");// Menampilkan pesan bahwa bilangan ditemukan beserta posisinya
                        found = true;
                        break;
                    }
                }
                if (found){break;}
            }
            if (!found){System.out.println("Bilangan tidak ditemukan dalam array");}
        } catch (Exception e){
            System.out.println("Masukkan bilangan bulat");
        } finally {
            input.close();
        }
    }
}
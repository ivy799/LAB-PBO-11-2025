import java.util.Scanner;

public class question1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan Judul Film: ");
        System.out.print('>' + " ");
        String judul = input.nextLine();
        String hasil = Title(judul);
        System.out.println(hasil);
        input.close();
    }
    
    // Metode mengkonversi string ke format judul (huruf pertama setiap kata dikapitalisasi)
    public static String Title(String str) {
        
        char[] lower = "abcdefghijklmnopqrstuvwxyz".toCharArray();//array berisi huruf kecil dan huruf besar
        char[] upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        
        str = str.toLowerCase();
        char[] chars = str.toCharArray();
        boolean kapital = true;
        
        // Melakukan perulangan untuk setiap karakter dalam string
        for (int i = 0; i < chars.length; i++) {
            if (kapital&& chars[i] >= 'a' && chars[i] <= 'z') {// Memeriksa apakah karakter saat ini perlu dikapitalisasi dan merupakan huruf kecil
                // Mencari huruf besar dan kecil 
                for (int j = 0; j < lower.length; j++) {
                    if (chars[i] == lower[j]) {
                        chars[i] = upper[j];
                        break;
                    }
                }
            } 
            // Ini memastikan huruf pertama setiap kata dikapitalisasi
            kapital = (chars[i] == ' ');
        }
        return new String(chars);
    }
}

//revisi....

//loping perkalimat

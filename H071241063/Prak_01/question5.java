import java.util.Scanner;//Kode ini dibuat untuk memvalidasi password berdasarkan beberapa kriteria keamanan yang umum digunakan.

public class question5 {
    public static boolean CekPassword(String password) {
        if (password.length() < 8) {//minimal 8 karakter
            return false;
        }
        boolean adaHurufBesar = false; 
        boolean adaHurufKecil = false; 
        boolean adaAngka = false; 

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                adaHurufBesar = true;
            } else if (Character.isLowerCase(c)) {
                adaHurufKecil = true;
            } else if (Character.isDigit(c)) {
                adaAngka = true;
            }
            if (adaHurufBesar && adaHurufKecil && adaAngka) {
                return true;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); 
        System.out.print("Masukkan password: "); 
        String password = input.nextLine(); 
        input.close();
        
        if (CekPassword(password)) {
            System.out.println("Password valid"); 
        } else {
            System.out.println("Password tidak valid");
    }
}
}
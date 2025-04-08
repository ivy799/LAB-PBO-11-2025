import java.util.Scanner;

public class TP1_5_H071241090 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();
        
        if (isValidPassword(password)) {
            System.out.println("Password valid");
        } else {
            System.out.println("Password tidak valid");
        }
        
        scanner.close();
    }

    public static boolean isValidPassword(String password) {
        boolean adaKapital = false;
        boolean adaHurufKecil = false;
        boolean adaAngka = false;
        
        if (password.length() < 8) {
            return false;
        }

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                adaKapital = true;
            } else if (Character.isLowerCase(ch)) {
                adaHurufKecil = true;
            } else if (Character.isDigit(ch)) {
                adaAngka = true;
            }
            
            if (adaKapital && adaHurufKecil && adaAngka) {
                return true;
            }
        }
        return false;
    }
}

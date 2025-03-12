package Prak1;
import java.util.Scanner;

public class No5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        if (cekValid(password)) {
            System.out.println("Input Valid");
        } else {
            System.out.println("Input Tidak Valid");
        }

        scanner.close();
    }

    public static boolean cekValid(String password) {
        if (password.length() < 8) {
            return false;
        }

        boolean adaHurufBesar = false;
        boolean adaHurufKecil = false;
        boolean adaAngka = false;

        // Iterasi setiap karakter dalam password
        for (char karakter : password.toCharArray()) {
            if (Character.isUpperCase(karakter)) {
                adaHurufBesar = true;
            } else if (Character.isLowerCase(karakter)) {
                adaHurufKecil = true;
            } else if (Character.isDigit(karakter)) {
                adaAngka = true;
            }

            if (adaHurufBesar && adaHurufKecil && adaAngka) {
                break;
            }
        }

       
        return adaHurufBesar && adaHurufKecil && adaAngka;
    }
}

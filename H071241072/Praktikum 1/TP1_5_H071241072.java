package Tugas.Lab_pekan_1;

import java.util.Scanner;

public class TP1_5_H071241072 {
    public static boolean isValid(String password) {
        return password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*[a-z].*") && password.matches(".*\\d.*");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukkan password: ");
        System.out.println(isValid(scanner.next()) ? "Password valid" : "Password tidak valid");
        scanner.close();
    }
}
package Tugas.Lab_pekan_1;

import java.util.Scanner;

public class TP1_1_H071241072 {
    public static String kapital(String str) {
        String[] kalimat = str.split(" ");
        StringBuilder hasil = new StringBuilder();
        for (String kata : kalimat) {
            if (!kata.isEmpty()) {
                hasil.append(Character.toUpperCase(kata.charAt(0))).append(kata.substring(1).toLowerCase()).append(" ");
            }
        }
        return hasil.toString().trim();
    }
    public static void main(String[] args) {
        // Scanner input = new Scanner(System.in);
        // System.out.println("Masukkan teks: ");
        // System.out.println(kapital(input.nextLine()));
        // input.close();
        System.out.println("Hello".substring(1, 3));
    }
}
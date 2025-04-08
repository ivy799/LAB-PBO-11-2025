package Tugas.Lab_pekan_1;

import java.util.Scanner;

public class TP1_3_H071241072 {
    public static String konversi(String tanggal) {
        String[] bulan = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
        String[] parts = tanggal.split("-");
        int tahun = Integer.parseInt(parts[2]);
        tahun += (tahun < 25) ? 2000 : 1900;
        return Integer.parseInt(parts[0]) + " " + bulan[Integer.parseInt(parts[1]) - 1] + " " + tahun;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan tanggal (dd-mm-yy): ");
        System.out.println(konversi(input.next()));
        input.close();
    }
}
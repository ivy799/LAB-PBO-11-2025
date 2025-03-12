package Tugas.Lab_pekan_1;

import java.util.Scanner;

public class TP1_2_H071241072 {
    public static void cari(int[][] array, int target) {
        try {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    if (array[i][j] == target) {
                        System.out.println("Ditemukan di posisi: [" + i + "][" + j + "]");
                        return;
                    }
                }
            }
            System.out.println("Angka tidak ditemukan.");
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("Masukkan angka yang dicari: ");
        cari(array, input.nextInt());
        input.close();
    }
}
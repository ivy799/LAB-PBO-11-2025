package Tugas.Lab_pekan_1;

import java.util.Scanner;

public class TP1_4_H071241072 {
    public static int faktorial(int n) {
        return (n == 1 || n == 0) ? 1 : n * faktorial(n - 1);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan bilangan untuk faktorial: ");
        System.out.println(faktorial(input.nextInt()));
        input.close();
    }
}
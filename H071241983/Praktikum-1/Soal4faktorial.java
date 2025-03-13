package Prak1;

import java.util.Scanner;

public class Soal4faktorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan angka : ");
        int nilai = input.nextInt();
        
        int faktorial = hitungfaktor(nilai);
        System.out.println("Hasil faktorial : "+faktorial);
        input.close();
    }
    private static int hitungfaktor(int n){
        System.out.println(n);
        if (n == 1|| n ==0){
            return 1; 
        }
            return n * hitungfaktor(n-1);
        }

    }



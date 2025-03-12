package Prak1;

import java.util.Scanner;

public class Soal2Array {
    public static void main(String[] args) {
        
        int[][] angka= {{1,2,3}, 
                        {4,5,6},
                        {7,8,9}};
        Scanner a = new Scanner(System.in);

        String posisi = "";

        try {
            int target =a.nextInt();
            for (int i =0; i < angka.length; i++ ){
                for(int j =0; j< angka[i].length; j++)
                 if(angka[i][j] == target){
                    posisi = "Found "+ target +" at[" + i +"][" + j + "]";
                    break;
                 }
            }

                if (posisi.equals("")) {
                    System.out.println("Angka Tidak ditemukan.");
                } else {
                    System.out.println(posisi);
                }
        } catch (Exception e) {
            System.out.println("Input tidak valid.");

        } finally {
            a.close();
        }
    }   
}
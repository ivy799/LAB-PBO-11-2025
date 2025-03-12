package Prak1;
import java.util.Scanner;

public class Soal1Kapital {  
    static String input(String kalimat){
        String[] kata = kalimat.split(" ");
        StringBuilder kalimatKapital = new StringBuilder();
        
        for (String k : kata){
            if (k.length()> 0){
                var awal = Character.toUpperCase(k.charAt(0));
                var akhir = k.substring(1); 
                kalimatKapital.append(awal).append(akhir).append(" ");
            }  
        }
        return kalimatKapital.toString().trim();
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan Judul Film : ");
        var kalimat = input.nextLine();
        System.out.print(input(kalimat));
        input.close();
    }
}

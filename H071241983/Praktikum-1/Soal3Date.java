package Prak1;

import java.util.Scanner;

public class Soal3Date{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukan Tanggal :");
        String tanggal = input.nextLine();

        String[] hasilSplit = tanggal.split("-"); 
        String[] nama_bulan = {"Januari", "Februari", "Maret", "April", "Mei",
        "Juni", "July", "Agustust", "September", "Oktober", "November", "Desember"};
    
        int splitTanggal = Integer.parseInt(hasilSplit[0]);
        int splitBulan = Integer.parseInt(hasilSplit[1]);
        int splitTahun = Integer.parseInt(hasilSplit[2]);
        
        if ((splitTanggal < 1 || splitTanggal >31) || (splitBulan <1 ||splitBulan >12)){
            System.err.println("Tanggal tidak Valid");
            
        }else {
            System.out.println(splitTanggal+ " "+ nama_bulan[splitBulan-1] +" "+splitTahun);
            input.close();

        }

        
        
        
        
    }

        
}


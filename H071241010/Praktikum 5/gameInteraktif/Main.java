package gameInteraktif;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        Hero b = null;
        
        System.out.println("Pilih karakter: ");
        System.out.println("1. Archer\n2. Widzard\n3. Fighter");
        System.out.print("Masukkan pilihan: ");
        String a = x.nextLine(); 
        
        while(a != null){
        if (a.equals("1")){
             b = new Archer("Pemanah");
             break;
        } else if (a.equals("2")){
             b = new Wizard("Penyihir");
             break;
        } else if (a.equals("3")){
             b = new Fighter();
             break;
        }else{
            System.out.println("Pilihan tidak valid!!!");
            System.out.print("Masukkan pilihan yang benar: ");
            a = x.nextLine();
        }
    }
    
    String c;

        do {
            System.out.println("Menu: ");
            System.out.println("1. Serang\n2. Keluar");
            System.out.print("Masukkan pilihan: ");
            c = x.nextLine();

            if (c.equals("1")) {
                b.attack();
            } else if (c.equals("2")) {
                System.out.println("Game selesai");
            } else {
                System.out.println("Pilihan tidak valid!!!");
            }
        } while (!c.equals("2"));
    x.close();
    }
}

    

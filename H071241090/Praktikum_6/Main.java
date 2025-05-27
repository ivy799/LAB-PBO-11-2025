package Praktikum_6;

public class Main {
    public static void main(String[] args) {

    System.out.println("\n--- Pembuatan Mobil ---\n");
    
    Mobil mobil1 = new Mobil("Ferrari", "F40");
    mobil1.mulai();
    mobil1.setKecepatan(190);
    mobil1.getKecepatan();
    mobil1.berhenti();

    System.out.println();
    mobil1.periksaKondisi();
    mobil1.lakukanServis();

    System.out.println("\n--- Pembuatan Pesawat ---\n");
    Pesawat pesawat1 = new Pesawat("Boeing", "737");
    pesawat1.mulai();
    pesawat1.setKecepatan(250);
    pesawat1.getKecepatan();
    pesawat1.berhenti();

    System.out.println();
    pesawat1.setHarga(1000000);
    System.out.println("Pajak biaya pesawat " + pesawat1.hitungPajak());

    Motor motor1 = new Motor("Yamaha", "Mio");
    motor1.mulai();
    System.out.println(motor1.getKecepatan());
    
    }

    



}

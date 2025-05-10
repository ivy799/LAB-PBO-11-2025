import java.text.SimpleDateFormat;


public class Main {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");


        // ===================== Mobil =====================
        System.out.println("==== MOBIL ====");
        Mobil mobil = new Mobil("Toyota", "Avanza");
        mobil.setJumlahPintu(4);
        mobil.setKapasitasMesin(1500);

        mobil.mulai();
        mobil.setKecepatan(60);
        mobil.hitungPajak();
        mobil.periksaKondisi();
        mobil.lakukanServis();
        System.out.println("Servis berikutnya: " + sdf.format(mobil.getWaktuServisBerikutnya()));
        mobil.hitungBiayaServis();
        System.out.println();

        // ===================== Motor =====================
        System.out.println("==== MOTOR ====");
        Motor motor = new Motor("Honda", "CBR");
        motor.setJenisMotor("Sport");
        motor.setKapasitasTangki(12);
        motor.setTipeSuspensi("Upside-down");

        motor.mulai();
        motor.setKecepatan(80);
        motor.hitungPajak();
        motor.periksaKondisi();
        motor.lakukanServis();
        System.out.println("Servis berikutnya: " + sdf.format(motor.getWaktuServisBerikutnya()));
        motor.hitungBiayaServis();
        System.out.println();

        // ===================== Sepeda =====================
        System.out.println("==== SEPEDA ====");
        Sepeda sepeda = new Sepeda("Polygon", "Monarch");
        sepeda.setJenisSepeda("Gunung");
        sepeda.setJumlahGear(21);
        sepeda.setUkuranRoda(27);

        sepeda.mulai();
        sepeda.setKecepatan(25);
        sepeda.hitungPajak();
        sepeda.periksaKondisi();
        sepeda.lakukanServis();
        System.out.println("Servis berikutnya: " + sdf.format(sepeda.getWaktuServisBerikutnya()));
        sepeda.hitungBiayaServis();
        System.out.println();

        // ===================== Sepeda Listrik =====================
        System.out.println("==== SEPEDA LISTRIK ====");
        SepedaListrik sepedaListrik = new SepedaListrik("Xiaomi", "Himo C26");
        sepedaListrik.setKapasitasBaterai(480); // dalam Wh
        sepedaListrik.setDayaMotor(250); // dalam Watt
        sepedaListrik.isiBaterai();

        sepedaListrik.mulai();
        sepedaListrik.setKecepatan(32);
        sepedaListrik.hitungPajak();
        
        System.out.println();
    }
}

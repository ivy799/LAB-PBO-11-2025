public class Main {
    public static void main(String[] args) {
        Mobil mobil = new Mobil("Toyota", "Avanza");
        mobil.setJumlahPintu(4);
        mobil.setKapasitasMesin(1.5);
        mobil.setJumlahKursi(7);
        mobil.setBahanBakar("Bensin");
        mobil.setKecepatan(80);
        mobil.lakukanServis();

        Motor motor = new Motor("Honda", "Vario");
        motor.setJenisMotor("Skuter");
        motor.setKapasitasTangki(5);
        motor.setTipeSuspensi("Telescopic");
        motor.setKecepatan(60);
        motor.lakukanServis();

        Sepeda sepeda = new Sepeda("Polygon", "Premier 5");
        sepeda.setJenisSepeda("Gunung");
        sepeda.setJumlahGear(21);
        sepeda.setUkuranRoda(27);
        sepeda.setKecepatan(20);
        sepeda.lakukanServis();

        Kuda kuda = new Kuda("Thoroughbred", "Si Hitam");
        kuda.setKecepatan(40);
        kuda.setKelamin("Betina");
        kuda.setTahunProduksi(2020);
        kuda.setWarna("Hytam");

        System.out.println("=== DATA MOBIL ===");
        System.out.println("Tipe: " + mobil.getTipeKendaraan());
        System.out.println("Pajak: Rp" + mobil.hitungPajak());
        System.out.println("Kecepatan: " + mobil.getKecepatan() + " km/jam");
        System.out.println("Waktu servis berikutnya: " + mobil.getWaktuServisBerikutnya());
        System.out.println();

        System.out.println("=== DATA MOTOR ===");
        System.out.println("Tipe: " + motor.getTipeKendaraan());
        System.out.println("Pajak: Rp" + motor.hitungPajak());
        System.out.println("Kecepatan: " + motor.getKecepatan() + " km/jam");
        System.out.println("Waktu servis berikutnya: " + motor.getWaktuServisBerikutnya());
        System.out.println();

        System.out.println("=== DATA SEPEDA ===");
        System.out.println("Tipe: " + sepeda.getTipeKendaraan());
        System.out.println("Pajak: Rp" + sepeda.hitungPajak());
        System.out.println("Kecepatan: " + sepeda.getKecepatan() + " km/jam");
        System.out.println("Waktu servis berikutnya: " + sepeda.getWaktuServisBerikutnya());
        System.out.println();

        System.out.println("=== DATA KUDA ===");
        System.out.println("Tipe: " + kuda.getTipeKendaraan());
        System.out.println("Kelamin: Rp" + kuda.getKelamin());
        System.out.println("Kecepatan: " + kuda.getKecepatan() + " km/jam");
        System.out.println("Warna: " + kuda.getWarna());
        System.out.println();
    }
}

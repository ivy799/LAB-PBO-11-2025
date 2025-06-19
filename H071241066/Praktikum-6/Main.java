import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Mobil mobil = new Mobil("Toyota", "Land Cruiser");
        mobil.setKapasitasMesin(1.5);
        mobil.setJumlahPintu(4);
        mobil.setBahanBakar("Bensin");
        mobil.setKecepatan(100);
        mobil.setWarna("merah");
        mobil.setTahunProduksi(2020);

        Motor motor = new Motor("Honda", "CBR");
        motor.setKapasitasTangki(5);
        motor.setKecepatan(80);
        motor.setWarna("merah");
        motor.setTahunProduksi(2021);
        motor.setTipeSuspensi("suspensi belakang");

        Sepeda sepeda = new Sepeda("Polygon", "Premier 4");
        sepeda.setJumlahGear(21);
        sepeda.setKecepatan(25);
        sepeda.setWarna("hitam");
        sepeda.setUkuranRoda(26);
        sepeda.setTahunProduksi(2024);

        SepedaListrik SL = new SepedaListrik("Pacific", "Vertex");
        SL.setKapasitasMuatan(5);
        SL.setKecepatan(20);
        SL.setWarna("hitam");
        SL.setTahunProduksi(2025);

        System.out.println("");

        while (true) {
            System.out.println("\n ---Pilih Kendaraan---");
            System.out.println("1. Mobil");
            System.out.println("2. Motor");
            System.out.println("3. Sepeda");
            System.out.println("4. Sepeda Listrik");
            System.out.println("5. Keluar");
            System.out.print("Masukkan pilihan: ");
            int pilihan = sc.nextInt();

            Kendaraan kendaraan = null;
            if (pilihan == 1) {
                kendaraan = mobil;
            } else if (pilihan == 2) {
                kendaraan = motor;
            } else if (pilihan == 3) {
                kendaraan = sepeda;
            } else if (pilihan == 4) {
                kendaraan = SL;
            } else if (pilihan == 5) {
                System.out.println("Program selesai");
                sc.close();
                return;
            } else {
                System.out.println("Pilihan tidak tersedia.");
                continue;
            }

            System.out.println("\n--- Kendaraan: " + kendaraan.getTipeKendaraan() + "---");
            System.out.println("Merek: " + kendaraan.getMerek());
            System.out.println("Model: " + kendaraan.getModel());
            System.out.println("Warna: " + kendaraan.getWarna());
            System.out.println("Tahun Produksi: " + kendaraan.getTahunProduksi());

            System.out.println("Pilih aksi: ");
            System.out.println("1. Mulai");
            System.out.println("2. Berhenti");
            System.out.println("3. Cek pajak");
            System.out.println("4. Servis");
            System.out.print("Masukkan pilihan: ");
            int aksi = sc.nextInt();

            if (aksi == 1) {
                if (kendaraan instanceof IBergerak) {
                    ((IBergerak) kendaraan).mulai();
                    System.out.println("Kecepatan sekarang: " + ((IBergerak) kendaraan).getKecepatan() + "km/jam");
                } else {
                    System.out.println("Kendaraan tidak dapat bergerak.");
                }
            } else if (aksi == 2) {
                if (kendaraan instanceof IBergerak) {
                    ((IBergerak) kendaraan).berhenti();
                } else {
                    System.out.println("Kendaraan tidak dapat berhenti karena tidak bergerak.");
                }
            } else if (aksi == 3) {
                System.out.println("Pajak kendaraan: " + kendaraan.hitungPajak());
            } else if (aksi == 4) {
                if (kendaraan instanceof IServicable) {
                    System.out.println("Servis Kendaraan: ");
                    ((IServicable) kendaraan).lakukanServis();
                    System.out.println(
                            "Waktu Servis Berikutnya: " + ((IServicable) kendaraan).getWaktuServisBerikutnya());
                    System.out.println("Biaya Servis: Rp " + ((IServicable) kendaraan).hitungBiayaServis());
                } else {
                    System.out.println("Kendaraan tidak memerlukan servis rutin.");
                }
            } else {
                System.out.println("Pilihan tidak tersedia.");
            }
        }
    }
}

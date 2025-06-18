public class Main {
    public static void main(String[] args) {
        Mobil mobil = new Mobil("Toyota", "Avanza", 60);
        Motor motor = new Motor("Honda", "Scoopy", 80);
        Sepeda sepeda = new Sepeda("Sepeda", "BMX");
        Yacht yacht = new Yacht("Kapal", "Karam");
        sepeda.setKecepatan(15);
        yacht.setKecepatan(30);

        double a = mobil.getKecepatan();
        double b = motor.getKecepatan();
        double c = sepeda.getKecepatan();
        double d = yacht.getKecepatan();

        if (a > b) {
            System.out.println("Mobil Lebih cepat dari Motor");
        } else {
            System.out.println("motor lebih cepat");
        }

        if (c > d) {
            System.out.println("Sepeda Lebih cepat dari kapal");
        } else {
            System.out.println("Yacht lebih kencang");
        }
    }

}
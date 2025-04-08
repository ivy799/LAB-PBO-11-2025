class Cuboid {
    double height;
    double width;
    double length;

    double getVolume() {
        return height * width * length;
    }
}

public class TP2_3_H071241010 {
    public static void main(String[] args) {
        Cuboid cuboid = new Cuboid();

        cuboid.height = 10.0;
        cuboid.width = 15.0;
        cuboid.length = 30.0;


        System.out.printf("Volume = %.2f%n", cuboid.getVolume());
    }
}
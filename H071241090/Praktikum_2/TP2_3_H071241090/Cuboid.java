package Praktikum_2.TP2_3_H071241090;

public class Cuboid {
    double height;
    double width;
    double length;

    double getVolume() {
        return height*width*length;
    }

    public static void main(String[] args) {
        Cuboid kubus = new Cuboid();

        kubus.height = 10;
        kubus.width = 5;
        kubus.length = 90;

        System.out.printf("Volume = %.2f", kubus.getVolume());

    }

}

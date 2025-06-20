package Tugas.Lab_pekan_2;

public class Cuboid {
    double height;
    double widht;
    double length;

    double getVolume(){
        return height * widht * length;
    }

    public static void main(String[] args) {
        Cuboid cuboid = new Cuboid();
        cuboid.height = 10;
        cuboid.widht = 15;
        cuboid.length = 30;
        System.out.println(String.format("Volume = %2.2f", cuboid.getVolume()));
    }
}
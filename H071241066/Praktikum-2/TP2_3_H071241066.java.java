class Cuboid {
    double height;
    double width;
    double length;

    double getVolume() {
        return height * width *length;
    }
}

public class Main {
    public static void main(String[] args) {
        Cuboid cuboid = new Cuboid();
        cuboid.height = 5;
        cuboid.length = 10;
        cuboid.width = 2;


        System.out.println(String.format("Volume = %.2f", cuboid.getVolume()));
    }
}

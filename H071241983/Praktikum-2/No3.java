class Cuboid {
    double height;
    double width;
    double length;

    double getVolume() {
        return height * width * length;
    }
}

public class No3 {
    public static void main(String[] args) {
        Cuboid cuboid = new Cuboid();

        cuboid.height = 10;
        cuboid.width = 15;
        cuboid.length = 30;

        System.out.printf("Volume == %.2f", cuboid.getVolume());
    }
}

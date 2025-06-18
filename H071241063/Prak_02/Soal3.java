class Cuboid{
    double height;
    double width;
    double length;

    double getVolume(){
        return height*width*length;
    }
}

public class Soal3 {
    public static void main(String[] args) {
        Cuboid cuboid1 = new Cuboid();
        cuboid1.height = 30;
        cuboid1.width = 15;
        cuboid1.length = 10;
        System.out.printf("Volume = %.2f%n", cuboid1.getVolume());

    }
}

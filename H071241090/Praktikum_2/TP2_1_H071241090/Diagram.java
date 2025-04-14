package Praktikum_2.TP2_1_H071241090;

public class Diagram{
    String nama;
    int umur;
    boolean isMale;

    public void setName (String setName) {
        nama = setName;
    }

    public void getName () {
        System.out.println("Nama: " + nama);
    }

    public void setAge (int setAge) {
        umur = setAge;
    }

    public void getAge () {
        System.out.println("Umur: " + umur);
    }

    public void setGender (boolean setGender) {
        isMale = setGender;
    }

    public void getGender () {
        if (isMale) {
            System.out.println("Jenis Kelamin: Laki-laki");
        } else {
            System.out.println("Jenis Kelamin: Perempuan");
        }
    }

    public static void main(String[] args) {
        Diagram user1 = new Diagram();

        user1.setName("Fera");
        user1.setAge(18);
        user1.setGender(false);

        user1.getName();
        user1.getAge();
        user1.getGender();
    }
}
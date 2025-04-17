package Praktikum_2;

public class Livecoding1 {
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
        isMale = setGender; }

    public void getGender () {
        if (isMale) {
            System.out.println("Jenis Kelamin : Laki-laki");
        } else {
            System.out.println("Jenis Kelamin : Perempuan");
        }
    }

    public static void main(String[] args) {
        Livecoding1 siswa1 = new Livecoding1();
        siswa1.setName("fera");
        siswa1.setAge(19);
        siswa1.setGender(false);

        siswa1.getName();
        siswa1.getAge();
        siswa1.getGender();
    }
}




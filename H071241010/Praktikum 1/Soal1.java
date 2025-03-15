import java.util.Scanner;

class Kapitalisasi{
    public static String kapitalisasiHurufPertama(String input) {
        String[] kata = input.split(" ");
        StringBuilder kalimatKapital = new StringBuilder();

        for (String word:kata){
            if (word.length() > 0) {
                kalimatKapital.append(Character.toUpperCase(word.charAt(0)))
                              .append(word.substring(1))
                              .append(" ");                             
        }
}
return kalimatKapital.toString().trim();
}
}


public class Soal1{
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        System.out.print("Masukkan nama film= ");
        String namaFilm = x.nextLine();

        String hasil = Kapitalisasi.kapitalisasiHurufPertama(namaFilm);
        System.out.println("Hasil: " + hasil);

        x.close();
}
}

import java.util.Scanner;

public class TP1_1_H071241090 {

    public static String capitalizeWords(String x) {
        String[] kalimat = x.toLowerCase().split(" ");
        StringBuilder result = new StringBuilder();

        for (String kata : kalimat ) {
            if (!kata.isEmpty()) {
                result.append(Character.toUpperCase(kata.charAt(0)))
                .append(kata.substring(1))
                .append(" ");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan teks: \n> ");
        String kalimat = scanner.nextLine();

        String hasil = capitalizeWords(kalimat);
        System.out.println(hasil);
        scanner.close();
    }
}
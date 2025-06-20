import java.util.Scanner;//Menghitung faktorial dari sebuah bilangan yang dimasukkan oleh pengguna

public class question4 {
    public static int faktorial(int n) {// menghitung n!
        if (n == 0 || n == 1) {// Kasus dasar: jika n adalah 0 atau 1, kembalikan 1
            return 1;
        }
        return n * faktorial(n - 1);// Kasus rekursif: n! = n * (n-1)
    }
    
    // Metode main, eksekusi program dimulai dari sini
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan bilangan: ");
        int n = input.nextInt();

        input.close();
        System.out.println(faktorial(n));//Menghitung  n dan mencetak hasilnya
    }
}
import java.util.Scanner;

public class Soal4 {
    public static long faktorial(int n){
        if ( n == 0 || n == 1){
            return 1L;
        } else {}
            return n * faktorial(n - 1);
    }
    
    public  static void main(String[] args) {
      Scanner x = new Scanner(System.in);
    try{
        System.out.print("Masukkan Bilangan = ");
        int n = x.nextInt();

        if (n < 0) {
            throw new IllegalArgumentException("Input tidak boleh negatif.");
        }
    
        long hasil = faktorial(n);
        System.out.println("Faktorial dari " + n + " = " + hasil);
    }catch (IllegalArgumentException e) {
        System.out.println("Error: " + e.getMessage());
    } catch (Exception e) {
        System.out.println("Error: Input tidak valid. Harap masukkan angka bulat.");
    } finally {
        x.close();
    }
   
}
}

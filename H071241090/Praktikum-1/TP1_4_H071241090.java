import java.util.Scanner;

public class TP1_4_H071241090 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan angka : ");
        int input = scanner.nextInt();
        System.out.print("Hasil faktorial : " + factorial(input));

        scanner.close();
    }
    public static int factorial(int n){
        if ( n==0 || n==1 ){
            return 1;
        }
        else { 
            return n * factorial(n-1);
        }
    }
}

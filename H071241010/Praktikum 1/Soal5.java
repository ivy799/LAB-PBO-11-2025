import java.util.Scanner;

public class Soal5 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);

        System.out.print("Masukkan Password = ");
        String password = x.nextLine();

        if (isValid(password)) {
            System.out.println("Output: Password valid");
        } else {
            System.out.println("Output: Password tidak valid");
        }
        x.close();
    }

    public static boolean isValid(String password) {
        if (password.length() < 8){
            return false;
        }

        boolean upperCases = false;
        boolean lowerCases = false;
        boolean digit = false;

        for (char c : password.toCharArray()){
            if (Character.isUpperCase(c)){
                upperCases = true;
            }else if(Character.isLowerCase(c)){
                lowerCases = true;
            }else if (Character.isDigit(c)){
                digit = true;
        }
    }
    return upperCases && lowerCases && digit;   
}
}
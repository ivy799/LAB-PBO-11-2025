package Praktikum_4.TP_1_H071241090;


import java.util.ArrayList;
import java.util.Scanner;
import Praktikum_4.TP_1_H071241090.models.Profile;
import Praktikum_4.TP_1_H071241090.models.User;
import Praktikum_4.TP_1_H071241090.utils.StringUtils;

public class Main {
    private static ArrayList<User> listUser = new ArrayList<>();
    private static ArrayList<Profile> listUserProfile = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Memanggil method runApp();
        runApp();
    }

    private static void runApp() {
        // Menu Utama Aplikasi
        System.out.println("-------------------------");
        System.out.println("Aplikasi Login Sederhana");
        System.out.println("-------------------------");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Update User");
        System.out.print("> ");

        // Menginput pilihan menu
        int selectMenu = getIntInput();

        switch (selectMenu) {
            case 1:
                // Membuka Halaman Login
                showLoginMenu();
                break;
            case 2:
                // Membuka Halaman Register
                showRegisterMenu();
                break;
            case 3:
                showUpdateAccountMenu();
                break;
            default:
                // Mengulang Pemanggilan Menu Utama
                System.out.println("Menu tidak tersedia. Silakan pilih ulang.");
                runApp();
        }
    }

    private static void showLoginMenu() {
        // Halaman Login
        System.out.println("-------------------------");
        System.out.println("Login");

        while (true) {
            System.out.println("Masukkan Username");
            System.out.print("> ");
            String username = sc.nextLine();
    
            int userIndex = -1;
            for (int i = 0; i < listUser.size(); i++) {
                if (listUser.get(i).getUsername().equals(username)) {
                    userIndex = i;
                    break;
                }
            }
    
            if (userIndex == -1) {
                System.out.println("Username tidak ditemukan. Coba lagi.");
                continue; 
            }
        
        while (true){
            System.out.println("Password");
            System.out.print("> ");
            String password = sc.nextLine();
    
            boolean isPasswordMatch = listUser.get(userIndex).getPassword().equals(password);
    
        
            if (isPasswordMatch) {
                System.out.println("Berhasil Login");
                showDetailUser(listUser.get(userIndex).getProfile());
                System.exit(0);
            } else {
                System.out.println("Password salah. Coba lagi.");
            }
            }
        }
    }
    
    private static void showRegisterMenu() {
        System.out.println("-------------------------");
        System.out.println("REGISTER");

        String username;
        while (true) {
            System.out.println("Username");
            System.out.print("> ");
            username = sc.nextLine();
            if (username.isEmpty()) {
                System.out.println("Username tidak boleh kosong!");
            } else if (isUsernameTaken(username)) {
                System.out.println("Username sudah digunakan!");
            } else {
                break;
            }
        }

        String password;
        while (true) {
            System.out.println("Password");
            System.out.print("> ");
            password = sc.nextLine();
            if (password.isEmpty()) {
                System.out.println("Password tidak boleh kosong!");
            } else if (password.length() < 8) {
                System.out.println("Password harus minimal 8 karakter!");
            } else {
                break;
            }
        }

        User user = new User(username, password);
        Profile profile = new Profile();

        System.out.println("Nama Lengkap");
        System.out.print("> ");
        String fullName = sc.nextLine();
        while (fullName.isEmpty()) {
            System.out.println("Nama Lengkap tidak boleh kosong!");
            System.out.print("> ");
            fullName = sc.nextLine();
        }

        System.out.println("Umur");
        System.out.print("> ");
        int age = getIntInput();

        System.out.println("Hobby");
        System.out.print("> ");
        String hobby = sc.nextLine();
        while (hobby.isEmpty()) {
            System.out.println("Hobby tidak boleh kosong!");
            System.out.print("> ");
            hobby = sc.nextLine();
        }

        profile.setFullName(fullName);
        profile.setAge(age);
        profile.setHobby(hobby);
        profile.setNickname(StringUtils.getNickName(fullName));

        user.setProfile(profile);
        listUser.add(user);
        listUserProfile.add(profile);

        System.out.println("-------------------------");
        System.out.println("Berhasil Membuat User Baru!!");
        runApp();
    }

    private static void showDetailUser(Profile profile) {
        System.out.println("-------------------------");
        System.out.println("Profil Pengguna");
        System.out.println("Nama Lengkap: " + profile.getFullName());
        System.out.println("Nickname: " + profile.getNickname());
        System.out.println("Umur: " + profile.getAge());
        System.out.println("Hobi: " + profile.getHobby());
    
    }

    private static boolean isUsernameTaken(String username) {
        for (User user : listUser) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    private static int getIntInput() {
        while (true) {
            try {
                int input = Integer.parseInt(sc.nextLine());
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka! Coba lagi.");
                System.out.print("> ");
            }
        }
    }

    private static void showUpdateAccountMenu() {
        System.out.println("-------------------------");
        System.out.println("UPDATE USER");
        System.out.println("-------------------------");

    
        System.out.println("Masukkan Username");
        System.out.print("> ");
        String username = sc.nextLine();
    
        int userIndex = -1;
        for (int i = 0; i < listUser.size(); i++) {
            if (listUser.get(i).getUsername().equals(username)) {
                userIndex = i;
                break;
            }
        }
    
        if (userIndex == -1) {
            System.out.println("Username tidak ditemukan.");
            runApp();
            return;
        }
    
        System.out.println("Masukkan Password Lama");
        System.out.print("> ");
        String oldPassword = sc.nextLine();
    
        while (!listUser.get(userIndex).getPassword().equals(oldPassword)) {
            System.out.println("Password salah. Coba lagi.");
            System.out.print("> ");
            oldPassword = sc.nextLine();
        }
        
        System.out.println("\n-------------------------");

        System.out.println("1. Ubah Username");
        System.out.println("2. Ubah Password");
        System.out.print("> ");
        int choice = getIntInput();
    
        switch (choice) {
            case 1:
                System.out.println("Masukkan Username Baru");
                System.out.print("> ");
                String newUsername = sc.nextLine();
    
                if (isUsernameTaken(newUsername)) {
                    System.out.println("Username sudah digunakan!");
                } else {
                    listUser.get(userIndex).setUsername(newUsername);
                    System.out.println("Username berhasil diubah.");
                }
                break;
    
            case 2:
                System.out.println("Masukkan Password Baru");
                System.out.print("> ");
                String newPassword = sc.nextLine();
    
                if (newPassword.length() < 8) {
                    System.out.println("Password harus minimal 8 karakter!");
                } else {
                    listUser.get(userIndex).setPassword(newPassword);
                    System.out.println("Password berhasil diubah.");
                }
                break;
    
            default:
                System.out.println("Pilihan tidak tersedia.");
        }
    
        runApp();
    }
    

}


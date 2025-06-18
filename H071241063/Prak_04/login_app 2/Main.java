package login_app;

import java.util.ArrayList;
import java.util.Scanner;
import login_app.models.Profile;
import login_app.models.User;
import login_app.utils.StringUtils;

public class Main {
    private static ArrayList<User> listUser = new ArrayList<>(); 
    private static ArrayList<Profile> listUserProfile = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        runApp();
    }

    private static void runApp() {
        System.out.println("-------------------------");
        System.out.println("Aplikasi Login Sederhana");
        System.out.println("-------------------------");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.print("> ");

        int selectMenu = sc.nextInt();
        sc.nextLine();
        switch (selectMenu) {
            case 1:
                showLoginMenu();
                break;
            case 2:
                showRegisterMenu();
            default:12
                runApp();
        }
    }

    private static void showLoginMenu() {
        System.out.println("-------------------------");
        System.out.println("Login");

        String username;
        boolean isValidUsername = false;
        do {
            System.out.println("Masukkan Username");
            System.out.print("> ");
            username = sc.nextLine();

            if (username.isEmpty()) {
                System.out.println("Username tidak boleh kosong.");
            } else {
                int userIndex = -1;
                for (int i = 0; i < listUser.size(); i++) {
                    /*
                     * TODO
                     * Buatlah sebuah perkondisian (IF) yang akan
                     * Mengecek apakah user index ke i dari listUser memiliki username yang sama
                     * dengan username yang
                     * diinput.
                     * Jika ada ganti userIndex dengan Index dari User Tersebut, kemudian hentikan
                     * perulangan
                     */
                    if (listUser.get(i).getUsername().equals(username)) {
                        userIndex = i;
                        break;
                    }
                }

                if (userIndex != -1) {
                    isValidUsername = true;
                    String password;
                    boolean isValidPassword = false;
                    do {
                        System.out.println("Password");
                        System.out.print("> ");
                        password = sc.nextLine();

                        if (password.isEmpty()) {
                            System.out.println("Password tidak boleh kosong.");
                        } else {
                            /*
                             * TODO
                             * Mengecek apakah password dari User yang login berdasarkan username
                             * sama dengan password yang diinput sebelumnya, kemudian simpan
                             * hasilnya di variabel isPasswordMatch
                             */
                            boolean isPasswordMatch = listUser.get(userIndex).getPassword().equals(password);

                            if (isPasswordMatch) {
                                System.out.println("Berhasil Login");
                                /*
                                 * TODO
                                 * panggil method showDetailUser dan kirimkan data Profile User yang login
                                 * 
                                 */
                                showDetailUser(listUserProfile.get(userIndex));
                                isValidPassword = true;
                            } else {
                                System.out.println("Password Salah");
                            }
                        }
                    } while (!isValidPassword);
                } else {
                    System.out.println("Username tidak ditemukan.");
                }
            }
        } while (!isValidUsername);
    }

    private static void showRegisterMenu() {
        System.out.println("-------------------------");
        System.out.println("REGISTER");

        String username;
        do {
            System.out.println("Username");
            System.out.print("> ");
            username = sc.nextLine();

            if (username.isEmpty()) {
                System.out.println("Username tidak boleh kosong.");
                continue;
            }

            boolean usernameExists = false;
            for (User u : listUser) {
                if (u.getUsername().equals(username)) {
                    usernameExists = true;
                    break;
                }
            }
            if (usernameExists) {
                System.out.println("Username sudah digunakan, coba yang lain.");
                username = "";
            }
        } while (username.isEmpty());

        String password;
        do {
            System.out.println("Password (minimal 8 karakter)");
            System.out.print("> ");
            password = sc.nextLine();
            if (password.length() < 8) {
                System.out.println("Password harus minimal 8 karakter.");
            } else if (password.isEmpty()) {
                System.out.println("Password tidak boleh kosong.");
            }
        } while (password.length() < 8 || password.isEmpty());
        /*
         * TODO
         * Buatlah atau Instance objek User baru, dan tambahkan
         * username dan password yang diinput sebelumnya secara langsung
         * saat instance User
         */
        User user = new User(username, password);
        /*
         * TODO
         * Buatlah atau Instance objek Profile baru
         */
        Profile profile = new Profile();

        String fullName;
        do {
            System.out.println("Nama Lengkap");
            System.out.print("> ");
            fullName = sc.nextLine();
            if (fullName.isEmpty()) {
                System.out.println("Nama lengkap tidak boleh kosong.");
            }
        } while (fullName.isEmpty());

        int age = 0;
        boolean validAge = false;
        do {
            System.out.println("Umur");
            System.out.print("> ");
            String ageInput = sc.nextLine();
            try {
                age = Integer.parseInt(ageInput);
                if (age <= 0) {
                    System.out.println("Umur harus lebih dari 0.");
                } else {
                    validAge = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka yang valid.");
            }
        } while (!validAge);

        String hobby;
        do {
            System.out.println("Hobby");
            System.out.print("> ");
            hobby = sc.nextLine();
            if (hobby.isEmpty()) {
                System.out.println("Hobby tidak boleh kosong.");
            }
        } while (hobby.isEmpty());

        /*
         * TODO
         * Berikan nilai fullName, age, dan hobby ke objek profile yang telah
         * di Instance sebelumnya. Nilai ini diperoleh dari data profile yang
         * diinput sebelumnya
         */
        profile.setFullName(fullName);
        profile.setAge(age);
        profile.setHobby(hobby);

        /*
         * TODO
         * Berikan nilai nickName ke objek profile,
         * Nilai ini diperoleh menggunakan static method yang dibuat di class
         * StringUtils, dengan mengirimkan fullName yang diinput sebelumnya
         */
        profile.setNickName(StringUtils.generateNickName(fullName));

        listUser.add(user);
        listUserProfile.add(profile);
        System.out.println("-------------------------");
        System.out.println("Berhasil Membuat User Baru!!");
        runApp();
    }

    private static void showDetailUser(Profile profile) {
        System.out.println("-------------------------");
        System.out.println("Detail User");
        System.out.println("-------------------------");
        System.out.println("Nama Lengkap : " + profile.getFullName());
        System.out.println("NickName : " + profile.getNickName());
        System.out.println("Umur : " + profile.getAge());
        System.out.println("Hobby : " + profile.getHobby());
    }
}
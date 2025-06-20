import java.util.ArrayList;
import java.util.Scanner;
import models.Profile;
import models.User;
import utils.StringUtils;

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
        System.out.print("> ");

        // Menginput pilihan menu
        int selectMenu = sc.nextInt();
        sc.nextLine();
        switch (selectMenu) {
            case 1:
                // Membuka Halaman Login
                showLoginMenu();
                break;
            case 2:
                // Membuka Halaman Register
                showRegisterMenu();
            default:
                // Mengulang Pemanggilan Menu Utama
                runApp();
        }
    }

    private static void showLoginMenu() {
        // Halaman Login
        System.out.println("-------------------------");
        System.out.println("Login");
        // Menginput Username dan Menyimpannya di attribute username;
        System.out.println("Masukkan Username");
        System.out.print("> ");

        String username = sc.next();

        while (username.isEmpty()) {
            System.out.println("ERROR: Tolong Ketik Username");
            System.out.print("> ");
            username = sc.next();
        }

        // Membuat variabel userIndex yang mana nanti akan menampung index dari user
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
            if (listUser.get(i).username.equals(username)) {
                userIndex = i;
                break;
            }
        }
        // Saat userIndex tidak sama dengan -1 atau userIndexnya ditemukan
        if (userIndex != -1) {
            // Menginput Password
            System.out.println("Password");
            System.out.print("> ");
            String password = sc.next();

            while (password.length() < 8) {
                System.out.println("ERROR: Password Kurang Dari 8 Karakter");
                System.out.print("> ");
                password = sc.next();
            }

            /*
             * TODO
             * Mengecek apakah password dari User yang login berdasarkan username
             * sama dengan password yang diinput sebelumnya, kemudian simpan
             * hasilnya di variabel isPasswordMatch
             */
            Boolean isPasswordMatch = listUser.get(userIndex).getPassword().equals(password);

            // Jika passwordnya sama maka berhasil login
            if (isPasswordMatch) {
                System.out.println("Berhasil Login");
                /*
                 * TODO
                 * panggil method showDetailUser dan kirimkan data Profile User yang login
                 * 8
                 */
                showDetailUser(listUserProfile.get(userIndex));

                System.exit(0);
            } else {
                // saat password salah akan menampikan password salah
                System.out.println("Password Salah");
            }
        } else {
            System.out.println("Username salah");
            return;
        }
    }

    private static boolean usernameTerpakai(String username) {
        for (User user : listUser) {
            if (user.username.equals(username)) {
                return true;
            }
        }
        return false;
    }

    private static boolean passwordTerpakai(String password) {
        for (User user : listUser) {
            if (user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    private static void showRegisterMenu() {
        System.out.println("-------------------------");
        System.out.println("REGISTER");

        // Menginput username dan password
        System.out.println("Username");
        System.out.print("> ");
        String username = sc.nextLine();

        while (username.isEmpty() || usernameTerpakai(username)) {
            if (username.isEmpty()) {
                System.out.println("ERROR: Tolong Ketik Username");
            }

            if (usernameTerpakai(username)) {
                System.out.println("ERROR: Password Tidak Tersedia");

                System.out.println("Ketik Ulang Username");
            }

            System.out.print("> ");
            username = sc.nextLine();
        }

        System.out.println("Password");
        System.out.print("> ");
        String password = sc.nextLine();

        while (password.length() < 8 || passwordTerpakai(password)) {
            if (password.length() < 8) {
                System.out.println("ERROR: Password Kurang Dari 8 Karakter");
            }

            if (passwordTerpakai(password)) {
                System.out.println("ERROR: Password Tidak Tersedia");
                System.out.println("Ketik Ulang Password");
            }

            System.out.print("> ");
            password = sc.nextLine();
        }

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

        // Menginput Data Profile
        System.out.println("Nama Lengkap");
        System.out.print("> ");
        String fullName = sc.nextLine();
        while (fullName.isEmpty()) {
            System.out.println("ERROR: Tolong Ketik Nama Lengkap");

            System.out.print("> ");
            fullName = sc.nextLine();
        }
        System.out.println("Umur");
        System.out.print("> ");
        int age = 0;

        try {
            age = sc.nextInt();
        } catch (Exception e) {
            System.out.println("ERROR: Umur Tidak Valid");
            System.exit(0);
        }

        sc.nextLine();
        System.out.println("Hobby");
        System.out.print("> ");
        String hobby = sc.nextLine();
        while (hobby.isEmpty()) {
            System.out.println("ERROR: Tolong Ketik Hobby");
            System.out.print("> ");
            hobby = sc.nextLine();
        }
        /*
         * TODO
         * Berikan nilai fullName, age, dan hobby ke objek profile yang telah
         * di Instance sebelumnya. Nilai ini diperoleh dari data profile yang
         * diinput sebelumnya
         */
        profile.fullName = fullName;
        profile.age = age;
        profile.hobby = hobby;

        /*
         * TODO
         * Berikan nilai nickName ke objek profile,
         * Nilai ini diperoleh menggunakan static method yang dibuat di class
         * StringUtils, dengan mengirimkan fullName yang diinput sebelumnya
         */
        profile.nickname = StringUtils.getNickName(fullName);

        // Menambahkan user yang dibuat ke list user
        listUser.add(user);
        // Menambahkan profile user yang dibuat ke list profile
        listUserProfile.add(profile);
        System.out.println("-------------------------");
        System.out.println("Berhasil Membuat User Baru!!");
        runApp();
    }

    private static void showDetailUser(Profile profile) {
        /*
         * TODO *
         * Tampilkan semua data profile user yang login
         */
        System.out.println("==================");
        System.out.println("SELAMAT DATANG !!");
        System.out.println("==================");
        System.out.println("Nama Lengkap : " + profile.fullName);
        System.out.println("Nama Panggilan : " + profile.nickname);
        System.out.println("Umur : " + profile.age);
        System.out.println("Hobby : " + profile.hobby);
    }
}

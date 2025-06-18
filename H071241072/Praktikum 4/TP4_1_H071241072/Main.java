import java.util.ArrayList;
import java.util.Scanner;
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
        System.out.println("3. Keluar");
        System.out.print("> ");

        // Menginput pilihan menu
        int selectMenu;
        try {
            selectMenu = sc.nextInt();
            sc.nextLine();
        } catch (Exception e) {
            // FITUR 1: Input ulang saat input tidak tepat
            System.out.println("Input tidak valid. Silakan masukkan angka 1 atau 2.");
            sc.nextLine(); // Clear scanner
            runApp();
            return;
        }
        
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
                // Keluar
                System.out.println("Anda keluar dari program.");
                break;
            default:
                // Mengulang Pemanggilan Menu Utama
                System.out.println("Menu tidak tersedia. Silakan pilih menu yang ada.");
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
        // Membuat variabel userIndex yang mana nanti akan menampung index dari user
        int userIndex = -1;
        for (int i = 0; i < listUser.size(); i++) {
            /* Buatlah sebuah perkondisian (IF) yang akan
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
        
        // Saat userIndex tidak sama dengan -1 atau userIndexnya ditemukan
        if (userIndex != -1) {
            // Menginput Password
            System.out.println("Password");
            System.out.print("> ");
            String password = sc.next();

            /* Mengecek apakah password dari User yang login berdasarkan username
             * sama dengan password yang diinput sebelumnya, kemudian simpan
             * hasilnya di variabel isPasswordMatch
             */
            boolean isPasswordMatch = listUser.get(userIndex).isPasswordMatch(password);

            // Jika passwordnya sama maka berhasil login
            if (isPasswordMatch) {
                System.out.println("Berhasil Login");
                /* panggil method showDetailUser dan kirimkan data Profile User yang login
                 * 
                 */
                showDetailUser(listUserProfile.get(userIndex));
                System.exit(0);
            } else {
                // saat password salah akan menampikan password salah
                System.out.println("Password Salah");
                // FITUR 1: Input ulang saat input tidak tepat
                showLoginMenu();
            }
        } else {
            // FITUR 1: Input ulang saat username tidak ditemukan
            System.out.println("Username tidak ditemukan");
            runApp();
        }
    }

    private static void showRegisterMenu() {
        System.out.println("-------------------------");
        System.out.println("REGISTER");

        // Menginput username dan password
        System.out.println("Username");
        System.out.print("> ");
        String username = sc.nextLine();
        
        // FITUR 2: Cek jika field kosong
        if (username.trim().isEmpty()) {
            System.out.println("Username tidak boleh kosong");
            showRegisterMenu();
            return;
        }
        
        // FITUR 3: Cek username sudah digunakan
        for (User existingUser : listUser) {
            if (existingUser.getUsername().equals(username)) {
                System.out.println("Username sudah digunakan. Silakan gunakan username lain.");
                showRegisterMenu();
                return;
            }
        }
        
        System.out.println("Password");
        System.out.print("> ");
        String password = sc.nextLine();
        
        // FITUR 2: Cek jika field kosong
        if (password.trim().isEmpty()) {
            System.out.println("Password tidak boleh kosong");
            showRegisterMenu();
            return;
        }
        
        // FITUR 4: Cek panjang password
        if (password.length() < 8) {
            System.out.println("Password minimal 8 karakter");
            showRegisterMenu();
            return;
        }
        
        /* Buatlah atau Instance objek User baru, dan tambahkan
         * username dan password yang diinput sebelumnya secara langsung
         * saat instance User
         */
        User user = new User(username, password);

        /* Buatlah atau Instance objek Profile baru
         */
        Profile profile = new Profile();

        // Menginput Data Profile
        System.out.println("Nama Lengkap");
        System.out.print("> ");
        String fullName = sc.nextLine();
        
        // FITUR 2: Cek jika field kosong
        if (fullName.trim().isEmpty()) {
            System.out.println("Nama Lengkap tidak boleh kosong");
            showRegisterMenu();
            return;
        }
        
        System.out.println("Umur");
        System.out.print("> ");
        int age;
        try {
            age = sc.nextInt();
            sc.nextLine();
            
            // FITUR 5: Validasi umur
            if (age <= 0) {
                System.out.println("Umur harus lebih dari 0");
                sc.nextLine(); // clear scanner
                showRegisterMenu();
                return;
            }
        } catch (Exception e) {
            System.out.println("Input umur tidak valid. Silakan masukkan angka.");
            sc.nextLine(); // clear scanner
            showRegisterMenu();
            return;
        }
        
        System.out.println("Hobby");
        System.out.print("> ");
        String hobby = sc.nextLine();
        
        // FITUR 2: Cek jika field kosong
        if (hobby.trim().isEmpty()) {
            System.out.println("Hobby tidak boleh kosong");
            showRegisterMenu();
            return;
        }

        /* Berikan nilai fullName, age, dan hobby ke objek profile yang telah
         * di Instance sebelumnya. Nilai ini diperoleh dari data profile yang
         * diinput sebelumnya
         */
        profile.setFullName(fullName);
        profile.setAge(age);
        profile.setHobby(hobby);

        /* Berikan nilai nickName ke objek profile,
         * Nilai ini diperoleh menggunakan static method yang dibuat di class
         * StringUtils, dengan mengirimkan fullName yang diinput sebelumnya
         */
        profile.setNickName(StringUtils.getNickName(fullName));

        // Menambahkan user yang dibuat ke list user
        listUser.add(user);
        // Menambahkan profile user yang dibuat ke list profile
        listUserProfile.add(profile);
        System.out.println("-------------------------");
        System.out.println("Berhasil Membuat User Baru!!");
        runApp();
    }

    private static void showDetailUser(Profile profile) {
        /* Tampilkan semua data profile user yang login
         */
        System.out.println("-------------------------");
        System.out.println("Detail User:");
        System.out.println("Nama Lengkap: " + profile.getFullName());
        System.out.println("Nama Panggilan: " + profile.getNickName());
        System.out.println("Umur: " + profile.getAge());
        System.out.println("Hobby: " + profile.getHobby());
        System.out.println("-------------------------");
    }
}
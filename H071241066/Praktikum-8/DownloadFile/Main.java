//package DownloadFile;

//package DownloadFile;
import java.util.*;
import java.util.concurrent.*;

public class Main {

    static int successfulDownloads = 0;
    static int completedDownloads = 0;
    static int totalFiles;
    static volatile boolean allDone = false;
    static ArrayList<Result> results = new ArrayList<>();

    // (1)
    // Lengkapi method untuk merekam hasil download file sesuai dengan poin-poin
    // berikut:
    // - Setiap kali method dipanggil, total file yang selesai didownload akan
    // bertambah
    // - Tentukan status download berdasarkan durasi proses download
    // (durasi ≤ 2 detik maka "Success", selain itu "Timeout")
    // - Jika status "Success", file yang berhasil didownload akan bertambah
    // - Buat objek Result dan tambahkan ke list results untuk menyimpan hasil
    // setiap proses
    public static synchronized void recordResult(int fileId, int duration, String threadName) {
        String status = duration <= 2 ? "Success" : "Timeout";
        if (status.equals("Success")) {
            successfulDownloads++;
        }
        results.add(new Result(fileId, threadName, duration, status));
    }

    public static void main(String[] args) {

        try (// (2) Input jumlah file
             // Gunakan Scanner untuk meminta input jumlah file yang akan diunduh dari
             // pengguna
                Scanner scanner = new Scanner(System.in)) {
            System.out.print("Masukkan jumlah file yang akan di-download: ");
            totalFiles = scanner.nextInt();
        }
        // (3) Executor untuk download dan UI
        // Siapkan dua executor service dengan fungsi sebagai berikut:
        // - Satu dengan 3 thread untuk menangani proses download secara paralel
        // (downloadExecutor)
        // - Satu lagi dengan 1 thread untuk menampilkan proses download ke terminal
        // (uiExecutor)
        ExecutorService downloadExecutor = Executors.newFixedThreadPool(3);
        ExecutorService uiExecutor = Executors.newSingleThreadExecutor();

        // Mencatat waktu mulai
        long startTime = System.currentTimeMillis();

        // (4) Tampilkan progress setiap detik
        // Buat tugas yang dijalankan oleh uiExecutor untuk menampilkan proses download:
        // - Tampilkan pesan ke terminal setiap detik sebagai indikator progres,
        // dengan format -> Downloading files... ({time}s)
        // - Hentikan ketika semua file selesai diunduh
        uiExecutor.submit(() -> {
            int time = 1;
            while (!allDone) {
                try {
                    System.out.printf("Downloading files... (%ds)%n", time);
                    Thread.sleep(1000);
                    time++;
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
            System.out.println("Downloading Complete!");
        });

        // (5) Submit task download ke thread pool
        // Buat dan jalankan tugas download untuk setiap file menggunakan
        // downloadExecutor:
        // - Simulasikan proses download dengan jeda waktu acak (random 1-3 detik)
        // - Setelah selesai, catat hasilnya dengan menyimpan fileId, duration, dan
        // threadname
        for (int i = 1; i <= totalFiles; i++) {
            final int fileId = i;
            downloadExecutor.submit(() -> {
                try {
                    int duration = new Random().nextInt(3) + 1;
                    Thread.sleep(duration * 1000);
                    recordResult(fileId, duration, Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        // (6) Shutdown executor download
        // Tutup downloadExecutor agar tidak menerima tugas baru
        downloadExecutor.shutdown();

        // (7) Tunggu semua download selesai
        // Tunggu semua tugas download selesai sebelum lanjut ke proses berikutnya
        try {
            downloadExecutor.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // (8) Sinyal ke UI bahwa semua selesai, lalu shutdown UI executor
        // Ketika semua proses download sudah selesai:
        // - Tandai bahwa semua download sudah selesai dengan mengubah nilai allDone
        // - Hentikan proses uiExecutor dan tunggu hingga semua tugas selesai,
        // seperti pada downloadExecutor

        allDone = true;
        uiExecutor.shutdown();
        try {
            uiExecutor.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Mencatat total waktu proses secara keseluruhan
        long endTime = System.currentTimeMillis();
        int totalTime = (int) ((endTime - startTime) / 1000);

        // Header tabel
        System.out.println("--------------------------------------------------");
        System.out.println("                  Detailed Report                 ");
        System.out.println("--------------------------------------------------");
        System.out.printf("%-8s | %-18s | %-8s | %-8s%n",
                "File ID", "Thread", "Duration", "Status");
        System.out.println("--------------------------------------------------");

        // Urutkan hasil berdasarkan fileId
        results.sort(Comparator.comparingInt(r -> r.fileId));

        // Tampilan hasil setiap proses download dalam bentuk table
        for (Result r : results) {
            System.out.printf("%-8d | %-18s | %-8s | %-8s%n",
                    r.fileId, r.threadName, r.duration + "s", r.status);
        }

        // Ringkasan Proses
        System.out.println("--------------------------------------------------");
        System.out.println("                     Summary                      ");
        System.out.println("--------------------------------------------------");
        System.out.println("Successful downloads : " + successfulDownloads);
        System.out.println("Failed downloads     : " + (totalFiles - successfulDownloads));
        System.out.printf("Total time           : %ds%n", totalTime);
    }
}

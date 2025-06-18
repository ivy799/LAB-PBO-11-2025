package TypeRacer;

import java.util.ArrayList;
import java.util.Random;

public class TypeRacer {
    private String wordsToType;
    private ArrayList<Typer> rareContestant = new ArrayList<>();
    private ArrayList<Result> rareStanding = new ArrayList<>();

    public String getWordsToType() {
        return wordsToType;
    }

    public ArrayList<Typer> getRareContestant() {
        return rareContestant;
    }

    // Bisa diganti sesuai keinginan masing-masing
    private String[] wordsToTypeList = {
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque interdum est imperdiet mi auctor auctor. Nunc sed neque bibendum, ornare tortor sit amet, fringilla diam. Donec lacinia euismod purus, eget luctus nulla euismod eget. Suspendisse ac tortor sit amet lacus consequat tincidunt non a lacus. Nullam quis arcu orci. Nulla sagittis tincidunt velit, quis facilisis massa imperdiet varius. Etiam sollicitudin suscipit imperdiet. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Donec eleifend ultricies est. Praesent."

    };

    public void setNewWordsToType() {
        Random random = new Random();
        int angkaRandom = random.nextInt(wordsToTypeList.length);
        wordsToType = wordsToTypeList[angkaRandom];
    }

    // TODO (4)
    // Buat method addResult yang mana digunakan untuk menambahkan typer yang
    // telah selesai (mengetik semua kata), ke dalam list race standing.
    public synchronized void addResult(Result result) {
        rareStanding.add(result);
    }

    private void printRaceStanding() {
        System.out.println("\nKlasemen Akhir Type Racer");
        System.out.println("=========================\n");

        // TODO (5)
        // Tampilkan klasemen akhir dari kompetisi, dengan format
        // {posisi}. {nama} = {waktu penyelesaian dalam detik} detik
        rareStanding.sort((r1, r2) -> Integer.compare(r1.getFinishTime(), r2.getFinishTime()));
        for (int i = 0; i < rareStanding.size(); i++) {
            Result r = rareStanding.get(i);
            System.out.println((i + 1) + ". " + r.getName() + " = " + r.getFinishTime() + " detik");
        }
    }

    public void startRace() {
        // TODO (6)
        // Jalankan kompetisi untuk tiap kontestan
        for (Typer t : rareContestant) {
            t.start();
        }
    }

    // TODO (7)
    // selama semua peserta belum selesai maka tampilkan typing progress-nya setiap
    // 2 detik, dengan format:
    // Typing Progress ...
    // ===================
    // {nama kontestan} => {text yang telah dia ketik}
    // {nama kontestan} => {text yang telah dia ketik}
    // {nama kontestan} => {text yang telah dia ketik}
    public void displayRaceStandingPeriodically() throws InterruptedException {
        while (rareStanding.size() < rareContestant.size()) {
            System.out.println("\nTyping Progress...");
            System.out.println("===================");
            for (Typer t : rareContestant) {
                System.out.println("-" + t.getBotName() + " => " + t.getWordsTyped());
            }
            Thread.sleep(2000);
        }

        // TODO (8)
        // Setelah semua typer selesai, tampilkan race standing setelah semua typer
        // selesai
        printRaceStanding();
    }
}
//package TypeRacer;

class Typer extends Thread {
    private String botName, wordsTyped;
    private double wpm;
    private TypeRacer typeRacer;

    public Typer(String botName, double wpm, TypeRacer typeRacer) {
        this.botName = botName;
        this.wpm = wpm;
        this.wordsTyped = "";
        this.typeRacer = typeRacer;
    }

    public void setBotName(String botName) {
        this.botName = botName;
    }

    public void setWpm(double wpm) {
        this.wpm = wpm;
    }

    public void addWordsTyped(String newWordsTyped) {
        this.wordsTyped += newWordsTyped + " ";
    }

    public String getWordsTyped() {
        return wordsTyped;
    }

    public String getBotName() {
        return botName;
    }

    public double getWpm() {
        return wpm;
    }

    @Override
    public void run() {
        String[] wordsToType = typeRacer.getWordsToType().split(" ");

        // TODO (1)
        // Buatlah variable howLongToType yang memuat waktu yang diperlukan typer
        // Waktu per kata (ms) = (60 detik / wpm) * 1000
        long howLongToType = (long) ((60.0 / wpm) * 1000);

        // TODO (2)
        // Buatlah perulangan untuk menambahkan kata dengan method
        // addWordToTyped setelah interval waktu sebanyak howLongToType
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < wordsToType.length; i++) {
            String word = wordsToType[i];
            try {
                Thread.sleep(howLongToType);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.addWordsTyped(word);
        }

        this.addWordsTyped("(Selesai)");

        // TODO (3)
        // Tambahkan typer yang telah selesai mengetik semua kata ke list typeRaceTabel
        // yang ada di class typeRacer.
        long finishTime = System.currentTimeMillis();
        long timeTaken = finishTime - startTime;
        typeRacer.addResult(new Result(this, timeTaken));
    }
}
